package serum.ASTNodes;

import com.sun.istack.internal.NotNull;
import serum.IdTable;
import serum.codegen.PInstruction;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jsevillamol
 */
public class InstructionList extends Instruction {

    /**Lista de instrucciones ordenadas.*/
    private List<Instruction> instructions = new ArrayList<>();
    
    public InstructionList(Instruction instruction){
        instructions.add(instruction);
    }
    
    public InstructionList(Instruction instruction, InstructionList instructionList){
        instructions.add(instruction);
        this.instructions.addAll(instructionList.instructions);
    }

    /**@return La concatenación de las p-instrucciones de cada instrucción de la lista*/
    @NotNull
    @Override
    public List<PInstruction> toCode() {
        List<PInstruction> instructionList = new LinkedList<>();
        for (Instruction instruction : instructions) {
            instructionList.addAll(instruction.toCode());
        }
        return instructionList;
    }

    @Override
    public Boolean typeCheck() {
        Boolean tipoCorrecto = true;
        for(Instruction instruction : instructions){
            tipoCorrecto = instruction.typeCheck() && tipoCorrecto;
        }
        return tipoCorrecto;
    }

    @Override
    public void identifiers(IdTable idTable) {
        //Cada lista de instrucciones es un ambito
        idTable.openBlock();
        for (ASTNode node : instructions)
            node.identifiers(idTable);
        idTable.closeBlock();
    }
}
