package EstrategiaDelJuego;

import Juego.Atributo;
import Juego.Carta;

public class Obstinado extends Estrategia {
	private String nombreAtributo;
	
public Obstinado(String nombre,String nombreAtributo) {
		super(nombre);
		this.nombreAtributo = nombreAtributo;
	}

	@Override
	public String ElegirAtributo(Carta c) {
		return c.BuscarAtributo(this.nombreAtributo).getNombre();	
	}

}
