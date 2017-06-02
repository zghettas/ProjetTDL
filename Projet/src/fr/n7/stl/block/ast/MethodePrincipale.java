package fr.n7.stl.block.ast;

import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

public interface MethodePrincipale {

	boolean checkType();

	int allocateMemory(Register _reg, int _offset);

	Fragment getCode(TAMFactory _factory);
	
	String toString();
}
