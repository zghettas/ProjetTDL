package fr.n7.stl.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import fr.n7.stl.block.ast.Declaration;
import fr.n7.stl.block.ast.ForbiddenDeclarationException;
import fr.n7.stl.block.ast.HierarchicalScope;
import fr.n7.stl.block.ast.Parametre;
import fr.n7.stl.block.ast.Signature;

public class SymbolTableDouble implements HierarchicalScope<Declaration> {

	private Map<String, Map<String, List<Declaration>>> declarations;
	private Optional<SymbolTable> context;
	
	public SymbolTableDouble() {
		this.declarations = new HashMap<String, Map<String, List<Declaration>>>();
		this.context = Optional.empty();
	}
	
	@Override
	public Optional<Declaration> get(String _name) {
		return null;
	}

	@Override
	public boolean contains(String _name) {
		return false;
	}

	@Override
	public boolean accepts(Declaration _declaration) {
		return false;
	}

	@Override
	public void register(Declaration _declaration) throws ForbiddenDeclarationException {
	}

	@Override
	public boolean knows(String _name) {
		return false;
	}

	public boolean register(String nomClasseOuInterface, Declaration declaration) {
		
		String nomDeclaration = declaration.getName();
		Map<String, List<Declaration>> declarationsClasseOuInterfaceCourante = null;
		List<Declaration> declarationsMethodeOuAttributCourant = null;


		if (canRegister(nomClasseOuInterface, declaration)) {
			
			if (this.declarations.containsKey(nomClasseOuInterface)) {
				
				declarationsClasseOuInterfaceCourante = this.declarations.get(nomClasseOuInterface);
				if (declarationsClasseOuInterfaceCourante.containsKey(nomDeclaration)) {
					declarationsClasseOuInterfaceCourante.get(nomDeclaration).add(declaration);
				} else {
					declarationsMethodeOuAttributCourant = new LinkedList<Declaration>();
					declarationsMethodeOuAttributCourant.add(declaration);
					declarationsClasseOuInterfaceCourante.put(nomDeclaration, declarationsMethodeOuAttributCourant);
					this.declarations.put(nomClasseOuInterface, declarationsClasseOuInterfaceCourante);
				}
		
			} else {
				
				declarationsClasseOuInterfaceCourante = new HashMap<String, List<Declaration>>();
				declarationsMethodeOuAttributCourant = new LinkedList<Declaration>();
				declarationsMethodeOuAttributCourant.add(declaration);
				declarationsClasseOuInterfaceCourante.put(nomDeclaration, declarationsMethodeOuAttributCourant);
				this.declarations.put(nomClasseOuInterface, declarationsClasseOuInterfaceCourante);
			}
			
			return true;
			
		} else return false;
	}
	
	public boolean canRegister(String nomClasseOuInterface, Declaration declaration) {
		
		if (declaration instanceof Signature) {
			Signature signature = (Signature) declaration;
			
			String nomSignature = signature.getName();
			List<Parametre> parametres = signature.getParametres();
			
			if (this.declarations.containsKey(nomClasseOuInterface)) {
				
				Map<String, List<Declaration>> signaturesExistantes = this.declarations.get(nomClasseOuInterface);
				
				for (String nom_signature_existante : signaturesExistantes.keySet()) {
					
					// la signature à register a un autre nom, on regarde les suivantes
					if (nom_signature_existante != nomSignature) continue;
					
					// la signature à register a le même nom, il faut vérifier que ses parametres sont differents de toute
					// les surcharges existantes
					else {
						
						List<Declaration> surchages = signaturesExistantes.get(nom_signature_existante);
						
						for (Declaration surchage : surchages) {
							
							Signature surchargeCourante = (Signature) surchage;
							List<Parametre> parametresSurchargeCourante = surchargeCourante.getParametres();
							
							if (parametresSurchargeCourante.size() != parametres.size()) continue;
							
							boolean memesParametres = true;
							for (int i = 0; i < parametres.size(); i++) {
								if (parametresSurchargeCourante.get(i).getType() != parametres.get(i).getType()) {
									memesParametres = false;
									break;
								}
							}
							if (memesParametres) return false;
						}
						return true;
					}
				}
			} 
			
			return true;
			
		} else {
			if (this.declarations.containsKey(nomClasseOuInterface)) {
				
				Map<String, List<Declaration>> declarationsExistantes = this.declarations.get(nomClasseOuInterface);
				
				if (declarationsExistantes.containsKey(declaration.getName())) 
					return false;
				
				return true;
				
			} else {
				
				return true;
			}
		}	
	}
	
	public boolean knows(String nomClasseOuInterface, String ident) {
		
		if (this.declarations.containsKey(nomClasseOuInterface)) {
			
			Map<String, List<Declaration>> declarationsExistantes = this.declarations.get(nomClasseOuInterface);
			for (String identConnu : declarationsExistantes.keySet()) {
				if (ident.equals(identConnu)) {
					return true;
				}
			}
		}
		
		return false;
	}

	public Optional<Declaration> get(String nomClasseOuInterface, String ident) {
		if (this.declarations.containsKey(nomClasseOuInterface)) {
			Map<String, List<Declaration>> declarationsExistantes = this.declarations.get(nomClasseOuInterface);
			if (declarationsExistantes.containsKey(ident)) 
				return Optional.of(declarationsExistantes.get(ident).get(0));
			else
				return Optional.empty();
		} else {
			return Optional.empty();
		}
	} 
}
