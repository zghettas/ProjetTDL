package fr.n7.stl.block.ast.impl;

import java.util.List;

import fr.n7.stl.block.ast.AtomicType;
import fr.n7.stl.block.ast.Parametre;
import fr.n7.stl.block.ast.Signature;
import fr.n7.stl.block.ast.Type;

public class SignatureImpl implements Signature {

	protected List<Parametre> parametres;
	protected String nomInterface;
	protected Type typeRetour;
	protected String nomSignature;
	
	public SignatureImpl(String nomInterface, String nomSignature, List<Parametre> parametres ) {
		this.parametres = parametres;
		this.nomInterface = nomInterface;
		this.nomSignature = nomSignature;
		this.typeRetour = AtomicType.VoidType;
	}
	
	public SignatureImpl(String nomInterface, String nomSignature, Type typeRetour, List<Parametre> parametres ) {
		this.parametres = parametres;
		this.nomInterface = nomInterface;
		this.nomSignature = nomSignature;
		this.typeRetour = typeRetour;
	}
	
	@Override
	public String getInterfaceName() {
		return this.nomInterface;
	}

	@Override
	public String getName() {
		return this.nomSignature;
	}

	@Override
	public List<Parametre> getParametres() {
		return this.parametres;
	}

	@Override
	public String toString() {
		String res = this.typeRetour.toString() + " " + this.nomSignature + "(";
		for (int i = 0; i < this.parametres.size(); i++) {
			res += this.parametres.get(i).toString();
			if (i != this.parametres.size() - 1) 
				res += ", ";
		}
		return res + ");";
	}
}
