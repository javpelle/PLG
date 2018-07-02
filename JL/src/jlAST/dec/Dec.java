package jlAST.dec;

import jlAST.types.Type;

public interface Dec {
	
	public String getId();
	public boolean isConst();
	public Type getType();
	public Type getPrimitiveType();
	public int getSize();
	public int getRho();
	public String getValue();

}
