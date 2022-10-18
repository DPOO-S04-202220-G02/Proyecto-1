package proyecto1_final.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import proyecto1_final.modelo.Alineacion;

public class Equipo_Fantasia {
	
	//Atributos 
	
	private String nombre;
	
	public int puntos_equipo;
	
	private Map<String,Jugador> jugadores;
	
	private Map<String,Jugador> titulares;
	
	private boolean transferencias;
	
	private int presupuesto;
	
	// Funcion constructora 
	
	public Equipo_Fantasia (String elNombre, boolean hay_transferencias) {
		this.nombre = elNombre;
		this.transferencias = hay_transferencias;	
		this.presupuesto = 100000000;
		this.jugadores = new HashMap<>();
		this.titulares = new HashMap<>();
		
	}
	
	public boolean existeJugador(String nombre) {
		if (jugadores == null) {
			return false;
		}
		Jugador elJugador = jugadores.get(nombre);
		if (elJugador == null) {
			return false;
		} 
		
		return true;
	
	}
	
	public int darPresupuesto() {
		return this.presupuesto;
	}
	
	public String darNombre() {
		return this.nombre;
	}
	
	public void agregarJugador(Jugador jugador) {
		jugadores.put(jugador.darNombre(),jugador);
		this.presupuesto = this.presupuesto - jugador.darPrecio();
		
	}
	
	public void agregarJugadorTitular(Jugador jugador) {
		titulares.put(jugador.darNombre(),jugador);
		
		
	}
	
	
	public Map<String,Jugador> darEquipoFantasia() {
		
		return this.jugadores;
		
	}
	
	public Jugador jugadorPorNombre(String nombre) {
		Jugador elJugador = jugadores.get(nombre);
		if (elJugador == null) {
			return null;
		} 
		
		return elJugador;
		
	}
	
	
	

	
	






	





	
	
	
	
	
	
	
		

}
