package jlAST.instruction;

import identifiersTable.IdentifiersTable;
import jlAST.dec.decVar.DecVarList;
import jlAST.expression.Expression;
import jlAST.types.Type;

public class If extends Instruction {
	private Expression e;
	private InstructionList ifList;
	private InstructionList elseList;
	private DecVarList ifVarList;
	private DecVarList elseVarList;

	public If(Expression e, DecVarList ifVarList, InstructionList ifList,
			DecVarList elseVarList, InstructionList elseList, int line, int col) {
		super(line, col);
		this.e = e;
		this.ifList = ifList;
		this.elseList = elseList;
		this.ifVarList = ifVarList;
		this.elseVarList = elseVarList;
	}

	public If(Expression e, DecVarList ifVarList, InstructionList ifList,
			int line, int col) {
		super(line, col);
		this.e = e;
		this.ifList = ifList;
		this.ifVarList = ifVarList;
		elseList = null;
		elseVarList = null;
	}

	@Override
	public boolean identifyNode(IdentifiersTable t) {
		if (elseList == null) {
			return e.identifyNode(t) && ifVarList.identifyNode(t)
					&& ifList.identifyNode(t);
		} else {
			return e.identifyNode(t) && ifVarList.identifyNode(t)
					&& ifList.identifyNode(t) && elseVarList.identifyNode(t)
					&& elseList.identifyNode(t);
		}

	}

	@Override
	public boolean verifyTypes() {
		if (elseList == null) {
			return e.getType().equals(Type.BoolType) && ifList.verifyTypes();
		} else {
			return e.getType().equals(Type.BoolType) && ifList.verifyTypes()
					&& elseList.verifyTypes();
		}
	}
}
