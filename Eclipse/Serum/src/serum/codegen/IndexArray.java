package serum.codegen;

/**
 * @author David Rubio
 */
public class IndexArray extends PInstruction {

    /**Tamaño de cada elemento del array al que se está accediendo.*/
    private int size;

    public IndexArray(int size) { this.size = size; }

    @Override
    public String toString() {
        return super.toString() + "ixa " + size + ";\n";
    }
}

