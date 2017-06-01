package fr.n7.stl.block.ast;

import java.util.List;

import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

public interface Classe {
	
	public List<Methode> getMethodes();
	
	public List<Attribut> getAttributs();
	
	public List<Constructeur> getConstructeurs();
	
	public List<Attribut> getAttributsStatiques();

	public boolean checkType();

	public int allocateMemory(Register _reg, int dep);

	public Fragment getCode(TAMFactory _factory);
	
}
