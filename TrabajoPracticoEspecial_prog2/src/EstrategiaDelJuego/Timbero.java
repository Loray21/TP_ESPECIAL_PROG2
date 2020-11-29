package EstrategiaDelJuego;

import Juego.Atributo;
import Juego.Carta;

public class Timbero extends Estrategia {
	
	public Timbero(String nombre) {
		super(nombre);
	}

	public Atributo aleatorio(Carta c) {
		int randomIndex = (int) (Math.random() * c.GetAtributos().size());
		return c.GetAtributos().get(randomIndex);
	}

	@Override
	public String ElegirAtributo(Carta c) {
		return this.aleatorio(c).getNombre();
	}

}
