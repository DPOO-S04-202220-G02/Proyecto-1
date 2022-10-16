package proyecto1_final.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


/*
 * Esta clase tiene la información de un equipo y sus jugadores
 */
public class Equipo {
	// Atributos 
	// 1. Nombre del equipo 
	
	private String nombreEquipo;
	private List<Jugador> jugadores;
	
	//FUNCION CONSTRUCTORA 
	public Equipo(String nombre) {
		this.nombreEquipo = nombre;
		jugadores = new ArrayList<Jugador>();
	}
	
	// Métodos para consultar los atributos

	public String darNombreEquipo() {
		return nombreEquipo;
	}
	
}
