package proyecto_1_final.procesamiento;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import proyecto1_final.modelo.Alineacion;
import proyecto1_final.modelo.Puntos;
import proyecto1_final.modelo.rankings;
import proyecto1_final.modelo.Equipo_Fantasia;
import proyecto1_final.modelo.Estadisticas;
import proyecto1_final.modelo.Posicion;
import proyecto1_final.modelo.Transferencias;

public class LoaderResultadosJornada {
	public static CreacionBaseDedDatosResultados cargarArchivo(String nombreArchivo2) throws FileNotFoundException, IOException
	{
		nombreArchivo2 = "data/Jornada 1 Fantasy League.csv";
		List<Jornada> jugadores_jornada = new ArrayList<>();
		Map<String, Equipo_Fantasia> info_jugadores = new HashMap<>();
		BufferedReader br = new BufferedReader(new FileReader(nombreArchivo2));
		String linea = br.readLine();
		
		linea = br.readLine();
		while (linea != null) {
			String[] lista_jornada = linea.split(";");
			int NumJornada = Integer.parseInt(lista_jornada[0]);
			String nombreJugador = lista_jornada[1];
			Posicion posicionJugador = Posicion.valueOf(lista_jornada[2].toUpperCase());
			int TiempoJugado = Integer.parseInt(lista_jornada[3]);
			int Goles_anotados = Integer.parseInt(lista_jornada[4]);
			int Goles_recibidos = Integer.parseInt(lista_jornada[5]);
			int Asistencias = Integer.parseInt(lista_jornada[6]);
			Boolean penaltiFallado = Boolean.parseBoolean(lista_jornada[7]);
			Boolean penaltiAtajado = Boolean.parseBoolean(lista_jornada[8]);
			int tarjetasAmarillas = Integer.parseInt(lista_jornada[9]);
			int tarjetasRojas = Integer.parseInt(lista_jornada[10]);
			int autogol = Integer.parseInt(lista_jornada[11]);
			
			Jornada laJornada = new Jornada(NumJornada,nombreJugador,posicionJugador,TiempoJugado,Goles_anotados,Goles_recibidos,Asistencias,penaltiFallado,penaltiAtajado,tarjetasAmarillas,tarjetasRojas,autogol);
		}
	}
	
}
