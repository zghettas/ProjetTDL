package fr.n7.stl.block.ast.impl;

import java.util.LinkedList;
import java.util.List;

import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.ElementClasse;
import fr.n7.stl.block.ast.Interface;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

public class ClasseImpl implements Classe {

	String nomClasse;
	Classe heritage;
	LinkedList<ElementClasse> elements;
	LinkedList<Interface> interfaces;
	
	public ClasseImpl(String _nomClasse, Classe _heritage, LinkedList<Interface> _interfaces, LinkedList<ElementClasse> _elements) {
		this.nomClasse = _nomClasse;
		this.heritage = _heritage;
		this.interfaces = _interfaces;
		this.elements = _elements;
	}

	@Override
	public String getName() {
		return this.nomClasse;
	}

	@Override
	public List<ElementClasse> getElements() {
		return this.elements;
	}

	@Override
	public List<Interface> getInterfaces() {
		return this.interfaces;
	}

	@Override
	public Classe getHeritage() {
		return this.heritage;
	}

	@Override
	public boolean checkType() {
		for (ElementClasse elementClasse : elements) {
			if (elementClasse.checkType()) continue;
			else return false;
		}
		for (Interface interf : interfaces) {
			if (interf.checkType()) continue;
			else return false;
		}
		return heritage.checkType();
	}

	@Override
	public int allocateMemory(Register _reg, int dep) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Fragment getCode(TAMFactory _factory) {
		// TODO Auto-generated method stub
		return null;
	}

}
