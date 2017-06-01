package fr.n7.stl.util;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;

import fr.n7.stl.block.ast.Declaration;
import fr.n7.stl.block.ast.ForbiddenDeclarationException;
import fr.n7.stl.block.ast.HierarchicalScope;
import fr.n7.stl.block.ast.Parametre;

public class SymbolTableSignature implements HierarchicalScope<Declaration> {

	private Map<String, Map<String, Declaration>> declarations;
	private Optional<SymbolTable> context;
	private LinkedList<Parametre> parametres;
	
	public SymbolTableSignature() {
		this.declarations = new HashMap<String, Map<String, Declaration>>();
		this.context = Optional.empty();
		this.parametres = new LinkedList<Parametre>();
		
	}
	
	@Override
	public Optional<Declaration> get(String _name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(String _name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean accepts(Declaration _declaration) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void register(Declaration _declaration) throws ForbiddenDeclarationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean knows(String _name) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean registerSignature(String nomInterface, Signature signature){
		this.parametres = signature.getParametres();
		
	}
	}
	
}
