package jlAST.instruction;

import java.util.ArrayList;

import codeGeneration.FJP;
import codeGeneration.P;
import codeGeneration.UJP;
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
		if (e.verifyTypes() && e.getType().equals(Type.BoolType)) {
			if (elseList == null) {
				return ifList.verifyTypes();
			} else {
			return ifList.verifyTypes() && elseList.verifyTypes();
			}
		}
		System.err.println("Expression not bool:  " + e.getLine() + ". Column: " + e.getCol() + ".");	
		return false;
	}

	@Override
	public ArrayList<P> generateCode() {
		ArrayList<P> list = new ArrayList<P>();
		list.addAll(e.generateCode());
		if (elseList != null) {
			ArrayList<P> listElseP = elseList.generateCode();
			list.add(new FJP(listElseP.get(0), 0));
			list.addAll(ifList.generateCode());
			list.add(new UJP(listElseP.get(listElseP.size() - 1), 1));
			list.addAll(listElseP);
		} else {
			ArrayList<P> listIfP = ifList.generateCode();
			list.add(new FJP(listIfP.get(listIfP.size() - 1), 1));
			list.addAll(listIfP);
		}
        return list;
	}
}
