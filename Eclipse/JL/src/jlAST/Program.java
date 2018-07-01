package jlAST;

import identifiersTable.IdentifiersTable;
import jlAST.dec.consts.DecConstList;

public class Program extends ASTNode {
	
	private DecConstList constList;
	private Main main;
	
	public Program(int line, int col, DecConstList constList, Main main) {
		super(line, col);
		this.constList = constList;
		this.main = main;
	}

	@Override
	public boolean identifyNode(IdentifiersTable t) {
		t.abreBloque();
		boolean b = constList.identifyNode(t) && main.identifyNode(t);
		t.cierraBloque();
		return b;
	}

	@Override
	public boolean verifyTypes() {
		return main.verifyTypes();
	}
	

}
