package jlAST.instruction;

import jlAST.expresion.Expresion;

public class If extends Instruction {
	 protected Expresion e;
	 protected Instruction i;

	  public If(Expresion e, Instruction i, int line, int col) {
	    super(line, col);
	    this.e=e; 
	    this.i=i; 
	  }
}
