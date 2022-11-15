package proyecto1_final.modelo;

import java.util.HashMap;
import java.util.Map;


public class Puntos {
	
	//atributos
	
	//1.lista de la jornada
	private Posicion posicionJugador;
	private int TiempoJugado;
	private int Goles_anotados;
	private int Goles_recibidos;
	private int Asistencias;
	private int penaltiFallado;
	private int penaltiAtajado;
	private int tarjetasAmarillas;
	private int tarjetasRojas;
	private int autogol;
	private int contador_puntos;
	private int puntos_totales;
	
	public void calcularPuntos() {
		contador_puntos = 0;
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
				if (posicionJugador == Posicion.PORTERO && penaltiAtajado >= 1) {
					contador_puntos = contador_puntos + 5*penaltiAtajado;}
				if (penaltiFallado >= 1) {
					contador_puntos = contador_puntos - 2*penaltiFallado;}
				if (tarjetasAmarillas != 0) {
					contador_puntos = contador_puntos - 1;}
				if (tarjetasRojas != 0) {
					contador_puntos = contador_puntos - 3;}
				if (autogol  >= 1) {
					contador_puntos = contador_puntos - 2*penaltiFallado;}	
		
				this.puntos_totales = contador_puntos;
		
		
	}
	
	public Puntos (Posicion posicionJugador, int TiempoJugado,int Goles_anotados,int Goles_recibidos, int Asistencias, int penaltiFallado, int penaltiAtajado, int tarjetasAmarillas, int tarjetasRojas, int autogol) {
		this.posicionJugador = posicionJugador;
		this.TiempoJugado = TiempoJugado;
		this.Goles_anotados = Goles_anotados;
		this.Goles_recibidos = Goles_recibidos;
		this.Asistencias = Asistencias;
		this.penaltiFallado = penaltiFallado;
		this.penaltiAtajado = penaltiAtajado;
		this.tarjetasAmarillas = tarjetasAmarillas;
		this.tarjetasRojas = tarjetasRojas;
		this.autogol = autogol;
		

	}
	public int darPuntosTotales() {
		return this.puntos_totales;
	}
	
	
	

}
