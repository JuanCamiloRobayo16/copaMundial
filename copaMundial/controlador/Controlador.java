package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import vista.VentanaPrincipal;
import modelo.Equipo;
import modelo.Jugador;


public class Controlador implements ActionListener
{
    //------------
    // Atributos
    //------------
    
        private VentanaPrincipal vista;
        private Equipo modelo;
        private Jugador modelo2;

    
        //------------
        // Metodos
        //------------
    
        //metodo constructor
        public Controlador(VentanaPrincipal pVista, Equipo pModelo, Jugador pModelo2)
        {
            this.vista = pVista;
            this.modelo = pModelo;
            this.modelo2 = pModelo2;
            this.vista.miPanelOperaciones.btDirector.addActionListener(this);
            this.vista.miPanelOperaciones.btJugador.addActionListener(this);
            this.vista.miPanelOperaciones.btInformacion.addActionListener(this);
            this.vista.miPanelOperaciones.btSalir.addActionListener(this);      
        }
        @Override
        public void actionPerformed(ActionEvent ae) 
        {
            // Identificar el comando generado [hallar,borrar, salir]
            String comando = ae.getActionCommand();
           
            if(comando.equals("jugador"))
            {   
                 vista.crearDialogoJugador();
                 this.vista.miDialogoJugador.agregarOyentesBotones2(this);
            }
            if(comando.equals("informacion"))
            {
                try 
                {
                    String pais = vista.miPanelEntradaDatos.getEquipo();
                    String continente = vista.miPanelEntradaDatos.getContinente();
                    int participaciones = Integer.parseInt(vista.miPanelEntradaDatos.getParticipaciones());
                    int copas = Integer.parseInt(vista.miPanelEntradaDatos.getCopas());
                    modelo = new Equipo(pais, continente, participaciones, copas);
                    vista.miPanelResultados.mostrarResultado("Los datos del equipo son los siguientes: \nPais = " + modelo.getPais() + "\nContinente = " + modelo.getContinente() + "\nParticipaciones = " + modelo.getParticipaciones() + "\nCopas = " + modelo.getCopas());
                    vista.miPanelOperaciones.activarBotones();
                
                } catch (Exception e) 
                {
                    JOptionPane.showMessageDialog(null, "Error en datos de entrada", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            if(comando.equals("aceptar"))
            {
                String nombre = vista.miDialogoDirector.getNombre();
                int experiencia = Integer.parseInt(vista.miDialogoDirector.getExperiencia());
                int dia = Integer.parseInt(vista.miDialogoDirector.getDia());
                int mes = Integer.parseInt(vista.miDialogoDirector.getMes());
                int año = Integer.parseInt(vista.miDialogoDirector.getAño());
                modelo.director(nombre, experiencia, dia, mes, año);
                vista.miPanelResultados.mostrarResultado("Datos del director: \nNombre = " + modelo.getNombre() + "\nExperiencia = " + modelo.getExperiencia() + "\nFecha de nacimiento = " + modelo.getDia() + "/" + modelo.getMes() + "/" + modelo.getAño());
                vista.miDialogoDirector.cerrarDialogo();
            }
            if(comando.equals("aceptar2"))
            {
                String nombre = vista.miDialogoJugador.getNombre();
                String apellidos = vista.miDialogoJugador.getApellidos();
                int edad = Integer.parseInt(vista.miDialogoJugador.getEdad());
                String posicion = vista.miDialogoJugador.getPosicion();
                int goles = Integer.parseInt(vista.miDialogoJugador.getGoles());
                String seleccionar = vista.miDialogoJugador.getSeleccionar();

                modelo2 = new Jugador(nombre, apellidos, edad, posicion, goles, seleccionar);
                vista.miPanelResultados.mostrarResultado("Datos del Jugador: \nNombre = " + modelo2.getNombre() + "\nApellidos = " + modelo2.getApellidos() + "\nEdad = " + modelo2.getEdad() + "\nPosicion = " + modelo2.getPosicion() + "\nGoles = " + modelo2.getGoles() + "\nJuega de " + modelo2.getSeleccionar());
                vista.miDialogoJugador.cerrarDialogo();          
            }

            if(comando.equals("director"))
            {   
                 vista.crearDialogoDirector();
                 this.vista.miDialogoDirector.agregarOyentesBotones(this);
            }

            if(comando.equals("Salir"))
            {
                System.exit(0);
            }
        }
}
