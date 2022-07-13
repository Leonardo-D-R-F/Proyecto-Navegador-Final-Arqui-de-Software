package spider.navegador;

import spider.navegador.frontend.NavegadorWeb;

import java.io.IOException;

public class Main {
    public static void main(String[] args){
        Internet internet = new Internet();
        NavegadorWeb navegador = new NavegadorWeb(internet);
        navegador.run();
    }
}
