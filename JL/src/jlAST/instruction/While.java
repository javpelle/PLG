package jlAST.instruction;

import java.util.ArrayList;

import codeGeneration.FJP;
import codeGeneration.P;
import codeGeneration.UJP;
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
		if (e.verifyTypes() && e.getType().equals(Type.BoolType)) {
			return i.verifyTypes();
		}
		System.err.println("Expression not bool:  " + e.getLine() + ". Column: " + e.getCol() + ".");	
		return false;
	}

	@Override
	public ArrayList<P> generateCode() {
		ArrayList<P> list = new ArrayList<P>();
		list.addAll(e.generateCode());
		ArrayList<P> listWhileP = i.generateCode();
		list.add(new FJP(listWhileP.get(listWhileP.size() - 1), 2));
		list.addAll(listWhileP);
		list.add(new UJP(list.get(0), 0));
		return list;
	}

}
