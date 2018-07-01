package jlAST.instruction;

import identifiersTable.IdentifiersTable;

import java.util.Vector;

import jlAST.ASTNode;

public class InstructionList extends ASTNode {

	private Vector<Instruction> instructionList;

	public InstructionList() {
		instructionList = new Vector<Instruction>();
	}
	
	public InstructionList(int line, int col, Instruction i) {
		super(line, col);
		instructionList = new Vector<Instruction>();
		addInstruction(i);
	}

	public void addInstruction(Instruction i) {
		instructionList.add(0, i);
	}

	public Instruction at(int i) {
		return (Instruction) instructionList.elementAt(i);
	}

	public int getSize() {
		return instructionList.size();
	}

	@Override
	public boolean identifyNode(IdentifiersTable t) {
		for (Instruction c: instructionList) {
			boolean ok = c.identifyNode(t);
			if (!ok) {
				return false;
			}
		}
		t.cierraBloque();
		return true;
	}

	@Override
	public boolean verifyTypes() {
		for (Instruction c: instructionList) {
			boolean ok = c.verifyTypes();
			if (!ok) {
				return false;
			}
		}
		return true;
	}
}
