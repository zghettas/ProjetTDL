package fr.n7.stl.block.ast;

import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

public interface Programme {

	public boolean checkType();
	
	public int allocateMemory(Register _reg, int _offset);
	
	public Fragment getCode(TAMFactory _factory);
	
}
