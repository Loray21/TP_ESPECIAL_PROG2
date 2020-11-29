package Juego;

import EstrategiaDelJuego.Ambicioso;
import EstrategiaDelJuego.Obstinado;
import EstrategiaDelJuego.Timbero;
import pocimas.PocimaCompuesta;
import pocimas.PocimaIncrementarOrDecrementar;
import pocimas.PocimaMagica;
import pocimas.PocimaSelectiva;

public class Simulador {

	public static void main(String[] args) {
		/*
		
		Atributo a1= new Atributo("fuerza",80);
		Atributo a2= new Atributo("fuerza",3);

		Carta c1= new Carta("superman");
		c1.add(a1);
		
		
		Carta c2= new Carta("batman");
		c2.add(a2);
		
*/
	
		Mazo m1= new Mazo();
		//String mazoPath = "./src/VisorMazo/superheroes.json";
		String mazoPath = "./src/VisorMazo/autos.json";
		m1.CargarMazo(mazoPath);
		
		Atributo a = new Atributo("fuerza", 50);
		
		Ambicioso ambi1= new Ambicioso("ambicioso");
		Ambicioso ambi2= new Ambicioso("ambicioso");
		Timbero tim = new Timbero("timba");
		
		Jugador j1 = new Jugador("tomi", ambi1);
		Jugador j2= new Jugador("laucha", tim);
		
		PocimaIncrementarOrDecrementar p1 = new PocimaIncrementarOrDecrementar("sol", 100);
		PocimaSelectiva p2 = new PocimaSelectiva("selectiva", 50, "fuerza");
        PocimaCompuesta p3= new PocimaCompuesta("compuesta");
         
         p3.addPocima(p1);
         p3.addPocima(p2);
         
		Juego juego= new Juego(m1,50,j1,j2);
	   //juego.AddPocima(p1);
	   //juego.AddPocima(p2);
	   //juego.AddPocima(p3);
	   //juego.AddPocima(p4);
		juego.AddPocima(p3);
		juego.jugar();
	}

}
