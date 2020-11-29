package pocimas;

import Juego.Atributo;

public class PocimaMagica extends ElementoAbstracto{
	
	private int valor=0;
	
	public PocimaMagica(String nombre,int valor) {
		super(nombre);
		this.valor=valor;
	}

	@Override
	public double calcular(Atributo a) {
		return this.valor;
	}

}
