/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.Type;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;


/**
 * @author Marc Pantel
 *
 */
public class ArrayAllocationImpl implements Expression {

	private Type array;
	private Expression index;
	/**
	 * @param _array
	 * @param _index
	 */
	public ArrayAllocationImpl(Type _array, Expression _index) {
		this.index = _index;
		this.array = _array;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.impl.ArrayAllocationImpl#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	public Type getType() {
		return this.array;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.impl.ArrayAllocationImpl#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		throw new SemanticsUndefinedException("Semantics getCode undefined in ArrayAssignmentImpl.");
	}
	
}
