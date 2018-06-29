package serum.codegen;

/**
 * @author David Rubio
 */
public class Jump extends PInstruction {

    /**Instrucción a la que saltar (quizá se salte a la siguiente).*/
    private PInstruction instruction;

    /**Determina si el salto es condicional o no.*/
    private boolean conditional;

    /**Determina si saltar a la instrucción dada o a su siguiente.*/
    private boolean toThisInstruction;


    public Jump(PInstruction instruction, boolean conditional, boolean toThisInstruction) {
        this.instruction = instruction;
        this.conditional = conditional;
        this.toThisInstruction = toThisInstruction;
    }

    @Override
    public String toString() {
        String string;
        if (conditional)
            string = "fjp ";
        else
            string = "ujp ";
        int position = instruction.getPosition();
        if (!toThisInstruction) position++;
        return super.toString() + string + position + ";\n";
    }
}
