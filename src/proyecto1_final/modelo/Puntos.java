package proyecto1_final.modelo;

import java.util.HashMap;
import java.util.Map;



public class Puntos {
	
	//atributos
	
	//1.lista de la jornada
	
	private String nombre;
	private Posicion posicionJugador;
	private int TiempoJugado;
	private int Goles_anotados;
	private int Goles_recibidos;
	private int Asistencias;
	private boolean penaltiFallado;
	private boolean penaltiAtajado;
	private int tarjetasAmarillas;
	private int tarjetasRojas;
	private boolean autogol;
	private int contador_puntos;
	
	public void calcularPuntos() {
		Map<String, Jugador> jugador_puntos = new HashMap<>();
		contador_puntos = 0;
		while (jugador_puntos != null) {
			if (TiempoJugado < 60){
				contador_puntos = contador_puntos + 1;}
			if (TiempoJugado >= 60) {
				contador_puntos = contador_puntos + 2;}
			if (posicionJugador == Posicion.DELANTERO && Goles_anotados > 0) {
				contador_puntos = contador_puntos + (4*Goles_anotados);}
			if (posicionJugador == Posicion.MEDIOCENTRO && Goles_anotados > 0) {
				contador_puntos = contador_puntos + (5*Goles_anotados);}
			if ((posicionJugador == Posicion.DEFENSA ||posicionJugador == Posicion.PORTERO)  && Goles_anotados > 0){
				contador_puntos = contador_puntos + (6*Goles_anotados);}
			if (Asistencias > 0) {
				contador_puntos = contador_puntos + (3*Asistencias);}
			if (Goles_recibidos == 0 && (posicionJugador == Posicion.DEFENSA ||posicionJugador == Posicion.PORTERO)) {
				contador_puntos = contador_puntos + 4;}
			if (posicionJugador == Posicion.PORTERO && penaltiAtajado == true) {
				contador_puntos = contador_puntos + 5;}
			if (penaltiFallado == true) {
				contador_puntos = contador_puntos - 2;}
			if (tarjetasAmarillas != 0) {
				contador_puntos = contador_puntos - 1;}
			if (tarjetasRojas != 0) {
				contador_puntos = contador_puntos - 3;}
			if (autogol != false) {
				contador_puntos = contador_puntos - 2;}			
		}
	}
	

}
