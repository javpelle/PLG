package serum.ASTNodes;

/**
 * @author jsevillamol
 */
public abstract class Instruction implements ASTNode {

    /**Fila y columna donde se encuentra este nodo en el fichero fuente.*/
    protected int row, col;

    @Override
    public void setRowAndCol(int row, int col){
        this.row = row;
        this.col = col;
    }
    
}
