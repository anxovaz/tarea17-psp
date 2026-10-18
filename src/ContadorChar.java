public class ContadorChar {
    private int contador = 0;
    private final Object lock = new Object();

    public void incrementar(){
        synchronized (lock) {
            this.contador += 1;
        }
    }

    public int getContador(){
        return this.contador;
    }
}
