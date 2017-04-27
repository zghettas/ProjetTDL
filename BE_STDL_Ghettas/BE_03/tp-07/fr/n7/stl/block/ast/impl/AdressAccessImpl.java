package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.AtomicType;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.block.ast.Assignable;

public class AdressAccessImpl implements Expression {
	protected Assignable adress;	

	public AdressAccessImpl(Assignable _aff) {
		this.adress = _aff;
 	}	

	public String toString() {
		return "(" + this.adress + ")";
	}

	public Type getType() {
		Type type = this.adress.getType();
		if (type instanceof AdressTypeImpl) {
			return((AdressTypeImpl) type).getType();
		}
		else {
			return AtomicType.ErrorType;
		}
	}

	@Override
	public Fragment getCode(TAMFactory _factory) {
		throw new SemanticsUndefinedException("Semantics getCode undefined in ArrayAssignmentImpl.");
	}
	
}
