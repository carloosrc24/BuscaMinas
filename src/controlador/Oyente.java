package controlador;

/*
 * @ahuthor Carlos Robles Cuevas
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import modelo.MoMinas;
import vista.ViMinas;

public class Oyente implements ActionListener{
	
	private MoMinas modelo;
    private ViMinas vista;

    public Oyente(MoMinas modelo, ViMinas vista) {
    	this.modelo=modelo;
    	this.vista=vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Botón que se hace click
        JButton boton = (JButton) e.getSource();
        
        // Establece el número de la mina según el texto del botón 
        int mina = Integer.parseInt(boton.getText());
        
     // Si está en las bombas, significa que el usuario ha pisado una mina
        if (modelo.getBombas().contains(mina)) {
            
            // Incrementar los aciertos
            modelo.incrementarAciertos();
            
            // Deshabilitar el botón para que no se pueda pulsar otra vez
            boton.setEnabled(false);
            
            
            JOptionPane.showMessageDialog(vista, "¡Acierto! Has pisado una mina.");
         // Si no está en las bombas, indica que no es una mina
        } else {
            
            // Incrementar los fallos
            modelo.incrementarFallos();
            
            // Deshabilitar el botón para que no se pueda pulsar otra vez
            boton.setEnabled(false);
            
           
            JOptionPane.showMessageDialog(vista, "¡Fallo! No es una mina.");
        }
        
        // Actualizar los datos de fallos y aciertos en la vista
        vista.actualizarDatos();
    }
}
