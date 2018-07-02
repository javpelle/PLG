package codeGeneration;

public class FJP extends P {
	private P p;
	private int nextInstruction;
	
	public FJP (P p, int nextInstruction) {
		this.p = p;
		this.nextInstruction = nextInstruction; 
	}
	@Override
	public String code() {
		return "fjp " + Integer.toString(p.getNumInstruction() + nextInstruction) + ";\n";
	}
	
}
