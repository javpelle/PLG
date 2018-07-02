package jlAST.expression;

import jlAST.ASTNode;
import jlAST.types.Type;

public abstract class Expression extends ASTNode {

	/**
	 * Constructora para la contrusccion de variables array.
	 */
	protected Expression(){}
	
	public Expression(int line, int col) {
		super(line, col);
	}
	
	abstract public Type getType();

}
