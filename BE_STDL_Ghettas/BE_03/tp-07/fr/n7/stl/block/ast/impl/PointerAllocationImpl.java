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
public class PointerAllocationImpl implements Expression {

	private Type point;
	
	/**
	 * @param _point
	 */
	public PointerAllocationImpl(Type _point) {
		this.point = _point;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.impl.PointerAllocationImpl#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	public Type getType() {
		return this.point;
	}


	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.impl.PointerAllocationImpl#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		throw new SemanticsUndefinedException("Semantics getCode undefined in ArrayAssignmentImpl.");
	}
	
}
