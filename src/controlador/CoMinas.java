package controlador;

/*
 * @author Carlos Robles Cuevas
 */

import javax.swing.JOptionPane;
import modelo.MoMinas;
import vista.ViMinas;

public class CoMinas {

	private MoMinas modelo;
	private ViMinas vista;
	
	public CoMinas() {
		this.modelo = new MoMinas();
		this.modelo.llenarDatos();
		this.vista = new ViMinas(modelo);
		
		crearEtiquetas();
		crearBotones();
		activarEventoBoton();
		vista.hacerVisible(true);
	}
	
	
    private void crearBotones() {
        String minasTotales = JOptionPane.showInputDialog("Introduce numero de Minas");
        // Lo paso a int porque el JOptionPane me pide un String
        modelo.setNuMinas(Integer.parseInt(minasTotales));

        modelo.minasRandom();
        
        for(int i = 0;i<modelo.getNuMinas();i++) {
            vista.crearBotones(modelo.getMinas().get(i));
        }
}
    
    private void crearEtiquetas() {
    	for(int i=0; i<modelo.getDatos().size();i++) {
    		vista.crearEtiquetas(modelo.getDatos().get(i));
    	}
    }
    
    private void activarEventoBoton() {
        for (int i = 0; i < vista.getBotones().size(); i++)
        {
            this.vista.getBotones().get(i).addActionListener(new Oyente(modelo,vista));
        }
    }
}
