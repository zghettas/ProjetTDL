/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.Assignable;
import fr.n7.stl.block.ast.VariableDeclaration;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * @author Marc Pantel
 *
 */
public class VariableAssignmentImpl extends VariableUseImpl implements Assignable {

	/**
	 * Creates a variable assignment expression Abstract Syntax Tree node.
	 * @param _declaration Declaration of the assigned variable.
	 */
	public VariableAssignmentImpl(VariableDeclaration _declaration) {
		super(_declaration);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.impl.VariableUseImpl#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment fragment = _factory.createFragment();
		if (declaration.getType() instanceof PointerTypeImpl || declaration.getType() instanceof ArrayTypeImpl)
			fragment.add(_factory.createLoad(this.declaration.getRegister(), this.declaration.getOffset(), this.declaration.getType().length()));
		else
			fragment.add(_factory.createLoadA(this.declaration.getRegister(), this.declaration.getOffset()));
		return fragment;
	}
}
