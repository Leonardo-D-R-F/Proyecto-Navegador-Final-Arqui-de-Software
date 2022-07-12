package spider.navegador;

import spider.navegador.frontend.NavegadorWeb;
import spider.navegador.frontend.NavegadorWebVivi;

public class MainVivi {
    public static void main(String[] args) {
        Internet internet = new Internet();
        NavegadorWebVivi navegador = new NavegadorWebVivi(internet);
        navegador.run();
    }
}
