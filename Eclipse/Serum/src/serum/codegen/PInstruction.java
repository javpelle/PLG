package serum.codegen;

/**Todas las intrucciones de codigo p implementan esta interfaz.
 *
 * @author David Rubio
 */
public abstract class PInstruction {

    /**Posición de está instrucción.*/
    private int position;

    public int getPosition() { return position; }

    public void setPosition(int position) { this.position = position; }

    @Override
    public String toString() {
        return String.format("{%1$3d} ", position); }
}
