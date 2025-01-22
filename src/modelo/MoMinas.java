package modelo;

/*
 * @author Carlos Robles Cuevas
 */

import java.util.ArrayList;
import java.util.Random;

public class MoMinas {
	Random random = new Random();
	
	private int margenVentana;
	private int margenBotones;
	private int nuMinas;
	private int bomba;
	private int aciertos;
	private int fallos;
	private ArrayList<String> minas;
	private ArrayList<Integer> bombas;
	private ArrayList<String> datos;
	private int botonActual;
	
	public MoMinas() {
		margenVentana = 25;
		margenBotones = 5;
		bombas = new ArrayList<>();
		minas = new ArrayList<>();
		datos = new ArrayList<>();
		
		//llenarDatos();
	}
	
	public void llenarDatos() {
		datos.add("Fallos :"+ fallos);
		datos.add("Aciertos :"+ aciertos);
	}
	
	public void minasRandom() { //FALTA COMPROBAR SI YA EXISTE
		for(int i=0; i<minas.size()/2;i++) {
			bomba=random.nextInt(minas.size());
			bombas.add(bomba);
		}
	}
	
	public void setNuMinas(int nMinas) {
        this.nuMinas = nMinas;
        for (int i = 0; i < nMinas; i++) {
            minas.add(""+i);
        }
}
	public int getNuMinas() {
		return nuMinas;
	}
	public ArrayList<String> getMinas() {
		return minas;
	}
	public void setMinas(ArrayList<String> minas) {
		this.minas = minas;
	}
	public int getMargenVentana() {
		return margenVentana;
	}
	public void setMargenVentana(int margenVentana) {
		this.margenVentana = margenVentana;
	}

	public int getMargenBotones() {
		return margenBotones;
	}

	public void setMargenBotones(int margenBotones) {
		this.margenBotones = margenBotones;
	}

	public ArrayList<String> getDatos() {
		return datos;
	}

	public void setDatos(ArrayList<String> datos) {
		this.datos = datos;
	}

	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}

	public int getBomba() {
		return bomba;
	}

	public void setBomba(int bomba) {
		this.bomba = bomba;
	}

	public ArrayList<Integer> getBombas() {
		return bombas;
	}

	public void setBombas(ArrayList<Integer> bombas) {
		this.bombas = bombas;
	}

	public int getBotonActual() {
		return botonActual;
	}

	public void setBotonActual(int botonActual) {
		this.botonActual = botonActual;
	}

	public int getAciertos() {
		return aciertos;
	}

	public void incrementarAciertos() {
		aciertos++;
	}

	public int getFallos() {
		return fallos;
	}

	public void incrementarFallos() {
		fallos++;
	}
}
	
