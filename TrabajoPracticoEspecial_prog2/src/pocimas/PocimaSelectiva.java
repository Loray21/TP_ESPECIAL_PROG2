package pocimas;

import java.util.ArrayList;

import Juego.Atributo;

public class PocimaSelectiva extends Pocima {
	private String nombreAtributo;
	
	public PocimaSelectiva(String nombre, double porcentaje,String nombreAtributo) {
	super(nombre, porcentaje);
	this.nombreAtributo = nombreAtributo;
	}

	public String getNombreAtributo() {
		return this.nombreAtributo;
	}
	
	public void setNombreAtributo(String nombreAtributo) {
		this.nombreAtributo = nombreAtributo;
	}
	
	public String getNombre() {
		return nombreAtributo;
	}

	public void setNombre(String nombre) {
		this.nombreAtributo = nombre;
	}

	@Override
	public double  calcular(Atributo a) {
		double valor=0;
		double total=0;
		if(this.getNombreAtributo().equals(a.getNombre())) {
			valor = (a.getValor()*this.getPorcentaje())/100;
			total= a.getValor()+valor;
			return total;
		}
		return total;
	}
	
}
