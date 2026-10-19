/**
 * Clase recorrerTexto que recorre un texto y aumenta los contadores
 * @author anxo
 */
public class RecorrerTexto {
    public String texto;
    public char caracter;
    public ContadorChar contadorLocal = new ContadorChar();

    /**
     * Constructor
     * @param c
     * @param texto
     */
    public RecorrerTexto(char c, String texto){
        this.texto = texto;
        this.caracter = c;
    }

    /**
     * Método que recibe un contador global y recorre el texto aumentando tanto contador local como global
     * @param cGlobal
     */
    public void contarCaracter(ContadorChar cGlobal){
        for(int i = 0; i<this.texto.length();i++){
           if(this.texto.charAt(i) == this.caracter){
               cGlobal.incrementar();
               this.contadorLocal.incrementar();
           }
        }
    }


}
