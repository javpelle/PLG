package jlAST.decVar;

import jlAST.ASTNode;

public class Identifier extends ASTNode {
	  private String s;

	  public Identifier(String s, int line, int col) { 
	    super(line, col);
	    this.s=s;
	  }


	  public String toString(){
	    return s;
	  }

}
