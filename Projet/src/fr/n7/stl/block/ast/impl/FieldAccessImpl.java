/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.LinkedList;
import java.util.Optional;

import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.FieldDeclaration;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for accessing a field in a record.
 * @author Marc Pantel
 *
 */
public class FieldAccessImpl implements Expression {

	protected Expression record;
	protected String name;
	protected FieldDeclaration field;

	/**
	 * Construction for the implementation of a record field access expression Abstract Syntax Tree node.
	 * @param _record Abstract Syntax Tree for the record part in a record field access expression.
	 * @param _name Name of the field in the record field access expression.
	 */
	public FieldAccessImpl(Expression _record, String _name) {
		this.record = _record;
		this.name = _name;
	}

	/**
	 * Construction for the implementation of a record field access expression Abstract Syntax Tree node.
	 * @param _record Abstract Syntax Tree for the record part in a record field access expression.
	 * @param _field Abstract Syntax Tree for the field declaration in a record field access expression.
	 */
	public FieldAccessImpl(Expression _record, FieldDeclaration _field) {
		this.record = _record;
		this.field = _field;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.record + "." + this.name;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
		if (this.field == null) {
			Optional<FieldDeclaration> lookup_field = ((RecordTypeImpl) this.record.getType()).get(this.name);
			if (lookup_field.isPresent())
				return lookup_field.get().getType();
		}
		return this.field.getType();
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment fragment = _factory.createFragment();
		LinkedList<String> fields_names = new LinkedList<String>();
		Expression largest_record_exp = this;
		
		while (largest_record_exp instanceof FieldAccessImpl) {
			fields_names.addFirst(((FieldAccessImpl) largest_record_exp).name);
			largest_record_exp = ((FieldAccessImpl) largest_record_exp).record;
		}
		
		int offset = ((VariableUseImpl) largest_record_exp).declaration.getOffset();
		RecordTypeImpl current_record = (RecordTypeImpl) largest_record_exp.getType();
		
		for (String lookup_field : fields_names) {
			for (FieldDeclaration fd : current_record.fields) {
				if (fd.getName().equals(lookup_field)) {
					FieldDeclaration temp = current_record.get(lookup_field).orElse(null);
					if (temp.getType() instanceof RecordTypeImpl)
						current_record = (RecordTypeImpl) temp.getType();
					break;
				} else
					offset += fd.getType().length();
			}
		}
		fragment.add(_factory.createLoad(((VariableUseImpl) largest_record_exp).declaration.getRegister(), offset, 1));;
		return fragment;
	}

}
