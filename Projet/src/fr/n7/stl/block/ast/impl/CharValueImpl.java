package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.AtomicType;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.block.ast.Value;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

public class CharValueImpl implements Value {

	private char valeur;
	
	public CharValueImpl(String _txt) {
		valeur = _txt.charAt(1);
	}
	
	@Override
	public Type getType() {
		return AtomicType.CharacterType;
	}

	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment _code = _factory.createFragment();
		_code.add(_factory.createLoadL(valeur));
		return _code;
	}
	
	public String toString() {
		return "\"" + valeur + "\"" ;
	}

}