package jlAST.instruction;

import java.util.ArrayList;

import codeGeneration.P;
import codeGeneration.STO;
import identifiersTable.IdentifiersTable;
import jlAST.expression.*;

public class Assign extends Instruction {

	private Variable i;
	private Expression e;

	public Assign(Variable i, Expression e, int line, int col) {
		super(line, col);
		this.i = i;	
		this.e = e;
	}

	@Override
	public boolean identifyNode(IdentifiersTable t) {
		return i.identifyNode(t) && e.identifyNode(t);
	}

	@Override
	public boolean verifyTypes() {
		if (i.isConst()) {
			System.err.println("Error Indentifier " + i.toString()	+
					" is a constant. Line: " + getLine() + ". Column: " + getCol() + ".");
			return false;
		} if (!i.verifyTypes()) {
			System.err.println("Error Indentifier " + i.toString()	+
					" is not a correct type. Line: " + getLine() + ". Column: " + getCol() + ".");
			return false;
		} if (!e.verifyTypes()) {
			System.err.println("Right expression is not a correct type. Line: " +
					getLine() + ". Column: " + getCol() + ".");
			return false;
		} if (!i.getType().equals(e.getType())) {
			System.err.println("Types in the assignament do not match. " +
					getLine() + ". Column: " + getCol() + ".");
			return false;
		}
		return true;
	}

	@Override
	public ArrayList<P> generateCode() {
		ArrayList<P> list = new ArrayList<P>();
		list.addAll(i.generateCodeLeft());
        list.addAll(e.generateCode());
        list.add(new STO());
        return list;
	}
}
