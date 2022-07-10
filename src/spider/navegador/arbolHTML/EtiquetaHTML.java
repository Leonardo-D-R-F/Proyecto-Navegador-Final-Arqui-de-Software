package spider.navegador.arbolHTML;

import javax.swing.*;

public interface EtiquetaHTML {
    //public EtiquetaEnum getTipoEtiquetaHTML();
    //devuelve el tipo de la etiqueta
    public String toString(); // Para mostrar el contenido del componenete la etiqueta original
    public JComponent graficar();
    public String desplegar();
}
