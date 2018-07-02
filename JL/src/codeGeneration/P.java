package codeGeneration;

public abstract class P {
	
	/**
	 * identifica cada instrucción con un entero correspondiente
	 * a su orden de ejecucion.
	 */
	private int numInstruction;
	
	/**
	 * @return Devuelve la instruccion como codigo en P.
	 */
	abstract public String code();
	
	public int getNumInstruction() {
		return numInstruction;
	}
	
	public void setNumInstruction(int numInstruction) {
		this.numInstruction = numInstruction;
	}
}
