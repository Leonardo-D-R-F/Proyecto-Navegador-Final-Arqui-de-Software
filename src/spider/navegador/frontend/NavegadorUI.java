package spider.navegador.frontend;

import javax.swing.*;
import java.awt.*;
public class NavegadorUI implements INavegadorUI {
    private final JFrame vista = new JFrame();
    JPanel despliegueDeInformacion;
    JTextField cuadroDeBusqueda;

    public NavegadorWeb navegadorWeb;

    public NavegadorUI(NavegadorWeb navegadorWeb){
        this.navegadorWeb = navegadorWeb;
        this.vista.setBounds(0, 0, 900, 650);
        this.vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.vista.setResizable(false);
        this.vista.setLocationRelativeTo(null);
        this.vista.setLayout(null);

        JPanel barraDeBusqueda = new JPanel();
        barraDeBusqueda.setLayout(null);
        this.cuadroDeBusqueda = new JTextField();
        this.cuadroDeBusqueda.setBounds(150, 8, 450, 30);
        barraDeBusqueda.add(cuadroDeBusqueda);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(608,8,80,30);
        ActionsBotonesNavegadorGUI mb = new ActionsBotonesNavegadorGUI(this);
        btnBuscar.addActionListener(mb);
        barraDeBusqueda.add(btnBuscar);

        barraDeBusqueda.setBounds(0,0,900 ,46);
        barraDeBusqueda.setBackground(Color.DARK_GRAY);
        this.vista.add(barraDeBusqueda);

        this.despliegueDeInformacion = new JPanel();
        this.despliegueDeInformacion.setLayout(null);
        this.despliegueDeInformacion.setBounds(0,46,900 ,620);
        this.despliegueDeInformacion.setBackground(Color.white);
        this.vista.add(despliegueDeInformacion);


    }
    public void run() {
        this.vista.setVisible(true);
    }
}
