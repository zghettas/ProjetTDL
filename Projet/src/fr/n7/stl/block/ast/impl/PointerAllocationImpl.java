package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

public class PointerAllocationImpl implements Expression {

	private Type type;
	
	public PointerAllocationImpl(Type _type) {
		this.type = _type;
	}
	
	@Override
	public Type getType() {
		return new PointerTypeImpl(this.type);
	}
	
	@Override
	public String toString() {
		return "new " + this.type.toString();
	}

	@Override
	public Fragment getCode(TAMFactory _factory) {
		return _factory.createFragment();
	}

}
