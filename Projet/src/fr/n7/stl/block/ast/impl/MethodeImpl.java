package fr.n7.stl.block.ast.impl;

import java.util.LinkedList;

import fr.n7.stl.block.ast.AtomicType;
import fr.n7.stl.block.ast.Block;
import fr.n7.stl.block.ast.DroitAcces;
import fr.n7.stl.block.ast.Methode;
import fr.n7.stl.block.ast.Parametre;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

public class MethodeImpl implements Methode {

	private String nomMethode;
	private Type typeRetour;
	private LinkedList<Parametre> parametres;
	private Block bloc;
	private boolean estStatique;
	private DroitAcces droitAcces = null;
	
	public MethodeImpl(String _nomMethode, Type _typeRetour, LinkedList<Parametre> _params, Block _bloc) {
		this.nomMethode = _nomMethode;
		this.typeRetour = _typeRetour;
		this.parametres = _params;
		this.bloc = _bloc;
		this.estStatique = false;
	}

	public MethodeImpl(String _nomMethode, LinkedList<Parametre> _params, Block _bloc) {
		this.nomMethode = _nomMethode;
		this.typeRetour = AtomicType.VoidType;
		this.parametres = _params;
		this.bloc = _bloc;
		this.estStatique = false;
	}

	@Override
	public String getName() {
		return nomMethode;
	}

	@Override
	public Type getType() {
		return typeRetour;
	}

	@Override
	public void setStatic() {
		estStatique = true;
	}
	
	@Override
	public void setDroitAcces(DroitAcces _droitAcces) {
		droitAcces = _droitAcces;
	}

	@Override
	public boolean checkType() {
		return bloc.checkType();
	}

	@Override
	public int allocateMemory(Register _register, int _offset) {
		return 0;
	}

	@Override
	public Fragment getCode(TAMFactory _factory) {
		return _factory.createFragment();
	}
	
	@Override
	public String toString() {
		String res = (droitAcces == DroitAcces.PUBLIC) ? "public " : (droitAcces == DroitAcces.PRIVATE) ? "private " : "protected ";
		res += typeRetour.toString() + " " + nomMethode.toString() + "(";
		for (int i = 0; i < parametres.size(); i++) {
			Parametre parametre = parametres.get(i);
			res += parametre.toString();
			if (i != parametres.size() - 1) {
				res += ", ";
			}
		}
		res += ") { \n\t" + bloc.toString() + "\n}";
		return res;
	}

}
