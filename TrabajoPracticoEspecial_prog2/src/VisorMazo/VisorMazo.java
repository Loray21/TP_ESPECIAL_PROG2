package VisorMazo;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import Juego.Atributo;
import Juego.Carta;
import Juego.Juego;
import Juego.Jugador;
import Juego.Mazo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class VisorMazo {

    public static Mazo mostrarMazo(String jsonFile) {
    	 Mazo mazo= new Mazo();
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
                JsonObject atributos = (JsonObject) carta.getJsonObject("atributos");
                for (String nombreAtributo:atributos.keySet()) {
                	int valorDeAtributo=atributos.getInt(nombreAtributo);
                	Atributo nuevo= new Atributo(nombreAtributo,valorDeAtributo);
                	carta1.add(nuevo);

                }
                mazo.addCarta(carta1);
               
              
            }
            reader.close();
            return mazo;

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args) {
        String mazoPath = "./src/VisorMazo/superheroes.json";
        Mazo m1= new Mazo();
         m1=VisorMazo.mostrarMazo(mazoPath);
       
    }
}