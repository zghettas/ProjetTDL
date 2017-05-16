/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.LinkedList;

import fr.n7.stl.block.ast.Assignable;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.FieldDeclaration;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * @author Marc Pantel
 *
 */
public class FieldAssignmentImpl extends FieldAccessImpl implements Assignable {

	/**
	 * Construction for the implementation of a record field assignment expression Abstract Syntax Tree node.
	 * @param _record Abstract Syntax Tree for the record part in a record field assignment expression.
	 * @param _name Name of the field in the record field assignment expression.
	 */
	public FieldAssignmentImpl(Expression _record, String _name) {
		super(_record, _name);
	}

	/**
	 * Construction for the implementation of a record field assignment expression Abstract Syntax Tree node.
	 * @param _record Abstract Syntax Tree for the record part in a record field assignment expression.
	 * @param _field Abstract Syntax Tree for the field declaration in a record field assignment expression.
	 */
	public FieldAssignmentImpl(Expression _record, FieldDeclaration _field) {
		super(_record, _field);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.impl.FieldAccessImpl#getCode(fr.n7.stl.tam.ast.TAMFactory)
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
