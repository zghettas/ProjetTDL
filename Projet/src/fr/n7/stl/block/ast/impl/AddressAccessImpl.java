package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

public class AddressAccessImpl implements Expression {

	private Expression address;

	/**
	 * Construction for the implementation of an address element access expression Abstract Syntax Tree node.
	 * @param _address Abstract Syntax Tree for the address expression.
	 */
	public AddressAccessImpl(Expression _address) {
		this.address = _address;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "&{" + this.address + "}";
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	public Type getType() {
		return new PointerTypeImpl(this.address.getType());
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	public Fragment getCode(TAMFactory _factory) {
		return this.address.getCode(_factory);
	}

}