package jlAST.instruction;

import java.util.Vector;

public class InstructionList extends Instruction {

	private Vector<Instruction> instructionList;
	
	public InstructionList(int line, int col) {
		super(line, col);	
	}
	
	  public void addElement(Instruction i) {
	      // They go in backwards
		  instructionList.add(0, i);
	   }

	   public Instruction elementAt(int i)  { 
	      return (Instruction)instructionList.elementAt(i); 
	   }

	   public int size() { 
	      return instructionList.size(); 
	   }
}
