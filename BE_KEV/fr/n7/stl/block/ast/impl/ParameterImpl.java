package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.Type;



public class ParameterImpl implements Parameter {
	private String nom;
	private Type type;

	public ParameterImpl(String _nom, Type _type) {
		this.nom = _nom;
		this.type = _type;
	}

	public String getNom() {
		return this.nom;
	}

	public Type getType() {
		return this.type;	
	}
}
