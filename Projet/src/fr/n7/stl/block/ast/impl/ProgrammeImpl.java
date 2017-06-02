package fr.n7.stl.block.ast.impl;

import java.util.LinkedList;

import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.Interface;
import fr.n7.stl.block.ast.MethodePrincipale;
import fr.n7.stl.block.ast.Programme;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

public class ProgrammeImpl implements Programme {
	
	private LinkedList<Interface> interfaces;
	private LinkedList<Classe> classes;
	private MethodePrincipale methodePrincipale;
	private int offset;
	
	public ProgrammeImpl(LinkedList<Interface> _interfaces, LinkedList<Classe> _classes, MethodePrincipale _methodePrincipale) {
		this.interfaces = _interfaces;
		this.classes = _classes;
		this.methodePrincipale = _methodePrincipale;
	}
	
	@Override
	public boolean checkType() {
		for (Interface interf : interfaces) {
			if (interf.checkType()) continue;
			else return false;
		}
		for (Classe classe : classes) {
			if (classe.checkType()) continue;
			else return false;
		}
		if (methodePrincipale.checkType()) return true;
		
		return false;
	}

	@Override
	public int allocateMemory(Register _reg, int _offset) {
		int dep = _offset;
		
		for (Interface interf : interfaces)
			dep += interf.allocateMemory(_reg, dep);
		
		for (Classe classe : classes)
			dep += classe.allocateMemory(_reg, dep);
		
		dep += methodePrincipale.allocateMemory(_reg, dep);
		
		offset = dep - _offset;
		
		return 0;
	}

	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment fragment = _factory.createFragment();

		for (Interface interf : interfaces)
			fragment.append(interf.getCode(_factory));
		
		
		for (Classe classe : classes)
			fragment.append(classe.getCode(_factory));
		
		fragment.append(methodePrincipale.getCode(_factory));
		
        fragment.add(_factory.createHalt());
		return fragment;
	}
	
	public String toString() {
		String res = "";
		for (Interface interf : interfaces) {
			res += interf.toString() + "\n";
		}
		for (Classe classe : classes) {
			res += classe.toString() + "\n";
		}
		res += methodePrincipale.toString();
		return res;
	}

}
