package EstrategiaDelJuego;

import Juego.Atributo;
import Juego.Carta;

public class Ambicioso extends Estrategia {

	public Ambicioso(String nombre) {
		super(nombre);
	}

	@Override
	public String ElegirAtributo(Carta c) {
		Atributo aux=c.GetAtributos().get(0);
		for(Atributo a:c.GetAtributos()) {
			if(aux.getValor()<a.getValor()) {
				aux=a;
			}
		}
		return aux.getNombre();
	}

}
