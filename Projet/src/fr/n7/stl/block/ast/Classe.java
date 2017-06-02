package fr.n7.stl.block.ast;

import java.util.List;

import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

public interface Classe {
	
	public String getName();
	
	public List<ElementClasse> getElements();
	
	public List<Interface> getInterfaces();
	
	public Classe getHeritage();
	
	public boolean checkType();

	public int allocateMemory(Register _reg, int dep);

	public Fragment getCode(TAMFactory _factory);
	
}
