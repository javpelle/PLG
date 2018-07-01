package jlAST;

import identifiersTable.IdentifiersTable;
import jlAST.dec.decVar.DecVarList;
import jlAST.instruction.InstructionList;

public class Main extends ASTNode {

	private DecVarList varList;
	private InstructionList instructionList;

	public Main(int line, int col, DecVarList varList,
			InstructionList instructionList) {
		super(line, col);
		this.varList = varList;
		this.instructionList = instructionList;
	}

	@Override
	public boolean identifyNode(IdentifiersTable t) {
		return varList.identifyNode(t) && instructionList.identifyNode(t);
	}

	@Override
	public boolean verifyTypes() {
		return instructionList.verifyTypes();
	}

}
