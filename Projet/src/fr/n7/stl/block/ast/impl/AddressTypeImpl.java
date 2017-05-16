package fr.n7.stl.block.ast.impl;
import fr.n7.stl.block.ast.AtomicType;
import fr.n7.stl.block.ast.Type;

public class AddressTypeImpl implements Type {

	private Type element;

	public AddressTypeImpl(Type _element) {
		this.element = _element;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#equalsTo(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public boolean equalsTo(Type _other) {
		if (!(_other instanceof AddressTypeImpl))
			return false;
		return this.element.equalsTo(((AddressTypeImpl) _other).element);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#compatibleWith(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public boolean compatibleWith(Type _other) {
		if (!(_other instanceof AddressTypeImpl))
			return false;
		return this.element.compatibleWith(((AddressTypeImpl) _other).element);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#merge(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public Type merge(Type _other) {
		if (!(_other instanceof ArrayTypeImpl))
			return AtomicType.ErrorType;
		return new AddressTypeImpl(this.element.merge(((AddressTypeImpl) _other).element));
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#length(int)
	 */
	@Override
	public int length() {
		return 1;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "&" + this.element;
	}

	/**
	 * @return Type of the element pointed.
	 */
	public Type getType() {
		return this.element;
	}
}
