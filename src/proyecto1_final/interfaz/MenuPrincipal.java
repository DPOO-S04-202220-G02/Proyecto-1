package proyecto1_final.interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.*;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;


public class MenuPrincipal extends JFrame implements ActionListener
{
	private JButton cargar_jugadores;
	
	private JButton cargar_jornadas;
	
	private JButton mostrar_jugadores;
	
	private JButton crear_equipo;
	
	private JButton acceder_equipo;
	
	private JButton modificar_alineacion;
	
	private JButton transferencias;
	
	private JButton consultar_liga;
	
	private JButton consultar_jornada;
	
	private JButton consultar_jugador;
	
	private JButton salir;
	
	private InterfazFantasy fantasy;

	private JPanel panelUsuario;
	
	 public MenuPrincipal(InterfazFantasy interfazFantasy)
	    {
		 	fantasy = interfazFantasy;
	        setTitle( "Menu Principal" );
	        setSize( 580, 700 );
	        setDefaultCloseOperation( JDialog.DISPOSE_ON_CLOSE );
	        
	        panelUsuario = new JPanel( );

	        panelUsuario.setBorder( new CompoundBorder( new TitledBorder( "Registro del Usuario" ), new EmptyBorder( 3, 3, 3, 3 ) ) );
	        panelUsuario.setLayout( new GridLayout( 5, 2, 1, 1 ) );

	        
	        cargar_jugadores = new JButton( "Cargar archivo de los jugadores" );
	        cargar_jugadores.setActionCommand( "cargar_jugadores" );
	        cargar_jugadores.addActionListener( this );
	        cargar_jugadores.setPreferredSize( new Dimension( 2, 2 ) );
	        panelUsuario.add( cargar_jugadores );
	        add(panelUsuario);
	        
	        cargar_jornadas = new JButton( "Cargar archivo de las jornadas" );
	        cargar_jornadas.setActionCommand( "cargar_jornadas" );
	        cargar_jornadas.addActionListener( this );
	        cargar_jornadas.setPreferredSize( new Dimension( 2, 2 ) );
	        panelUsuario.add( cargar_jornadas );
	        add(panelUsuario);
	        
	        mostrar_jugadores = new JButton( "Mostrar catalogo de los jugadores" );
	        mostrar_jugadores.setActionCommand( "mostrar_jugadores" );
	        mostrar_jugadores.addActionListener( this );
	        mostrar_jugadores.setPreferredSize( new Dimension( 2, 2 ) );
	        panelUsuario.add( mostrar_jugadores );
	        add(panelUsuario);
	        
	        crear_equipo = new JButton( "Crear equipo de Fantasia" );
	        crear_equipo.setActionCommand( "crear_equipo" );
	        crear_equipo.addActionListener( this );
	        crear_equipo.setPreferredSize( new Dimension( 2, 2 ) );
	        panelUsuario.add( crear_equipo );
	        add(panelUsuario);
	        
	        acceder_equipo = new JButton( "Acceder a un equipo de Fantasia" );
	        acceder_equipo.setActionCommand( "acceder_equipo" );
	        acceder_equipo.addActionListener( this );
	        acceder_equipo.setPreferredSize( new Dimension( 2, 2 ) );
	        panelUsuario.add( acceder_equipo );
	        add(panelUsuario);
	        
	        modificar_alineacion = new JButton( "Modificar alineacion de un equipo de fantasia" );
	        modificar_alineacion.setActionCommand( "modificar_alineacion" );
	        modificar_alineacion.addActionListener( this );
	        modificar_alineacion.setPreferredSize( new Dimension( 2, 2 ) );
	        panelUsuario.add( modificar_alineacion );
	        add(panelUsuario);
	        
	        transferencias = new JButton( "Realizar transferencias" );
	        transferencias.setActionCommand( "transferencias" );
	        transferencias.addActionListener( this );
	        transferencias.setPreferredSize( new Dimension( 2, 2 ) );
	        panelUsuario.add( transferencias );
	        add(panelUsuario);
	        
	        consultar_liga = new JButton( "Consultar el estado de la liga de fantasia" );
	        consultar_liga.setActionCommand( "consultar_liga" );
	        consultar_liga.addActionListener( this );
	        consultar_liga.setPreferredSize( new Dimension( 2, 2 ) );
	        panelUsuario.add( consultar_liga );
	        add(panelUsuario);
	        
	        consultar_jornada = new JButton( "Consultar reslutados de una jornada" );
	        consultar_jornada.setActionCommand( "consultar_jornada" );
	        consultar_jornada.addActionListener( this );
	        consultar_jornada.setPreferredSize( new Dimension( 2, 2 ) );
	        panelUsuario.add( consultar_jornada );
	        add(panelUsuario);
	        
	        consultar_jugador = new JButton( "Consultar informacion de un jugador" );
	        consultar_jugador.setActionCommand( "consultar_jugador" );
	        consultar_jugador.addActionListener( this );
	        consultar_jugador.setPreferredSize( new Dimension( 2, 2 ) );
	        panelUsuario.add( consultar_jugador );
	        add(panelUsuario);
	        
	        salir = new JButton( "Salir de la aplicacion" );
	        salir.setActionCommand( "salir" );
	        salir.addActionListener( this );
	        salir.setPreferredSize( new Dimension( 2, 2 ) );
	        panelUsuario.add( salir );
	        add(panelUsuario);

	    }
	 
	 @Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		 String comando = e.getActionCommand( );
		 if( comando.equals("cargar_jugadores") )
	        {
	            fantasy.cargarJugadores();
	        }
		 if( comando.equals("cargar_jornadas") )
	        {
	            fantasy.cargarJornada();
	        }
		 if( comando.equals("mostrar_jugadores") )
	        {
	            fantasy.mostrarJugadores();
	        }
		 if( comando.equals("crear_equipo") )
	        {
	            fantasy.crearequipo();
	        }
		 if( comando.equals("acceder_equipo") )
	        {
	            fantasy.accederequipo();
	        }
		 if( comando.equals("modificar_alineacion") )
	        {
	            fantasy.modificaralineacion();
	        }
		 if( comando.equals("salir") )
	        {
			 	remove(panelUsuario);
			 	dispose();
	            fantasy.salir();
	        }
		 
		}
	
	 
	    
}