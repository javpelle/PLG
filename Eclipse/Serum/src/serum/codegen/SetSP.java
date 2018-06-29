package serum.codegen;

/**
 * @author David Rubio
 */
public class SetSP extends PInstruction{

    private int staticSize;

    public SetSP(int staticSize){this.staticSize = staticSize;}

    @Override
    public String toString() {
        return super.toString() + "ssp " + staticSize + ";\n";
    }
}
