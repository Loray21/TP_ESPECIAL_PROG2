package Juego;

import java.util.ArrayList;

import pocimas.ElementoAbstracto;

public class Carta {
	
	private String NombreDePersonaje;
	protected ArrayList<Atributo>atributos;
	protected ElementoAbstracto p1;
	
	public Carta(String NombreDePersonaje){
			this.NombreDePersonaje=NombreDePersonaje;
			atributos= new ArrayList<>();
		}

	
	public ElementoAbstracto getP1() {
		return this.p1; 
	}
	
   public void setP1(ElementoAbstracto p1) {
		this.p1=p1;
	}
   
   public void removePocima() {
	   this.p1=null;
   }
   
   public double ModificarAtributo(Atributo a) {
	   double valor=0;
	   if(this.getP1()!=null) {
		   valor=p1.calcular(a);
		   return valor;
	   }else {
		   return a.getValor();
	   }
	   		
   }
   
   public double getValor(String nombre) {
	   return this.BuscarAtributo(nombre).getValor();
   }
   
   public double getValorCPocima(String nombre) {
	   return this.ModificarAtributo(this.BuscarAtributo(nombre));   
   }

	public String getNombreDePersonaje() {
		return NombreDePersonaje;
	}

	public void setNombreDePersonaje(String nombreDePersonaje) {
		this.NombreDePersonaje = nombreDePersonaje;
	}

	public int CantAtributos() {
		return atributos.size();
	}
	
	public void add(Atributo a) {
		atributos.add(a);
	}
	
	public int cartaGanadora(Carta c, String nombreAtributo) {
		double valorCpocima1 = this.ModificarAtributo(this.BuscarAtributo(nombreAtributo));
		double valorCpocima2 = c.ModificarAtributo(c.BuscarAtributo(nombreAtributo));
		if(valorCpocima1 > valorCpocima2) {
			return 1;
		} else if(valorCpocima1 < valorCpocima2) {
			return -1;
		} else {
			return 0;
		}
	}
	
	
	public boolean tieneAtributos(Atributo a) {
	return atributos.contains(a);
	}	

	@Override
	public boolean equals(Object obj) {
		try {
			boolean retorno= false;
           	Carta c = (Carta)obj;
           	for(int i=0; i<atributos.size(); i++) {
           	     if(this.tieneAtributos(c.atributos.get(i))){
           	    	 retorno=true;
           	     	}else {
           	    	 retorno=false;
           	     }
           	}
        if((this.CantAtributos()==c.CantAtributos())&&(retorno==true)){	
        	retorno=true;
        }
			return retorno;
		}catch(Exception e) {
			return false;
		}
	}

	public Atributo BuscarAtributo(String nombreAtributo) {
		Atributo A=null;
		for(int i=0; i<atributos.size();i++) {
			if(atributos.get(i).getNombre().equals(nombreAtributo)) {
				A = atributos.get(i);	
			}
		}
		return A;
	}
	
	public boolean CartaMayor(Atributo a1,Atributo a2) {
			return a1.getValor()>a2.getValor();
	}
	
	public ArrayList<Atributo>GetAtributos(){
		return new ArrayList<>(this.atributos);
	}
	
	public String toString() {
		return this.NombreDePersonaje+ this.p1;
	}
		
}
