package codeGeneration;

public class SSP extends P {
	
	private int maxSizeStack;
	
	public SSP(int maxSizeStack) {
		this.maxSizeStack = maxSizeStack;
	}
	@Override
	public String code() {
		return "ssp " + maxSizeStack + ";\n";
	}
	

}
