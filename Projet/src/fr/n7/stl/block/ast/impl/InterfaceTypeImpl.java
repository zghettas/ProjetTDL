package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.AtomicType;
import fr.n7.stl.block.ast.Interface;
import fr.n7.stl.block.ast.InterfaceType;
import fr.n7.stl.block.ast.Type;

public class InterfaceTypeImpl implements InterfaceType {

	private Interface interf;
	
	public InterfaceTypeImpl(Interface _interface) {
		this.interf = _interface;
	}
	
	public Interface getInterface() {
		return this.interf;
	}

	@Override
	public boolean equalsTo(Type _other) {
		if (_other instanceof InterfaceTypeImpl)
			return interf.getName().equals(((InterfaceTypeImpl) _other).interf.getName());
		return false;
	}

	@Override
	public boolean compatibleWith(Type _other) {
		if (_other instanceof InterfaceTypeImpl) {
			InterfaceTypeImpl other = (InterfaceTypeImpl) _other;
			if (interf.getName().equals(other.interf.getName()))
				return true;
			for (Interface interface_heritee : interf.getInterfaces()) {
				if (interface_heritee.getName().equals(other.interf.getName()))
					return true;
			}
		}
		return false;
	}

	@Override
	public Type merge(Type _other) {
		if (_other instanceof InterfaceTypeImpl) {
			InterfaceTypeImpl other = (InterfaceTypeImpl) _other;
			if (interf.getName().equals(other.interf.getName()))
				return new InterfaceTypeImpl(interf);
			for (Interface interface_heritee : interf.getInterfaces()) {
				if (interface_heritee.getName().equals(other.interf.getName()))
					return new InterfaceTypeImpl(interface_heritee);
			}
		}
		return AtomicType.ErrorType;
	}

	@Override
	public int length() {
		return 1;
	}
	
	public String toString() {
		return interf.toString();
	}

}
