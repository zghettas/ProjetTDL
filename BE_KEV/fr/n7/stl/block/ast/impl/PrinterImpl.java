/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.AtomicType;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Instruction;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Library;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for a printer instruction.
 * @author Marc Pantel
 *
 */
public class PrinterImpl implements Instruction {

	private Expression parameter;

	public PrinterImpl(Expression _value) {
		this.parameter = _value;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "print " + this.parameter + ";";
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#checkType()
	 */
	@Override
	public boolean checkType() {
		return true;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#allocateMemory(fr.n7.stl.tam.ast.Register, int)
	 */
	@Override
	public int allocateMemory(Register _register, int _offset) {
		return 0;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment fragment = _factory.createFragment();
		if (this.parameter.getType().equalsTo(AtomicType.BooleanType)) {
			fragment.append(this.parameter.getCode(_factory));
			fragment.add(Library.BOut);
		}
		if (this.parameter.getType().equalsTo(AtomicType.CharacterType)) {
			fragment.append(this.parameter.getCode(_factory));
			fragment.add(Library.COut);
		}
		if (this.parameter.getType().equalsTo(AtomicType.IntegerType)) {
			fragment.append(this.parameter.getCode(_factory));
			fragment.add(Library.IOut);
		}
		if (this.parameter.getType().equalsTo(AtomicType.StringType)) { 
			fragment.append(this.parameter.getCode(_factory));
			fragment.add(Library.SOut);
		}
		if (this.parameter.getType() instanceof CoupleTypeImpl) {
			// print the first
			fragment.append(this.parameter.getCode(_factory));
			fragment.add(_factory.createPop(0, ((CoupleTypeImpl) this.parameter.getType()).getSecond().length()));
			fragment.add(Library.IOut);
			// print the second
			fragment.append(this.parameter.getCode(_factory));
			fragment.add(_factory.createPop(((CoupleTypeImpl) this.parameter.getType()).getFirst().length(), ((CoupleTypeImpl) this.parameter.getType()).getSecond().length()));
			fragment.add(Library.IOut);
		}	
		return fragment;
	}

}
