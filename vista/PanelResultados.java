package vista;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class PanelResultados extends JPanel
{
        //---------------
    // Atributos
    // --------------
    private JTextArea taResultado;
    private JScrollPane spResultado;
   
    //---------------
    // Metodos
    // --------------

    /*Metodo constructor */
    public PanelResultados()
    {
        // Definicion contenedor del panel
        this.setLayout(null);
        this.setBackground(Color.gray);

        //Crear y agregar area de texto 
        taResultado= new JTextArea();
        spResultado = new JScrollPane(taResultado);
        taResultado.setBackground(Color.GRAY);
        spResultado.setBounds(10,20,640,260);
        this.add(spResultado);

        //Borde y titulo al panel 
        TitledBorder borde = BorderFactory.createTitledBorder("Resultados");
        borde.setTitleColor(Color.RED);
        this.setBorder(borde);

    }
    // metodo de acceso a la informacion
    public void mostrarResultado(String msg)
    {
        taResultado.append(msg + "\n");
    }

    

    // borrar resultados
    public void borrar()
    {
        taResultado.setText("");
    }  
    
}
