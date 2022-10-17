package proyecto_1_final.procesamiento;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import proyecto1_final.modelo.Jugador;
import proyecto1_final.modelo.Equipo;
import proyecto1_final.modelo.Posicion;


public class LoaderJugadores {

	public static creacionBaseDeDatos cargarArchivo(String nombreArchivo) throws FileNotFoundException, IOException
	{ 			
		Map<String, Jugador> jugadores = new HashMap<>();
		Map<String, Equipo> equipos = new HashMap<>();
		BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
		String linea = br.readLine();
		
		linea = br.readLine();
		while (linea != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
		{
			// separar los valores que hay en la linea
			String[] jugadores_lista = linea.split(",");
			String nombreJugador = jugadores_lista[0];
			String nombreEquipo = jugadores_lista[1];
			Posicion posicionJugador = Posicion.valueOf(jugadores_lista[2].toUpperCase());
			int precioJugador = Integer.parseInt(jugadores_lista[3]);
			// si el equipo no existe, se agrega 
			Equipo elEquipo = equipos.get(nombreEquipo);
			if (elEquipo == null) {
				elEquipo = new Equipo(nombreEquipo);
				equipos.put(nombreEquipo,elEquipo);
			}
			// si el jugador no existe, agregarlo
			Jugador elJugador = jugadores.get(nombreJugador);
			if (elJugador == null) {
				elJugador = new Jugador(nombreJugador,elEquipo,posicionJugador,precioJugador);
				jugadores.put(nombreJugador,elJugador);
				
			}
			linea = br.readLine();
		}
		br.close();
		creacionBaseDeDatos baseDeDatos = new creacionBaseDeDatos(jugadores,equipos);
		return baseDeDatos;
	}
}
