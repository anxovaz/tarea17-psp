public class RecorrerTexto {
    public String texto;
    public char caracter;
    public RecorrerTexto(char c, String texto){
        this.texto = texto;
        this.caracter = c;
    }
    public void contarCaracter(ContadorChar c){
        for(int i = 0; i<this.texto.length();i++){
           if(this.texto.charAt(i) == this.caracter){
               c.incrementar();
           }
        }
    }

}
