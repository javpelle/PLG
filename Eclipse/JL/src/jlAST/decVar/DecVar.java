package jlAST.decVar;

import jlAST.ASTNode;

public class DecVar extends ASTNode {
	  private Type t;
	  private Identifier i;
	  
	  public DecVar (Type t, Identifier i, int line, int col) {
	    super(line, col);
	    this.t=t;
	    this.i=i;
	  }
}
