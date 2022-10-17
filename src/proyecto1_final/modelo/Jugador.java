package proyecto1_final.modelo;


/**
 * Esta clase agrupa toda la información sobre los jugadores y calcula algunas cosas
 * sobre sus esultados.
 */
public class Jugador {
	// Atributos 
	// 1. Nombre del jugador (Se supone que no hay jugadores repetidos)
	private String nombre;
	// 2. Equipo del jugador 
	private Equipo equipo; 
	// 3. Posicion en la que juega
	private Posicion posicion;
	// 4. Precio de compra/venta 
	private int precio;

	
	//FUNCIÓN CONSTRUCTORA
	/**
	 * Construye un jugador y relaciona los atributos con los parametros.
	 * 
	 * @param elNombre El nombre del jugador.
	 * @param elEquipo El equipo del jugador.
	 * @param laPosicion  La posición en la que juega
	 * @param elPrecio  Precio de compra/venta del jugador
	 */
	public Jugador(String elNombre, Equipo elEquipo, Posicion laPosicion, int elPrecio) {
		this.nombre = elNombre;
		this.equipo = elEquipo;
		this.posicion = laPosicion;
		this.precio = elPrecio;

	}
	

	// Métodos para consultar los atributos

	public String darNombre() {
		return nombre;
	}
	
	public String darEquipo() {
		return equipo;
	}
	public String darPosicion() {
		return posicion.darPosicionJugador();
	}
	public int darPrecio() {
		return precio;
	}
	
	
	
}
