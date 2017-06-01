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

public class SymbolTableSignature implements HierarchicalScope<Declaration> {

	private Map<String, Map<String, List<Declaration>>> declarations;
	private Optional<SymbolTable> context;
	
	public SymbolTableSignature() {
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

	public boolean register(String nomClasseOuInterface, Signature signature) {
		
		String nom_signature = signature.getName();
		Map<String, List<Declaration>> declarations_interface_courante = null;
		List<Declaration> surchages_signature_courante = null;


		if (canRegister(nomClasseOuInterface, signature)) {
			
			if (this.declarations.containsKey(nomClasseOuInterface)) {
				
				declarations_interface_courante = this.declarations.get(nomClasseOuInterface);
				if (declarations_interface_courante.containsKey(nom_signature)) {
					declarations_interface_courante.get(nom_signature).add(signature);
				} else {
					surchages_signature_courante = new LinkedList<Declaration>();
					surchages_signature_courante.add(signature);
					declarations_interface_courante.put(nom_signature, surchages_signature_courante);
					this.declarations.put(nomClasseOuInterface, declarations_interface_courante);
				}
		
			} else {
				
				declarations_interface_courante = new HashMap<String, List<Declaration>>();
				surchages_signature_courante = new LinkedList<Declaration>();
				surchages_signature_courante.add(signature);
				declarations_interface_courante.put(nom_signature, surchages_signature_courante);
				this.declarations.put(nomClasseOuInterface, declarations_interface_courante);
			}
			
			return true;
			
		} else return false;
	}
	
	public boolean canRegister(String nomClasseOuInterface, Signature signature) {
		
		String nom_signature = signature.getName();
		List<Parametre> parametres = signature.getParametres();
		
		if (this.declarations.containsKey(nomClasseOuInterface)) {
			
			Map<String, List<Declaration>> signatures_existantes = this.declarations.get(nomClasseOuInterface);
			
			for (String nom_signature_existante : signatures_existantes.keySet()) {
				
				// la signature à register a un autre nom, on regarde les suivantes
				if (nom_signature_existante != nom_signature) continue;
				
				// la signature à register a le même nom, il faut vérifier que ses parametres sont differents de toute
				// les surcharges existantes
				else {
					
					List<Declaration> surchages = signatures_existantes.get(nom_signature_existante);
					
					for (Declaration surchage : surchages) {
						
						Signature surchage_courante = (Signature) surchage;
						List<Parametre> parametres_surchage_courante = surchage_courante.getParametres();
						
						if (parametres_surchage_courante.size() != parametres.size()) continue;
						
						boolean memesParametres = true;
						for (int i = 0; i < parametres.size(); i++) {
							if (parametres_surchage_courante.get(i).getType() != parametres.get(i).getType()) {
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
	}
	
	public boolean knows(String nomClasseOuInterface, String ident) {
		
		if (this.declarations.containsKey(nomClasseOuInterface)) {
			
			Map<String, List<Declaration>> signatures_existantes = this.declarations.get(nomClasseOuInterface);
			for (String ident_connu : signatures_existantes.keySet()) {
				if (ident.equals(ident_connu)) {
					return true;
				}
			}
		}
		
		return false;
	}

}
