package jlAST.decVar;

import java.util.Vector;
import jlAST.ASTNode;

public class DecVarList extends ASTNode {
	   private Vector<DecVar> list;

	   public DecVarList(int line, int col) {
	      super(line, col);
	      list = new Vector<DecVar>(0);
	   }

	   public void addElement(DecVar v) {
	      list.addElement(v);
	   }

	   public DecVar elementAt(int i)  { 
	      return (DecVar)list.elementAt(i); 
	   }

	   public int size() { 
	      return list.size(); 
	   } 
}
