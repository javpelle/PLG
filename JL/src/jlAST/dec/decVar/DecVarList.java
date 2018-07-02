package jlAST.dec.decVar;

import identifiersTable.IdentifiersTable;

import java.util.ArrayList;
import java.util.Vector;

import codeGeneration.P;
import jlAST.ASTNode;
/**
 * Lista de declaracion de variables
 */
public class DecVarList extends ASTNode {
	   private Vector<DecVar> list;

	   public DecVarList() {
	      list = new Vector<DecVar>(0);
	   }
	   
	   public DecVarList(int line, int col, DecVar v) {
		      super(line, col);
		      list = new Vector<DecVar>(0);
		      addDecVar(v);
	   }

	   public void addDecVar(DecVar v) {
	      list.add(0, v);
	   }

	   public DecVar elementAt(int i)  { 
	      return (DecVar)list.elementAt(i); 
	   }

	   public int getSize() { 
	      return list.size(); 
	   }

	@Override
	public boolean identifyNode(IdentifiersTable t) {
		t.abreBloque();
		for (DecVar c: list) {
			boolean ok = c.identifyNode(t);  //Identificamos cada declaracion de la lista
			if (!ok) {
				return false;
			}
		}
		return true;
	}

	//Los tipos en las declaraciones siempre son correctos
	public boolean verifyTypes() {
		return true;
	}

	//No generamos codigo para la declaracion de variables
	public ArrayList<P> generateCode() {
		return null;
	} 
}
