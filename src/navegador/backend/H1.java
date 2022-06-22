package navegador.backend;

public class H1 extends Componente{
    int size;
    public H1(String Informacion){
        super("H1",Informacion);
        this.size=30;
    }

    @Override
    public Componente getInformationComponent() {
        Componente componente = new Componente(this.Etiqueta, this.Information + "," + this.size) {
            @Override
            public Componente getInformationComponent() {
                return null;
            }
        };
        return null;
    }
}
