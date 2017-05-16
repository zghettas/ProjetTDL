/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import fr.n7.stl.block.ast.FunctionDeclaration;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.block.ast.Block;

/**
 * Implementation of the Abstract Syntax Tree node for Function Declaration.
 * @author Marc Pantel
 *
 */
public class FunctionDeclarationImpl implements FunctionDeclaration {

	private String name;
	private Type type;
	private List<Parameter> parameters;
	private Block block;

	public FunctionDeclarationImpl(String _identificateur, Type _typeRetour, Iterable<Parameter> _parameters, Block _block) {
		this.name = _identificateur;
		this.type = _typeRetour;
		for (Parameter _parameter : _parameters) {
			this.parameters.add(_parameter);
		}
		this.block = _block
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Declaration#getName()
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.FieldDeclaration#getType()
	 */
	@Override
	public Type getType() {
		return this.type;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String resParameters;
		for (Parameter _parameter : parameters) {
			resParameters = resParameters + _parameter.getType().toString() + _parameter.getNom();
		}
		return "Public " + this.type + " " + this.name + "(" + resParameters + ")";
	}

}
