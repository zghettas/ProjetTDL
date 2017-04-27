/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.AtomicType;
import fr.n7.stl.block.ast.Type;

/**
 * @author Marc Pantel
 *
 */
public class AdressTypeImpl implements Type {

	private Type element;

	public AdressTypeImpl(Type _element) {
		this.element = _element;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#equalsTo(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public boolean equalsTo(Type _other) {
		if (_other instanceof AdressTypeImpl) {
			return this.element.equalsTo(((AdressTypeImpl)_other).element);
		} else {
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#compatibleWith(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public boolean compatibleWith(Type _other) {
		if (_other instanceof AdressTypeImpl) {
			return this.element.compatibleWith(((AdressTypeImpl)_other).element);
		} else {
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#merge(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public Type merge(Type _other) {
		if (_other instanceof AdressTypeImpl) {
			return new AdressTypeImpl(this.element.merge(((AdressTypeImpl)_other).element));
		} else {
			return AtomicType.ErrorType;
		}
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#length(int)
	 */
	@Override
	public int length() {
		throw new SemanticsUndefinedException("Semantics length is not implemented in ArrayTypeImpl.");
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.element + "[]";
	}

	/**
	 * @return Type of the elements in the array.
	 */
	public Type getType() {
		return this.element;
	}

}
