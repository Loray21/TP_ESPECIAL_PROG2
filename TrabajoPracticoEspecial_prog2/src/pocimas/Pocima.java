package pocimas;

import java.util.ArrayList;

import Juego.Atributo;

public abstract class Pocima extends ElementoAbstracto {
 
	private double porcentaje;
	public Pocima(String nombre,double porcentaje) {
		super(nombre);
		this.porcentaje=porcentaje;
	}
	@Override
	public abstract double calcular(Atributo a);
	
	
	
	public double getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}
	@Override
	public String toString() {
		return super.getNombre();
	}
	
	
}
