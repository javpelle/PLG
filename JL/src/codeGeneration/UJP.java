package codeGeneration;

public class UJP extends P {

	private P p;
	private int nextInstruction;
	
	public UJP(P p, int nextInstruction) {
		this.p = p;
		this.nextInstruction = nextInstruction; 
	}

	public String code() {
		return "ujp " + Integer.toString(p.getNumInstruction() + nextInstruction) + ";\n";
	}

}
