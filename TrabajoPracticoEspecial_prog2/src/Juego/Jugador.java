package Juego;

import java.util.ArrayList;

import EstrategiaDelJuego.Estrategia;

public class Jugador {
	Mazo m1;
	private String nombre;	
	private Estrategia e1;
	
	public Jugador(String nombre,Estrategia estrategia){
		m1=new Mazo();
		this.nombre=nombre;
		this.e1=estrategia;
	}
	
	public Estrategia getE1() {
		return e1;
	}
	public void setE1(Estrategia e1) {
		this.e1 = e1;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	
	public void add(Carta c) {
		m1.addCarta(c);
	}
	
	public Carta removeAdd() {
		return m1.remove(this.m1.getPos());
	}
	
	public boolean tieneCartas() {
		return m1.tieneCartas();
	}
	
	public int cantidadDeCartas() {
		return this.m1.cantidadDeCartas();
	}
	
	public Carta getPosicion() {
		return m1.GetPosicion();
	}
	
	public String atributoJugador(Carta c) {
		return this.getE1().ElegirAtributo(c);
	}
	
	public String toString(String nombreAtributo, Jugador j) {
		String resultado;
		return resultado = "El jugador " + this.getNombre()+ " selecciona competir por el atributo "+nombreAtributo+ "\n"
				+ "La carta de " + this.getNombre() + " es "+ this.getPosicion().getNombreDePersonaje() + " "+ nombreAtributo +" "+ this.getPosicion().getValor(nombreAtributo)+","+ " se aplico pocima "+ this.getPosicion().getP1() +" valor resultante " + this.getPosicion().getValorCPocima(nombreAtributo)+ "\n"
				+ "La carta de " + j.getNombre()+ " es " + j.getPosicion().getNombreDePersonaje() + " "+ nombreAtributo + " " +j.getPosicion().getValorCPocima(nombreAtributo)+ "\n"
				+ "Gana la ronda " + this.getNombre()	+" y queda con "+ this.cantidadDeCartas() + " cartas " + "("+ j.getNombre() +" posee ahora "+ j.cantidadDeCartas()+" cartas" + ")"+"\n";
	}
	
	
}