package codeGeneration;

public class CONST extends P {

	private String value;

	public CONST(String value) {
		this.value = value;
	}

	public String code() {
		return "ldc " + value + ";\n";
	}

}
