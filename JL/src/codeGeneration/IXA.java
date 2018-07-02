package codeGeneration;

public class IXA extends P {

	private int ixa;

	public IXA(int ixa) {
		this.ixa = ixa;
	}

	@Override
	public String code() {
		return "ixa " + Integer.toString(ixa) + ";\n";
	}

}
