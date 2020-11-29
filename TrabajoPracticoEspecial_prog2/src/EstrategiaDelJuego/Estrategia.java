package EstrategiaDelJuego;

import Juego.Atributo;
import Juego.Carta;

public abstract class Estrategia {
	private String nombre;
	
	public Estrategia(String nombre) {
		this.nombre=nombre;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public abstract String ElegirAtributo(Carta c);
	
	
}
