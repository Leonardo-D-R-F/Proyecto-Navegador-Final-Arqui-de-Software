package spider.navegador.backend;

import spider.navegador.arbolHTML.EtiquetaEnum;
public class TagHTML {
    private EtiquetaEnum etiqueta;
    private boolean esApertura;

    public TagHTML(EtiquetaEnum etiqueta, boolean esApertura) {
        this.etiqueta = etiqueta;
        this.esApertura = esApertura;
    }

    public EtiquetaEnum getEtiqueta() {
        return etiqueta;
    }

    public boolean isEsApertura() {
        return esApertura;
    }
}
