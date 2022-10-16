package proyecto1_final.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import uniandes.dpoo.taller0.modelo.Atleta;


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
	// Método para agregar un jugador a la lista de jugadores del equipo
	public void agregarJugador(Jugador elJugador) {
		jugadores.add(elJugador);
	}
	// Método para acceder a la lista de mapas de los jugadores del equipo
	
	
	
	
	
	
}
