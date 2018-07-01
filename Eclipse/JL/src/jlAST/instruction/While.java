package jlAST.instruction;

import identifiersTable.IdentifiersTable;
import jlAST.dec.decVar.DecVarList;
import jlAST.expression.Expression;
import jlAST.types.Type;

public class While extends Instruction {

	private Expression e;
	private InstructionList i;
	private DecVarList varList;

	public While(Expression e, DecVarList varList, InstructionList i, int line,
			int col) {
		super(line, col);
		this.e = e;
		this.i = i;
		this.varList = varList;
	}

	@Override
	public boolean identifyNode(IdentifiersTable t) {
		return e.identifyNode(t) && varList.identifyNode(t)
				&& i.identifyNode(t);
	}
	
	@Override
	public boolean verifyTypes() {
		return e.getType().equals(Type.BoolType) && i.verifyTypes();
	}

}
