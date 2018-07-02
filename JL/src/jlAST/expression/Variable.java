package jlAST.expression;

import java.util.ArrayList;

import codeGeneration.CONST;
import codeGeneration.IND;
import codeGeneration.P;
import jlAST.dec.Dec;
import jlAST.types.Type;
import identifiersTable.IdentifiersTable;

public class Variable extends Expression {
	private String s;
	private Dec dec;
	protected int dimensiones; //Numero de corchetes de la variable ( si no tiene, es 0)

	protected Variable() {
		dimensiones = 0;
	}

	public Variable(String s, int line, int col) {
		super(line, col);
		this.s = s;
		dimensiones = 0;
	}

	public String toString() {
		return s;
	}

	@Override
	public boolean identifyNode(IdentifiersTable t) {
		dec = t.buscaId(s);
		if (dec == null) {
			System.err.println("Error Indentifier " + s	+
					" not declared. Line: " + getLine() + ". Column: " + getCol() + ".");
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Queremos que la declaracion asociada no tenga dimensiones, pues es una variable 
	 * sin corchetes
	 */
	public boolean verifyTypes() {
		return dec.getType().getDimensiones() == 0;
	}
	
	/**
	 * Verifica que todas las expresiones de los corchetes son correctas, pero como no tenemos
	 * entonces es true
	 *
	 */
	public boolean verifyExpression() {
		return true;
	}

	@Override
	public Type getType() {
		return dec.getPrimitiveType();
	}
	
	public Type getTypeIxa() {
		return dec.getType();
	}

	/**
	 * Devuelve las dimensiones de la declaracion a la que hace referencia esta variable
	 */
	public int getTypeDimensiones() {
		return dec.getType().getDimensiones();
	}
	
	public boolean isConst() {
		return dec.isConst();
	}

	public int getDimensiones() {
		return dimensiones;
	}

	@Override
	public ArrayList<P> generateCode() {
		ArrayList<P> list = new ArrayList<P>();
		if (dec.isConst()) {
			list.add(new CONST(dec.getValue()));
		} else {
			list.addAll(generateCodeLeft());
			list.add(new IND());
		}		
        return list;
	}

    /**
     * Generar codigo en caso de que estemos a la izquierda de una asignacion
     **/
    public ArrayList<P> generateCodeLeft() {
    	// No puede ser CONST, se encarga la verifiacion de tipos.
    	ArrayList<P> list = new ArrayList<P>();
        list.add(new CONST(Integer.toString(dec.getRho())));
        return list;
    }
	
}
