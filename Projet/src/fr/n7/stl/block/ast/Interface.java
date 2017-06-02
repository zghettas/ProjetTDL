package fr.n7.stl.block.ast;

import java.util.LinkedList;

import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

public interface Interface {

	String getName();
	
	LinkedList<Interface> getInterfaces();
	
	LinkedList<ElementInterface> getElements();

	boolean checkType();

	int allocateMemory(Register _reg, int dep);

	Fragment getCode(TAMFactory _factory);

}
