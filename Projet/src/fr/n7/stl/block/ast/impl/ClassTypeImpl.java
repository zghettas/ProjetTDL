package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.AtomicType;
import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.Interface;
import fr.n7.stl.block.ast.Type;

public class ClassTypeImpl implements Type {

	private Classe classe;
	
	public ClassTypeImpl(Classe _classe) {
		this.classe = _classe;
	}

	@Override
	public boolean equalsTo(Type _other) {
		if (_other instanceof ClassTypeImpl)
			return classe.getName().equals(((ClassTypeImpl) _other).classe.getName());
		return false;
	}

	@Override
	public boolean compatibleWith(Type _other) {
		if (_other instanceof ClassTypeImpl) {
			ClassTypeImpl other = (ClassTypeImpl) _other;
			if (classe.getName().equals(other.classe.getName()))
				return true;
			if (classe.getHeritage().getName().equals(other.classe.getName()))
				return true;
		}
		if (_other instanceof InterfaceTypeImpl) {
			InterfaceTypeImpl other = (InterfaceTypeImpl) _other;
			for (Interface interface_implementee : classe.getInterfaces()) {
				if (interface_implementee.getName().equals(other.getInterface().getName()))
					return true;
			}
		}
		return false;
	}

	@Override
	public Type merge(Type _other) {
		if (_other instanceof ClassTypeImpl) {
			ClassTypeImpl other = (ClassTypeImpl) _other;
			if (classe.getName().equals(other.classe.getName()))
				return new ClassTypeImpl(this.classe);
			if (classe.getHeritage().getName().equals(other.classe.getName()))
				return new ClassTypeImpl(other.classe);
		}
		if (_other instanceof InterfaceTypeImpl) {
			InterfaceTypeImpl other = (InterfaceTypeImpl) _other;
			for (Interface interface_implementee : classe.getInterfaces()) {
				if (interface_implementee.getName().equals(other.getInterface().getName()))
					return new InterfaceTypeImpl(other.getInterface());
			}
		}
		return AtomicType.ErrorType;
	}

	@Override
	public int length() {
		return 1;
	}
	
	public String toString() {
		return classe.toString();
	}

}
