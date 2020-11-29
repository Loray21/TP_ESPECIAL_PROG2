package Juego;

import java.util.ArrayList;
import java.util.Collections;
import pocimas.ElementoAbstracto;
import pocimas.Pocima;

public class Juego {

	private int cantidadRondas;
	protected Mazo mazo;
	protected ArrayList<String> resultados;
	protected ArrayList<ElementoAbstracto>pocimas;

	Jugador j1;
	Jugador j2;

	public Juego(Mazo mazo, int cantidadRondas, Jugador j1, Jugador j2) {
		this.mazo = mazo;
		this.cantidadRondas = cantidadRondas;
		this.resultados = new ArrayList<String>();
		pocimas= new ArrayList<>();
		this.j1 = j1;
		this.j2 = j2;
	}

	public void AddPocima(ElementoAbstracto pocima) {
		pocimas.add(pocima);
	}	

	public void repartir() {
		mazo.Mezclar();
		Collections.shuffle(pocimas);
		while(!mazo.tieneCartas()) {
			Collections.shuffle(pocimas);
			Carta c1= mazo.RepartirCartas();
			j1.add(c1);
			if(!pocimas.isEmpty()) {
				c1.setP1(pocimas.remove(0));
			}
			if(!mazo.tieneCartas()) {
				Carta c2 = mazo.RepartirCartas();
				j2.add(c2);
				if(!pocimas.isEmpty()) {
					c2.setP1(pocimas.remove(0));
				}
			}
		}
	}

	public void jugar() {
		int ronda = 0;
		int resultado = 1;
		Carta primeraCarta = null;
		Carta j2_Carta = null;
		String a1 = "";
		String ganador = "";
		
		repartir();
     while((!j1.tieneCartas())&&(!j2.tieneCartas()) && ronda<cantidadRondas) {
         primeraCarta=j1.getPosicion();
		   j2_Carta=j2.getPosicion();
    	 ronda++;
		 ganador = "------- Ronda "+ ronda + " ------- \n";
    	 if(resultado == 1) {
	           a1=j1.atributoJugador(primeraCarta);
    	 } else if (resultado == -1) {
			   a1=j2.atributoJugador(j2_Carta);
			}
		    	 if(primeraCarta.cartaGanadora(j2_Carta,a1) == 1) {
		    		  resultado = 1;
		    		  ganador = ganador + j1.toString(a1, j2);
		    		  j1.add(j1.removeAdd());
		    		  j1.add(j2_Carta);
		    		  j2.removeAdd();
		    		  primeraCarta.removePocima();
		    		  j2_Carta.removePocima();
		    	 }else if(primeraCarta.cartaGanadora(j2_Carta,a1) == -1) {
		    		 resultado = -1;
		    		 ganador = ganador + j2.toString(a1, j1);
		    		 j2.add(j2.removeAdd());
		    		 j2.add(primeraCarta);
		    		 j1.removeAdd();
		    		 primeraCarta.removePocima();
		    		 j2_Carta.removePocima();
		    	 }else{
		    		 j1.add(j1.removeAdd());
		    		 j2.add(j2.removeAdd());
		    		 ganador =ganador + " empate: " + j1.getNombre() + " " +  primeraCarta.getValor(a1) + " vs " + j2.getNombre()+ " " + j2_Carta.getValor(a1);
		    		 primeraCarta.removePocima();
		    		 j2_Carta.removePocima();
		    	 }
		    	 resultados.add(ganador);
     }
     imprimirResultados();
     getGanador(j1,j2,ronda);
	}

	public void getGanador(Jugador j1, Jugador j2, int ronda) {
		if(j1.m1.cantidadDeCartas() > j2.m1.cantidadDeCartas()){
			System.out.println("El ganador es j1 "  + j1.getNombre()+ " en " + ronda + " rondas");
		} else if (j1.m1.cantidadDeCartas() < j2.m1.cantidadDeCartas()) {
			System.out.println("El ganador es j2 " +j2.getNombre() + " en " + ronda + " rondas");
		} else {
			System.out.println("Empate"+ " en " + ronda + " rondas");
		}
	}
	
	public void imprimirResultados() {
		for(int i = 0; i<resultados.size(); i++) {
			System.out.println(resultados.get(i));
		}
	}
	
}
