package spider.navegador.backend.etiquetas;

import spider.navegador.backend.NoCompuesto;

import java.util.ArrayList;
import java.util.List;

public class Html extends NoCompuesto {
        Title title;
        Body body;
        public Html(){
            super("html","");
            this.title = new Title("Documento");
            this.body = new Body();
        }
        public void updateTitle(String titulo){
            this.title = new Title(titulo);
        }
        public void addBody(Body body){
            this.body = body;
        }
        @Override
        public List<NoCompuesto> getInformationComponent() {
            NoCompuesto componente = new NoCompuesto(this.Etiqueta,this.Information) {
                @Override
                public List<NoCompuesto> getInformationComponent() {
                    List<NoCompuesto> lista = new ArrayList<>();
                    return null;
                }
            };
            return null;
        }
}
