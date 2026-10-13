public class ContadorChar {
    private int contador = 0;

    synchronized void incrementar(){
        this.contador += 1;
    }

    public int getContador(){
        return this.contador;
    }
}
