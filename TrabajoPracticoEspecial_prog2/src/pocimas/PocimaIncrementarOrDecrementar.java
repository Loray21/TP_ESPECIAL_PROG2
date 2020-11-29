package pocimas;

import java.util.ArrayList;

import Juego.Atributo;

public class PocimaIncrementarOrDecrementar extends Pocima {

	public PocimaIncrementarOrDecrementar(String nombre, double porcentaje) {
		super(nombre, porcentaje);
	}
	
//para decrementar el valor suposimos que el porcentaje puede ser negativo
	@Override
	public double calcular(Atributo a) {
		double valor=0;
		double total=0;
		valor=(a.getValor()*this.getPorcentaje())/100;
		total=a.getValor()+valor;
		return total;
	}
	
}

