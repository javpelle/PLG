package serum.codegen;

/**
 * Esta intrucción carga constantes o direcciones (ldc o lda).
 * @author David Rubio
 */
public class LoadConstant extends PInstruction {

    /**Texto que representa la constante a cargar.*/
    private String constant;

    public LoadConstant(int address) { this.constant = Integer.toString(address); }

    public LoadConstant(boolean b) { this.constant = Boolean.toString(b); }

    @Override
    public String toString() { return super.toString() + "ldc " + constant +";\n"; }
}
