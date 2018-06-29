package serum.codegen;

import serum.ASTNodes.ASTNode;

/**
 * @author David Rubio
 */
public class Stop extends PInstruction{

    @Override
    public String toString() {
        return super.toString() + "stp;\n";
    }
}
