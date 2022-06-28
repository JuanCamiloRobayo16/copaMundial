package vista;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelOperaciones extends JPanel
{
    //---------------
    // Atributos
    // --------------
    public JButton btDirector;
    public JButton btJugador;
    public JButton btInformacion;
    public JButton btSalir;

    //---------------
    // Metodos
    // --------------

    /*Metodo constructor */
    public PanelOperaciones()
    {
        // Definicion contenedor del panel
        this.setLayout(null);
        this.setBackground(Color.GRAY);

        //crear y agregar boton hallar
        btDirector = new JButton("Director Tecnico");
        btDirector.setBounds(30,40,140,30);
        this.add(btDirector);
        btDirector.setActionCommand("director");
        btDirector.setEnabled(false);

        // crear y agregar boton borrar
        btJugador = new JButton("Jugador");
        btJugador.setBounds(180,40,140,30);
        this.add(btJugador);
        btJugador.setActionCommand("jugador");
        btJugador.setEnabled(false);

        btInformacion = new JButton("Informacion");
        btInformacion.setBounds(330,40,140,30);
        this.add(btInformacion);
        btInformacion.setActionCommand("informacion");

        // crear y agregar boton salir
        btSalir = new JButton("Salir");
        btSalir.setBounds(480,40,140,30);
        this.add(btSalir);
        btSalir.setActionCommand("Salir");

        //Borde y titulo al panel 
        TitledBorder borde = BorderFactory.createTitledBorder("Operaciones");
        borde.setTitleColor(Color.RED);
        this.setBorder(borde);
    }

    public void activarBotones()
    {
        btDirector.setEnabled(true);
        btJugador.setEnabled(true);
    }
}