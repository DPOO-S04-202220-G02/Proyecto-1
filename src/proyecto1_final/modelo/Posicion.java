package proyecto1_final.modelo;

public enum Posicion {
	PORTERO, DEFENSA, MEDIOCENTRO, DELANTERO;
	
	public String darPosicionJugador()
	{
		return toString().toLowerCase();
	}
}
