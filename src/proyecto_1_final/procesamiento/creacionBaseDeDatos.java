package proyecto_1_final.procesamiento;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import proyecto1_final.modelo.Equipo;
import proyecto1_final.modelo.Equipo_Fantasia;
import proyecto1_final.modelo.Jugador;

public class creacionBaseDeDatos {
	//Atributos 
	
	//1. Lista de jugadores sin estar repetidos
	private Map<String, Jugador> lista_de_jugadores;
	
	//2. Lista de equipos sin estar repetidos
	private Map<String, Equipo> lista_de_equipos;
	
	private Map<String, Equipo_Fantasia> lista_de_equipos_fantasia;
	
	// FUNCION CONSTRUCTORA 
	// tiene 2 parametros: El nombre y el equipo
	
	public creacionBaseDeDatos(Map<String, Jugador> jugadores,Map<String, Equipo> equipos) {
		this.lista_de_jugadores = jugadores;
		this.lista_de_equipos = equipos;
		this.lista_de_equipos_fantasia = new HashMap<>();
	}
	
	// Métodos
	
	/* Selecciona los jugadores que hacen parte de un equipo
	 * Parametros : Nombre del Equipo
	 * Resultado : Mapa donde las llaves son los nombres de los jugadores 
	 * y los valores son la información de cada jugador
	 */

	public Map<String, List<Jugador>> jugadoresPorEquipo(String nombreEquipo){
		Map<String, List<Jugador>> resultado = new HashMap<String, List<Jugador>>();
		return resultado;
	}
	
	public Jugador jugadorPorNombre(String nombre) {
		Jugador elJugador = lista_de_jugadores.get(nombre);
		if (elJugador == null) {
			return null;
		} 
		
		return elJugador;
	
	}
	public void agregarEquipo_Fantasia(Equipo_Fantasia equipo_fantasia) {
		lista_de_equipos_fantasia.put(equipo_fantasia.darNombre(),equipo_fantasia);
	}
		
	public void agregarEquipo_FantasiaConNombre(Equipo_Fantasia equipo_fantasia, String nombre) {
			lista_de_equipos_fantasia.put(nombre,equipo_fantasia);
	}
	
	public Map<String, Jugador> darMapaJugadpres() {
		return this.lista_de_jugadores;
	}
	
	public Equipo_Fantasia darEquipoFantasiaPorNombre(String nombre) {
		Equipo_Fantasia Equipo_Fantasia = lista_de_equipos_fantasia.get(nombre);
		if (Equipo_Fantasia == null) {
			return null;
		} 
		
		return Equipo_Fantasia;
	}
	public void actualizarJugador(String nombre, Jugador jugador) {
		this.lista_de_jugadores.put(nombre, jugador);
	}
	
}
	
