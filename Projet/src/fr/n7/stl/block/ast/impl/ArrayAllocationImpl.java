package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Library;
import fr.n7.stl.tam.ast.TAMFactory;

public class ArrayAllocationImpl implements Expression {

	private Expression size;
	private Type type; 
	
	public ArrayAllocationImpl(Type _type, Expression _size) {
		this.type = _type;
		this.size = _size;
	}
	
	@Override
	public Type getType() {
		return new ArrayTypeImpl(this.type);
	}

	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment fragment = _factory.createFragment();
		fragment.append(this.size.getCode(_factory));
		fragment.add(_factory.createLoadL(this.type.length()));
		fragment.add(Library.IMul);
		fragment.add(Library.MAlloc);
		return fragment;
	}
	
	public String toString() {
		return "new " + type.toString() + "[" + this.size + "]" ;
	}

}
