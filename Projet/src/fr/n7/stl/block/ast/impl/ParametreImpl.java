package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.Parametre;
import fr.n7.stl.block.ast.Type;


public class ParametreImpl implements Parametre {
	
	private String nom;
	private Type type;

	public ParametreImpl(String _nom, Type _type) {
		this.nom = _nom;
		this.type = _type;
	}

	public Type getType() {
		return this.type;	
	}

	@Override
	public String getName() {
		return this.nom;
	}

}
