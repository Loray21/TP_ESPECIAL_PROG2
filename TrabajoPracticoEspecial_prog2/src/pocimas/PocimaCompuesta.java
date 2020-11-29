package pocimas;

import java.util.ArrayList;

import Juego.Atributo;

public class PocimaCompuesta extends ElementoAbstracto {
	
	ArrayList<ElementoAbstracto>pocimas; 

	public PocimaCompuesta(String nombre) {
		super(nombre);
		pocimas= new ArrayList<>();
	}
	
	public void addPocima(ElementoAbstracto p) {
		pocimas.add(p);
	}

	@Override
	public double  calcular(Atributo a) {
		Atributo aux = new Atributo(a.getNombre(), a.getValor());
		int total = 0;
		for(ElementoAbstracto p: pocimas) {
			total+=p.calcular(aux);
			aux.setValor(total);
			total=0;
		}
		return aux.getValor();
	}

	@Override
	public String toString() {
		return super.getNombre();
	}

}
	