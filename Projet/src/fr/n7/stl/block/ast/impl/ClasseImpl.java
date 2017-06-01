package fr.n7.stl.block.ast.impl;

import java.util.List;

import fr.n7.stl.block.ast.Attribut;
import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.Constructeur;
import fr.n7.stl.block.ast.Methode;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

public class ClasseImpl implements Classe {

	@Override
	public List<Methode> getMethodes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Attribut> getAttributs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Constructeur> getConstructeurs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Attribut> getAttributsStatiques() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkType() {
		// TODO Auto-generated method stub
		return false;
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
