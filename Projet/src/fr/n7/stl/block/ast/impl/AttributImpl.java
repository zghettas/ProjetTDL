package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.Attribut;
import fr.n7.stl.block.ast.DroitAcces;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

public class AttributImpl implements Attribut {

	String nomAttribut;
	Type type;
	boolean estStatique = false;
	DroitAcces droitAcces = DroitAcces.PUBLIC;
	
	public AttributImpl(String _nom, Type _type) {
		this.nomAttribut = _nom;
		this.type = _type;
	}

	@Override
	public String getName() {
		return this.nomAttribut;
	}

	@Override
	public Type getType() {
		return this.type;
	}

	@Override
	public void setStatic() {
		this.estStatique = true;
	}

	@Override
	public void setDroitAcces(DroitAcces _droitAcces) {
		this.droitAcces = _droitAcces;
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
