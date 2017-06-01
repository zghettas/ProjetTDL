package fr.n7.stl.block.ast.impl;

import java.util.LinkedList;

import fr.n7.stl.block.ast.ElementInterface;
import fr.n7.stl.block.ast.Interface;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

public class InterfaceImpl implements Interface {

	private String name;
	private LinkedList<Interface> interfaces;
	private LinkedList<ElementInterface> elements;
	
	public InterfaceImpl(String _nom, LinkedList<Interface> _interfaces, LinkedList<ElementInterface> _elements) {
		this.name = _nom;
		this.interfaces = _interfaces;
		this.elements = _elements;
	}
	
	public String getName() {
		return this.name;
	}
	
	public LinkedList<Interface> getInterfaces() {
		return this.interfaces;
	}
	
	public LinkedList<ElementInterface> getElements() {
		return this.elements;
	}
	
	public int allocateMemory(Register _register, int _offset) {
		return 0;
	}
	
	public boolean checkType() {
		return true;
	}
	
	public Fragment getCode(TAMFactory _factory) {
		return _factory.createFragment();
	}
	
	public String toString() {
		String res = "interface " + this.getName();
		if (interfaces.size() > 0) {
			res += " extends ";
			for (int i = 0; i < interfaces.size(); i++) {
				res += interfaces.get(i).getName();
				if (i != interfaces.size() - 1) 
					res += ", ";
			}
		}
		
		res += "{\n";
		for (ElementInterface element : elements) {
			res += element.toString() + "\n";
		}
		
		return res + "}";
	}

}
