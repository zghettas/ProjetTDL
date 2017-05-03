/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import fr.n7.stl.block.ast.AtomicType;
import fr.n7.stl.block.ast.Type;

/**
 * Implementation of the Abstract Syntax Tree node for a function type.
 * @author Marc Pantel
 *
 */
public class FunctionTypeImpl implements Type {

	private Type result;
	private List<Type> parameters;

	public FunctionTypeImpl(Type _result, Iterable<Type> _parameters) {
		this.result = _result;
		this.parameters = new LinkedList<Type>();
		for (Type _type : _parameters) {
			this.parameters.add(_type);
		}
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#equalsTo(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public boolean equalsTo(Type _other) {
		if (!(_other instanceof FunctionTypeImpl))
			return false;
		if (!(this.result.equalsTo(((FunctionTypeImpl) _other).result)))
			return false;
		if (this.parameters.size() != ((FunctionTypeImpl) _other).parameters.size())
			return false;
		for (int i = 0; i < this.parameters.size(); i++) {
			if (!(this.parameters.get(i).equals(((FunctionTypeImpl) _other).parameters.get(i))))
				return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#compatibleWith(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public boolean compatibleWith(Type _other) {
		if (!(_other instanceof FunctionTypeImpl))
			return false;
		if (!(this.result.compatibleWith(((FunctionTypeImpl) _other).result)))
			return false;
		if (this.parameters.size() != ((FunctionTypeImpl) _other).parameters.size())
			return false;
		for (int i = 0; i < this.parameters.size(); i++) {
			if (!(this.parameters.get(i).compatibleWith(((FunctionTypeImpl) _other).parameters.get(i))))
				return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#merge(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public Type merge(Type _other) {
		if (!(_other instanceof FunctionTypeImpl))
			return AtomicType.ErrorType;
		if (!(this.result.compatibleWith(((FunctionTypeImpl) _other).result)))
			return AtomicType.ErrorType;
		if (this.parameters.size() != ((FunctionTypeImpl) _other).parameters.size())
			return AtomicType.ErrorType;
		Type _result = this.result.merge(((FunctionTypeImpl) _other).result);
		List<Type> _parameters = new LinkedList<Type>();
		for (int i = 0; i < this.parameters.size(); i++)
			_parameters.add(this.parameters.get(i).merge(((FunctionTypeImpl) _other).parameters.get(i)));
		FunctionTypeImpl res = new FunctionTypeImpl(_result, _parameters);
		return res;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#length(int)
	 */
	@Override
	public int length() {
		int res = this.result.length();
		for (Type t : this.parameters) {
			res += t.length();
		}
		return res;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String _result = "(";
		Iterator<Type> _iter = this.parameters.iterator();
		if (_iter.hasNext()) {
			_result += _iter.next();
			while (_iter.hasNext()) {
				_result += " ," + _iter.next();
			}
		}
		return _result + ") -> " + this.result;
	}

}
