package fr.n7.stl.block.ast.impl;

import java.util.LinkedList;

import fr.n7.stl.block.ast.Block;
import fr.n7.stl.block.ast.Constructeur;
import fr.n7.stl.block.ast.DroitAcces;
import fr.n7.stl.block.ast.Parametre;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

public class ConstructeurImpl implements Constructeur {

	private String nom;
	private LinkedList<Parametre> parametres;
	private Block bloc;
	
	public ConstructeurImpl(String _nom, LinkedList<Parametre> _params, Block _bloc) {
		this.nom = _nom;
		this.parametres = _params;
		this.bloc = _bloc;
	}

	@Override
	public String getName() {
		return this.nom;
	}

	@Override
	public Type getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setStatic() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDroitAcces(DroitAcces _droitAcces) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkType() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int allocateMemory(Register _register, int _offset) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Fragment getCode(TAMFactory _factory) {
		// TODO Auto-generated method stub
		return null;
	}

}
