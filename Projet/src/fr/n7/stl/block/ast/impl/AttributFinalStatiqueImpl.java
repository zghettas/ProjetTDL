package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

public class AttributFinalStatiqueImpl implements AttributFinalStatique {

	private String nomInterface;
	private String nomAttribut;
	private Type type;
	private Expression expr;
	
	public AttributFinalStatiqueImpl(String _nomInterface, String _nom, Type _type, Expression _expr) {
		this.nomInterface = _nomInterface;
		this.nomAttribut = _nom;
		this.type = _type;
		this.expr = _expr;
	}

	@Override
	public String getInterfaceName() {
		return nomInterface;
	}

	@Override
	public String getName() {
		return nomAttribut;
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
