package pocimas;

import java.util.ArrayList;

import Juego.Atributo;

public abstract class ElementoAbstracto {
	
	
	private String nombre;
	public ElementoAbstracto(String nombre) {
		this.nombre=nombre;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public abstract double calcular(Atributo a);
	
}

