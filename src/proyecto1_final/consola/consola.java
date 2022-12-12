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
import proyecto_1_final.procesamiento.CreacionBaseDedDatosResultados;
import proyecto_1_final.procesamiento.LoaderJugadores;
import proyecto_1_final.procesamiento.LoaderResultadosJornada;


public class consola {
	
	private creacionBaseDeDatos baseDeDatos;
	private CreacionBaseDedDatosResultados baseDeDatosResultados;
	
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
			else if (opcion_seleccionada == 3 && baseDeDatos != null)
				ejecutarAccederListaJugadores();
			else if (opcion_seleccionada == 4 && baseDeDatos != null)
				ejecutarCrearEquipo();
			else if (opcion_seleccionada == 5 && baseDeDatos != null)
				ejecutarInformacionEquipoFantasia();
			else if (opcion_seleccionada == 6 && baseDeDatos != null)
				ejecutarModificarAlineacionEquipo();
			/*else if (opcion_seleccionada == 7 && baseDeDatos != null)
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
				
				boolean existe = equipoNuevo.existeJugador(jugador);
				boolean limitePos = limitePos(infoJugador.darPosicion(), porteros, defensas, mediocentros, delanteros, 1);
				boolean tienePresupuesto = tienePresupuesto(infoJugador.darPrecio(), equipoNuevo.darPresupuesto());
				if (existe == true) {
					System.out.println("El jugador ya esta en tu equipo");
				}
				else if (limitePos == false ) {
					System.out.println("Ya existen jugadores para" + infoJugador.darPosicion()+ "s");
					
				}
				else if ( tienePresupuesto== false) {
					System.out.println("Saldo Insuficiente");
				}
				else {
					equipoNuevo.agregarJugador(infoJugador);
					System.out.println(jugador + " fue añadido a " + nombreEquipo );
					System.out.println("El presupuesto restante es: " + equipoNuevo.darPresupuesto());
					if (infoJugador.darPosicion().equals("portero")) {
						porteros ++;
						System.out.println("Ha seleccionado " + porteros + " " + infoJugador.darPosicion()+"(s)");
					}
					if (infoJugador.darPosicion().equals("defensa")) {
						defensas ++;
						System.out.println("Ha seleccionado " + defensas + " " + infoJugador.darPosicion()+"(s)");
					}
					if (infoJugador.darPosicion().equals("mediocentro")) {
						mediocentros ++;
						System.out.println("Ha seleccionado " + mediocentros + " " + infoJugador.darPosicion()+"(s)");
					}
					if (infoJugador.darPosicion().equals("delantero")) {
						delanteros ++;
						System.out.println("Ha seleccionado " + delanteros + " " + infoJugador.darPosicion()+"(s)");
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
	
	private boolean limitePos(String posicion, int porteros, int defensas, int mediocentros, int delanteros, int tipo_equipo) {
		if (tipo_equipo == 1) {
		
		if (posicion.equals("portero") && porteros == 2) {
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
		}
		
		else if (tipo_equipo == 2) {
			
			if (posicion.equals("portero") && porteros == 1) {
				return false;
			}
			if (posicion.equals("defensa") && defensas ==4) {
				return false;
			}
			if (posicion.equals("mediocentro") && mediocentros ==4) {
				return false;
			}
			if (posicion.equals("delantero") && delanteros ==2) {
				return false;
			}
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
			String nombreArchivo = "data/Jornadas Fantasy League.csv";
			baseDeDatos = LoaderResultadosJornada.cargarArchivo(nombreArchivo, baseDeDatos);
			System.out.println("Se cargó el archivo " + nombreArchivo + " con información de los partidos.");
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
	private void ejecutarCargarJugadores(){
		try
		{
			String archivo = "data/Jornadas Fantasy League.csv";
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
	
	private void ejecutarAccederListaJugadores() {
		System.out.println("Este es el catalogo de los jugadores de la liga de fantasia");
		for (Map.Entry jugador: baseDeDatos.darMapaJugadpres().entrySet()) {
			Jugador info = (Jugador) jugador.getValue();
			System.out.println("Nombre: " + info.darNombre());
			System.out.println("Posicion: " + info.darPosicion());
			System.out.println("Equipo: " + info.darEquipo());
			System.out.println("Precio: " + info.darPrecio());
			System.out.println("Puntos: " + info.darPuntosTotales());
			System.out.println("------------------------------");
		}
		 
	}
	
	public void ejecutarModificarAlineacionEquipo() {
		String nombre = input("Ingrese el nombre de su equipo de fantasia: ");
		Equipo_Fantasia equipoFantasia = baseDeDatos.darEquipoFantasiaPorNombre(nombre);
		
		boolean equipoTitularNoCompleto= true;
		int porteros = 0;
		int defensas = 0;
		int mediocentros = 0;
		int delanteros = 0;
		if (equipoFantasia == null) {
			System.out.println("EL nombre de su equipo no se encuentra en la base de datos :(" );
		}
		else {
			System.out.println("Este es su equipo de fantasia.");
			for (Map.Entry jugadores: equipoFantasia.darEquipoFantasia().entrySet()) {
				Jugador info = (Jugador) jugadores.getValue();
				System.out.println("Nombre: " + info.darNombre());
				System.out.println("Posicion: " + info.darPosicion());
				System.out.println("Equipo: " + info.darEquipo());
				System.out.println("------------------------------");
			}
			
			while (equipoTitularNoCompleto) {
				String jugador = input("Ingrese el nombre de un jugador que desee que sea titular: ");
				Jugador infoJugador = equipoFantasia.jugadorPorNombre(jugador);
				boolean existe = equipoFantasia.existeJugador(jugador);
				boolean existe1 = equipoFantasia.existeJugadorTitular(jugador);
				
				
				if (existe1 == true) {
					System.out.println("El jugador ya esta en tu equipo");
				}
				else if (existe == false) {
					System.out.println("El jugador no esta en tu equipo de fantasia :( </3");
				}
				
	
				else {
					boolean limitePos = limitePos(infoJugador.darPosicion(), porteros, defensas, mediocentros, delanteros, 2);
					 if (limitePos == false ) {
						System.out.println("Ya escogiste tus titulares para la posición buscada");
					}
					 else {
						equipoFantasia.agregarJugadorTitular(infoJugador);
						System.out.println(jugador + " fue añadido a tu formacion titular" );
						if (infoJugador.darPosicion().equals("portero")) {
							porteros ++;
							System.out.println("Ha seleccionado " + porteros + " " + infoJugador.darPosicion()+"(s)");
						}
						if (infoJugador.darPosicion().equals("defensa")) {
							defensas ++;
							System.out.println("Ha seleccionado " + defensas + " " + infoJugador.darPosicion()+"(s)");
						}
						if (infoJugador.darPosicion().equals("mediocentro")) {
							mediocentros ++;
							System.out.println("Ha seleccionado " + mediocentros + " " + infoJugador.darPosicion()+"(s)");
						}
						if (infoJugador.darPosicion().equals("delantero")) {
							delanteros ++;
							System.out.println("Ha seleccionado " + delanteros + " " + infoJugador.darPosicion()+"(s)");
						}
						if (porteros + defensas + mediocentros + delanteros == 11 ) {
							equipoTitularNoCompleto = false;
						}
					 }
					}	
				
			}
				System.out.println("Completaste tu equipo titular :) <3");
				baseDeDatos.agregarEquipo_Fantasia(equipoFantasia);
			
			}
			
			
	}
	
	public void ejecutarInformacionEquipoFantasia() {
	System.out.println("Esta es la informacion de su equipo de fantasia:" );
	String nombre = input("Ingrese el nombre de su equipo de fantasia: ");
	Equipo_Fantasia equipoFantasia = baseDeDatos.darEquipoFantasiaPorNombre(nombre);
	int puntosEquipo = 0;
	if (equipoFantasia == null) {
		System.out.println("EL nombre de su equipo no se encuentra en la base de datos :(" );
	}
	else {
	System.out.println("Que opcion desea ejecutar:" );
	System.out.println("1. Ver puntos totales de todas las jornadas:");
	System.out.println("2. Ver puntos totales de una jornada:");
	int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
	if(opcion_seleccionada == 1) {
		
	
	for (Map.Entry jugadores: equipoFantasia.darEquipoFantasia().entrySet()) {
		Jugador info = (Jugador) jugadores.getValue();
		System.out.println("Nombre: " + info.darNombre());
		System.out.println("Posicion: " + info.darPosicion());
		System.out.println("Equipo: " + info.darEquipo());
		System.out.println("Puntos: " + info.darPuntosTotales());
		System.out.println("------------------------------");
		puntosEquipo = puntosEquipo +info.darPuntosTotales();
	}
	System.out.println("La cantidad de puntos totales de su equipo de fantasia es: "+ puntosEquipo);
	}
	if(opcion_seleccionada == 2) {
		 String jornada = input("Por favor seleccioneel numero de la jornada a ver: ");
		
		for (Map.Entry jugadores: equipoFantasia.darTitularEquipoFantasia().entrySet()) {
			Jugador info = (Jugador) jugadores.getValue();
			System.out.println("Nombre: " + info.darNombre());
			System.out.println("Posicion: " + info.darPosicion());
			System.out.println("Equipo: " + info.darEquipo());
			System.out.println("Puntos: " + info.darPuntosJornada(jornada));
			System.out.println("------------------------------");
			puntosEquipo = puntosEquipo +info.darPuntosJornada(jornada);
		}
		System.out.println("La cantidad de puntos totales en la jornada " + jornada + " de su equipo de fantasia es: "+ puntosEquipo);
		}
	}
	}
	
	
	public static void main(String[] args)
	{
		consola consola = new consola();
		consola.ejecutarAplicacion();
	}
	
	
}
