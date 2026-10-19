/**
 * Clase contadorChar que contiene un método con un lock
 * @author anxo
 */
public class ContadorChar {
    private int contador = 0;
    private final Object lock = new Object();

    /**
     * Método que contiene un candado y sirve para incrementar el contador local en 1
     */
    public void incrementar(){
        synchronized (lock) {
            this.contador += 1;
        }
    }

    /**
     * Método que devuelve el contadorLocal, no necesita ser synchronized ni tener candado ya que es sólo de lectura
     * @return int contador
     */
    public int getContador(){
        return this.contador;
    }
}
