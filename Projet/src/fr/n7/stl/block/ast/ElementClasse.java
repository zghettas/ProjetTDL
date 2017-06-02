package fr.n7.stl.block.ast;

import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

public interface ElementClasse extends Declaration {

	public String getName(); 
	
	public Type getType();
	
	public void setStatic();
	
	public void setDroitAcces(DroitAcces _droitAcces);

	public boolean checkType();

	public int allocateMemory(Register _register, int _offset);

	public Fragment getCode(TAMFactory _factory);	
	
	public String toString();
	
}
