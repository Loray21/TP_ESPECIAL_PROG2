
package Juego;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class Mazo {
	
	protected ArrayList<Carta>cartas;
	private int tope;
	protected final  int pos=0;
	
	public Mazo(){
		cartas= new ArrayList<>();
		this.tope =50;
	}
		
	public int cantidadDeCartas() {
		return cartas.size();
	}
	public int getPos() {
		return pos;
	}
	
	public int getTope() {
		return tope;
	}

	public void setTope(int tope) {
		this.tope = tope;
	}

	
	public void setCartas(ArrayList<Carta> cartas) {
		this.cartas = cartas;
	}
	
	public boolean tieneCartas() {
		return (cartas.isEmpty());
	}
	
	public Carta RepartirCartas() {
		Carta c1=this.GetPosicion();
		return cartas.remove(pos);
	}
	
	public  void Mezclar() {
		Collections.shuffle(cartas);		
	}
	
	public Carta GetPosicion() {
		return cartas.get(pos);
	}
	
	//agrega la carta verificando tope y atributo
	public void addCarta(Carta c) {
		int pos = 0;
			if(cartas.size()==0) {
				cartas.add(c);
			}
			else if(c.equals(cartas.get(pos))) {
				cartas.add(c);
			}
			else {
				System.out.println(" La carta "+c.getNombreDePersonaje()+ " no cumple con las caraceristicas adecuadas " );
			}
	}
	
	public Carta remove( int pos) {
	  return cartas.remove(pos);
	}
	
	public void CargarMazo(String jsonFile) {
        //URL url = getClass().getResource(jsonFile);
        File jsonInputFile = new File(jsonFile);
        InputStream is;
        try {
            is = new FileInputStream(jsonInputFile);
            // Creo el objeto JsonReader de Json.
            JsonReader reader = Json.createReader(is);
            // Obtenemos el JsonObject a partir del JsonReader.
            JsonArray cartas = (JsonArray) reader.readObject().getJsonArray("cartas");
	            for (JsonObject carta : cartas.getValuesAs(JsonObject.class)) {
	                String nombreCarta = carta.getString("nombre");
	                Carta carta1= new Carta(nombreCarta);
	                	JsonObject atributos = (JsonObject)carta.getJsonObject("atributos");
                for (String nombreAtributo:atributos.keySet()) {
                	int valorDeAtributo=atributos.getInt(nombreAtributo);
                	Atributo nuevo= new Atributo(nombreAtributo,valorDeAtributo);
                	carta1.add(nuevo);

                }
                this.addCarta(carta1);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();        
            }
    }
		
	@Override
	public String toString() {
		return "Mazo [cartas=" + cartas + "]";
	}
	
}