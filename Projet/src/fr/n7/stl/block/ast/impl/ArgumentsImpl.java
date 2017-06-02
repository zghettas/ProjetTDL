package fr.n7.stl.block.ast.impl;

import java.util.LinkedList;
import java.util.List;

import fr.n7.stl.block.ast.Arguments;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

public class ArgumentsImpl implements Arguments {

	private List<Expression> expressions;

	public ArgumentsImpl(LinkedList<Expression> _expressions) {
		this.expressions = _expressions;
	}

	public ArgumentsImpl() {
		expressions = new LinkedList<Expression>();
	}

	@Override
	public Type getType() {
		SequenceTypeImpl res = new SequenceTypeImpl();
		for (Expression expression : expressions) {
			res.add(expression.getType());
		}
		return res;
	}

	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment fragment = _factory.createFragment();
		for (Expression expression : expressions) {
			fragment.append(expression.getCode(_factory));
		}
		return fragment;
	}
	
	public String toString() {
		String res = "(";
		for (int i = 0; i < expressions.size(); i++) {
			res += expressions.get(i).toString();
			if (i != expressions.size() - 1) 
				res += ", ";
		}
		return res + ")";
	}
}
