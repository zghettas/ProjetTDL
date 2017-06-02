package fr.n7.stl.block.ast;

import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

public interface ElementInterface extends Declaration{

	public String getInterfaceName(); 

	public boolean checkType();

	public int allocateMemory(Register _register, int _offset);

	public Fragment getCode(TAMFactory _factory);	
	
	public String toString();
}
