package spider.navegador.frontend;

import javax.swing.*;
import java.awt.*;

public class NavegadorUI {
    JFrame vista = new JFrame();
    JPanel barraDeBusqueda;
    JPanel despliegueDeInfomracion;
    JButton btnBuscar;
    JTextField cuadroDeBusqueda;
    JTextArea contenido;
    ActionsBotonesNavegadorGUI mb = new ActionsBotonesNavegadorGUI(this);

    public NavegadorWeb navegadorWeb;

    public NavegadorUI(NavegadorWeb navegadorWeb){
        this.navegadorWeb = navegadorWeb;
        this.vista.setBounds(0, 0, 900, 650);
        this.vista.setResizable(false);
        this.vista.setLocationRelativeTo(null);
        this.vista.setLayout(null);

        this.barraDeBusqueda = new JPanel();
        this.barraDeBusqueda.setLayout(null);
        this.cuadroDeBusqueda = new JTextField();
        this.cuadroDeBusqueda.setBounds(150, 8, 450, 30);
        this.barraDeBusqueda.add(cuadroDeBusqueda);

        this.btnBuscar = new JButton("Buscar");
        this.btnBuscar.setBounds(608,8,80,30);
        this.btnBuscar.addActionListener(mb);
        this.barraDeBusqueda.add(btnBuscar);

        this.barraDeBusqueda.setBounds(0,0,900 ,46);
        this.barraDeBusqueda.setBackground(Color.DARK_GRAY);
        this.vista.add(barraDeBusqueda);

        this.despliegueDeInfomracion = new JPanel();
        this.despliegueDeInfomracion.setLayout(null);
        this.despliegueDeInfomracion.setBounds(0,46,900 ,620);
        this.despliegueDeInfomracion.setBackground(Color.white);

       // actualizarPagina();
//        this.contenido = new JTextArea();
//        this.contenido.setLayout(null);
//        this.contenido.setBounds(10,10,900 ,620);
//        this.despliegueDeInfomracion.add(contenido);
//
        this.vista.add(despliegueDeInfomracion);

        //
        run();

    }
    private void actualizarPagina(){
        JButton button = new JButton("Hola");
        button.setBounds(50,50,200,50);
        JButton button2 =  new JButton("Adios");
        button2.setBounds(100,100,200,50);

        button2.setBounds(100,100,200,50);
        JLabel label=  new JLabel("Adios");
        this.despliegueDeInfomracion.add(button);
        this.despliegueDeInfomracion.add(button2);
        this.despliegueDeInfomracion.add(label);
    }
    public void run() {
        this.vista.setVisible(true);
        //
    }

}
