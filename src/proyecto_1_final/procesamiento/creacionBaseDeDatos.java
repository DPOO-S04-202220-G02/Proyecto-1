package proyecto_1_final.procesamiento;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import proyecto1_final.modelo.Equipo;
import proyecto1_final.modelo.Jugador;
import uniandes.dpoo.taller0.modelo.Atleta;

public class creacionBaseDeDatos {
	//Atributos 
	
	//1. Lista de jugadores sin estar repetidos
	private List<Jugador> lista_de_jugadores;
	
	//2. Lista de equipos sin estar repetidos
	private List<Equipo> lista_de_equipos;
	
	// FUNCION CONSTRUCTORA 
	// tiene 2 parametros: El nombre y el equipo
	
	public creacionBaseDeDatos(Map<String, Jugador> jugadores,Map<String, Equipo> equipos) {
		this.lista_de_jugadores = new ArrayList <Jugador>(jugadores.values());
		this.lista_de_equipos = new ArrayList <Equipo>(equipos.values());
	}
	
	// Métodos
	
	/* Selecciona los jugadores que hacen parte de un equipo
	 * Parametros : Nombre del Equipo
	 * Resultado : Mapa donde las llaves son los nombres de los jugadores 
	 * y los valores son la información de cada jugador
	 */

	public Map<String, List<Jugador>> jugadoresPorEquipo(String nombreEquipo){
		Map<String, List<Jugador>> resultado = new HashMap<String, List<Jugador>>();
		
	}
}
