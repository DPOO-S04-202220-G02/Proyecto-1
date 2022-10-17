package proyecto1_final.consola;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import proyecto1_final.modelo.Equipo_Fantasia;
import proyecto1_final.modelo.Jugador;
import proyecto_1_final.procesamiento.creacionBaseDeDatos;
import proyecto_1_final.procesamiento.LoaderJugadores;


public class consola {
	
	private creacionBaseDeDatos baseDeDatos;
	
	public void ejecutarAplicacion() {
	System.out.println("Bienvenido a la aplicación de  los equipos de Fantasia");
	boolean continuar = true;
	while (continuar)
	{
		try
		{
			mostrarMenu();
			int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
			if (opcion_seleccionada == 1)
				ejecutarCargarJugadores();
			else if (opcion_seleccionada == 2 )
				ejecutarCargarResultadosPartido();
			/*else if (opcion_seleccionada == 3 && baseDeDatos != null)
				ejecutarAccederListaJugadores();*/
			else if (opcion_seleccionada == 4 && baseDeDatos != null)
				ejecutarCrearEquipo();
			/*else if (opcion_seleccionada == 5 && baseDeDatos != null)
				ejecutarInformacionEquipoFantasia();
			else if (opcion_seleccionada == 6 && baseDeDatos != null)
				ejecutarModificarAlineacionEquipo();
			else if (opcion_seleccionada == 7 && baseDeDatos != null)
				ejecutarTransferenciaJugadores();
			else if (opcion_seleccionada == 8 && baseDeDatos != null)
				ejecutarGanadorTemporada);
			else if (opcion_seleccionada == 9 && baseDeDatos != null)
				ejecutarJornadasTemporada();
			else if (opcion_seleccionada == 10 && baseDeDatos != null)
				ejecutarEstadisticasJugador();*/
			else if (opcion_seleccionada == 11)
			{
				System.out.println("Saliendo de la aplicación ...");
				continuar = false;
			}
			else if (baseDeDatos == null)
			{
				System.out.println("Para poder ejecutar esta opción primero debe cargar un archivo de atletas.");
			}
			else
			{
				System.out.println("Por favor seleccione una opción válida.");
			}
		}
		catch (NumberFormatException e)
		{
			System.out.println("Debe seleccionar uno de los números de las opciones.");
		}
	}
	}
	public void mostrarMenu() {
		System.out.println("1. Cargar archivo de los jugadores");
		System.out.println("2. Cargar archivo de los resultados del partido");
		System.out.println("3. Mostrar catalogo de jugadores");
		System.out.println("4. Crear un Equipo");
		System.out.println("5. Acceder a la información de un Equipo de Fantasia");
		System.out.println("6. Modificar alineación de un Equipo");
		System.out.println("7. Transferencia de jugadores");
		System.out.println("8. Consultar ganador de la temporada");
		System.out.println("9. Consultar las jornadas de la temporada");
		System.out.println("10. Consultar las estadisticas de un jugador");
		System.out.println("11. Salir de la aplicación");

	}
	
	private void ejecutarCrearEquipo() {
		System.out.println("Bienvenido a la creación de tu equipo");
		System.out.println("Cada equipo debe tener máximo 15 jugadores y cuentas con un presupuesto de 100 millones");
		System.out.println("Debe tener 2 arqueros, 5 defensores, 5 mediocampistas y 3 delanteros");
		String nombreEquipo = input("Ingrese el nombre de su equipo:");
		boolean equipoNoCompleto= true;
		Equipo_Fantasia equipoNuevo = new Equipo_Fantasia(nombreEquipo,false);
		int porteros = 0;
		int defensas = 0;
		int mediocentros = 0;
		int delanteros = 0;
		
		while (equipoNoCompleto) {
			String jugador = input("Ingrese el nombre de un jugador deseado: ");
			
			Jugador infoJugador = baseDeDatos.jugadorPorNombre(jugador);
			if (infoJugador == null) {
				System.out.println("El jugador no existe");
			}
			else {
				System.out.println("El jugador " + infoJugador.darPosicion());
				boolean existe = equipoNuevo.existeJugador(jugador);
				boolean limitePos = limitePos(infoJugador.darPosicion(), porteros, defensas, mediocentros, delanteros);
				boolean tienePresupuesto = tienePresupuesto(infoJugador.darPrecio(), equipoNuevo.darPresupuesto());
				if (existe == true) {
					System.out.println("El jugador ya esta en tu equipo");
				}
				else if (limitePos == false ) {
					System.out.println("Ya existen jugadores para la posición buscada");
					
				}
				else if ( tienePresupuesto== false) {
					System.out.println("Saldo Insuficiente");
				}
				else {
					equipoNuevo.agregarJugador(infoJugador);
					System.out.println(jugador + " fue añadido a " + nombreEquipo );
					System.out.println("El presupuesto restante es: " + equipoNuevo.darPresupuesto());
					if (infoJugador.darPosicion().equals("arquero")) {
						porteros ++;
					}
					if (infoJugador.darPosicion().equals("defensa")) {
						defensas ++;
					}
					if (infoJugador.darPosicion().equals("mediocentro")) {
						mediocentros ++;
					}
					if (infoJugador.darPosicion().equals("delantero")) {
						delanteros ++;
					}
					if (porteros + defensas + mediocentros + delanteros == 15 ) {
						equipoNoCompleto = false;
					}
				}
			}
		
		}
		System.out.println("Completaste tu equipo de Fantasia :) <3");
		baseDeDatos.agregarEquipo_Fantasia(equipoNuevo);
		
		
	}
	
	private boolean limitePos(String posicion, int porteros, int defensas, int mediocentros, int delanteros) {
		if (posicion.equals("arquero") && porteros == 2) {
			return false;
		}
		if (posicion.equals("defensa") && defensas ==5) {
			return false;
		}
		if (posicion.equals("mediocentro") && mediocentros ==5) {
			return false;
		}
		if (posicion.equals("delantero") && delanteros ==3) {
			return false;
		}
		return true;
	}
	
	private boolean tienePresupuesto(int precio, int presupuesto) {
		if(presupuesto - precio > 0) {
			return true;
		}
		return false;
	}
	
	
	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje);
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	private void ejecutarCargarResultadosPartido() {
		try
		{
			baseDeDatos = LoaderJugadores.cargarArchivo2(archivo2);
			System.out.println("Se cargó el archivo " + archivo2 + " con información de los partidos.");
		}
	
		catch (FileNotFoundException e)
		{
			System.out.println("ERROR: el archivo indicado no se encontró.");
		}
		catch (IOException e)
		{
			System.out.println("ERROR: hubo un problema leyendo el archivo.");
			System.out.println(e.getMessage());
		}

	}
	private void ejecutarCargarJugadores() {
		try
		{
			String archivo = "data/Jugadores Fantasy League.csv";
			baseDeDatos = LoaderJugadores.cargarArchivo(archivo);
			System.out.println("Se cargó el archivo " + archivo + " con información de los jugadores.");
		}
	
		catch (FileNotFoundException e)
		{
			System.out.println("ERROR: el archivo indicado no se encontró.");
		}
		catch (IOException e)
		{
			System.out.println("ERROR: hubo un problema leyendo el archivo.");
			System.out.println(e.getMessage());
		}

	}
	public static void main(String[] args)
	{
		consola consola = new consola();
		consola.ejecutarAplicacion();
	}
}
