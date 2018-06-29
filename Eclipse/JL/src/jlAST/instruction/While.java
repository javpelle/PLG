package jlAST.instruction;
import jlAST.expresion.Expresion;

public class While extends Instruction {

	  private Expresion e;
	  private Instruction i;

	  public While(Expresion e, Instruction i, int line, int col) {
	    super(line, col);
	    this.e=e; 
	    this.i=i; 
	  }

}
