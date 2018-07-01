package jlAST.dec.consts;

import identifiersTable.IdentifiersTable;

import java.util.Vector;

import jlAST.ASTNode;

public class DecConstList extends ASTNode {
	private Vector<DecConst> list;

	public DecConstList(int line, int col) {
		super(line, col);
		list = new Vector<DecConst>(0);
	}

	public DecConstList(int line, int col, DecConst v) {
		super(line, col);
		list = new Vector<DecConst>(0);
		addDecConst(v);
	}

	public void addDecConst(DecConst v) {
		list.add(0, v);
	}

	public DecConst elementAt(int i) {
		return (DecConst) list.elementAt(i);
	}

	public int getSize() {
		return list.size();
	}

	@Override
	public boolean identifyNode(IdentifiersTable t) {
		for (DecConst c: list) {
			boolean ok = c.identifyNode(t);
			if (!ok) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean verifyTypes() {
		return true;
	}
}
