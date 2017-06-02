package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.Block;
import fr.n7.stl.block.ast.Instruction;
import fr.n7.stl.block.ast.MethodePrincipale;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

public class MethodePrincipaleImpl implements MethodePrincipale {

	private Block bloc;
	private String nomClassePrincipale;
	private int offset;
	
	public MethodePrincipaleImpl(String _nomClassePrincipale, Block _bloc) {
		this.bloc = _bloc;
		this.nomClassePrincipale = _nomClassePrincipale;
	}
	
	@Override
	public boolean checkType() {
		return bloc.checkType();
	}

	@Override
	public int allocateMemory(Register _reg, int _offset) {
		int dep = _offset;
		for (Instruction i : bloc.getInstructions()) 
			dep += i.allocateMemory(_reg, dep);
		this.offset = dep - _offset;
		return 0;
	}

	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment fragment = _factory.createFragment();
        fragment.append(bloc.getCode(_factory));
        fragment.add(_factory.createPop(0, offset));
        return fragment;
	}
	@Override
	
	public String toString() {
		String res = "public class " + nomClassePrincipale + " {\n";
		res += "\t public static void main([] args) {\n ";
		res += "\t\t" + bloc.toString() + "\n";
		res += "\t}\n}";
		return res;
	}

}
