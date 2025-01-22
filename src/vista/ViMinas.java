package vista;

/*
 * @author Carlos Robles Cuevas
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import modelo.MoMinas;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViMinas extends JFrame{

	private ArrayList<JPanel> paneles;
	private ArrayList<JButton> botones;
	private ArrayList<JLabel> etiquetas;
	private MoMinas modelo;
	
	
	public ViMinas(MoMinas modelo) {
		this.modelo = modelo;
		
		paneles = new ArrayList<>();
		botones = new ArrayList<>();
		etiquetas = new ArrayList<>();
		setTitle("Busca Minas Inverso - Carlos Robles ");
		propiedadesVentana();
		propiedadesPaneles();
	}
	
	public void propiedadesPaneles() {
		//Panel de arriba (aquí estan las etiquetas)
		JPanel panelArriba = new JPanel(new GridLayout(1, 1));
		paneles.add(panelArriba);
		//Panel de abajo (aquí estan los botones)
		JPanel panelAbajo = new JPanel(new GridLayout(0, 4, modelo.getMargenBotones(), modelo.getMargenBotones()));
		paneles.add(panelAbajo);
		//Ordenamos hacia donde queremos que vaya cada panel
		add(panelArriba, BorderLayout.NORTH);   
	    add(panelAbajo, BorderLayout.SOUTH); 
	}
	
	public void crearBotones(String mina) {
		//Creamos los botones y los añadimos a la lista de botones
		JButton boton = new JButton(mina);
		boton.setPreferredSize(new Dimension(50, 50));
		botones.add(boton);
		paneles.get(1).add(botones.get(botones.size()-1));
	}
	
	public void crearEtiquetas(String datos) {
		//Creamos las etiquetas y las añadimos a la lista de etiquetas
		JLabel etiqueta = new JLabel(datos);
		etiqueta.setPreferredSize(new Dimension (130, 30));
		etiquetas.add(etiqueta);
		paneles.get(0).add(etiquetas.get(etiquetas.size()-1));
	}
	
    private void propiedadesVentana() {
    	this.setLayout(new BorderLayout());
    	//Este layout sirve para colocar los elementos en el Norte, Sur...
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Finalizar al cerrar
    	this.setLocationRelativeTo(null); //Situar la ventana en el centro
    }
    
    public void hacerVisible(boolean b) {
    	this.setVisible(b);
    	this.pack(); 
    	/*
    	 * Ponemos el pack aquí ya que si lo ponemos dentro de los metodos de crearBotones o 
    	 * crearEtiquetas no va a hacer bien su función ya que no se han añadido todos los componentes
    	 * a la ventana
    	 */
    }
    
    public void actualizarDatos() {
        // Actualizar las etiquetas con los nuevos valores de fallos y aciertos
        etiquetas.get(0).setText("Fallos: " + modelo.getFallos());
        etiquetas.get(1).setText("Aciertos: " + modelo.getAciertos());
        
        // Asegúrate de llamar a revalidate() y repaint() para actualizar la interfaz gráfica
        this.revalidate();
/*
 * Este método se utiliza para recalcular la disposición
 *  (layout) de los componentes dentro de un contenedor.
 */
        this.repaint();
/*
 * Este método se utiliza para redibujar la interfaz gráfica. 
 * Es decir, solicita al sistema que vuelva a renderizar la 
 * pantalla, actualizando la visualización.
 */
    }


	public ArrayList<JPanel> getPaneles() {
		return paneles;
	}

	public void setPaneles(ArrayList<JPanel> paneles) {
		this.paneles = paneles;
	}

	public ArrayList<JButton> getBotones() {
		return botones;
	}

	public void setBotones(ArrayList<JButton> botones) {
		this.botones = botones;
	}

	public ArrayList<JLabel> getEtiquetas() {
		return etiquetas;
	}

	public void setEtiquetas(ArrayList<JLabel> etiquetas) {
		this.etiquetas = etiquetas;
	}

	public MoMinas getModelo() {
		return modelo;
	}

	public void setModelo(MoMinas modelo) {
		this.modelo = modelo;
	}
    
    
}
