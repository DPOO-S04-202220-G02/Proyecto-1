package proyecto_1_final.procesamiento;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import proyecto1_final.modelo.Puntos;
import proyecto1_final.modelo.rankings;
import proyecto1_final.modelo.Equipo_Fantasia;
import proyecto1_final.modelo.Estadisticas;
import proyecto1_final.modelo.Jornada;
import proyecto1_final.modelo.Jugador;
import proyecto1_final.modelo.Posicion;
import proyecto1_final.modelo.Transferencias;

public class LoaderResultadosJornada {
	public static creacionBaseDeDatos cargarArchivo(String nombreArchivo2, creacionBaseDeDatos baseDeDatos) throws FileNotFoundException, IOException
	{
		
		List<Jornada> jugadores_jornada = new ArrayList<>();
		Map<String, Equipo_Fantasia> info_jugadores = new HashMap<>();
		BufferedReader br = new BufferedReader(new FileReader(nombreArchivo2));
		String linea = br.readLine();
		
		linea = br.readLine();
		while (linea != null) {
			String[] lista_jornada = linea.split(",");
			String NumJornada = (lista_jornada[0]);
			String nombreJugador = lista_jornada[1];
			Posicion posicionJugador = Posicion.valueOf(lista_jornada[2].toUpperCase());
	
			int TiempoJugado = Integer.parseInt(lista_jornada[3]);
			int Goles_anotados = Integer.parseInt(lista_jornada[4]);
			int Goles_recibidos = Integer.parseInt(lista_jornada[5]);
			int Asistencias = Integer.parseInt(lista_jornada[6]);
			int penaltiFallado = Integer.parseInt(lista_jornada[7]);
			int penaltiAtajado =Integer.parseInt(lista_jornada[8]);
			int tarjetasAmarillas = Integer.parseInt(lista_jornada[9]);
			int tarjetasRojas = Integer.parseInt(lista_jornada[10]);
			int autogol = Integer.parseInt(lista_jornada[11]);
			int manos = Integer.parseInt(lista_jornada[12]);
			int tiro_libre_cobrado = Integer.parseInt(lista_jornada[13]);
			int gol_tiro_libre = Integer.parseInt(lista_jornada[14]);
			String estado_final = (lista_jornada[15]);
			Jugador jugador = baseDeDatos.jugadorPorNombre(nombreJugador);
			if (jugador!= null) {
			Puntos puntos = new Puntos(posicionJugador,TiempoJugado,Goles_anotados,Goles_recibidos,Asistencias,penaltiFallado,penaltiAtajado,tarjetasAmarillas,tarjetasRojas,autogol,manos,tiro_libre_cobrado,gol_tiro_libre,estado_final);
			puntos.calcularPuntos();
			jugador.agregarPuntosJornada(puntos, NumJornada);
			baseDeDatos.actualizarJugador(nombreJugador, jugador);
			}
			
			linea = br.readLine();
		}
		return baseDeDatos;
	}
	
}
