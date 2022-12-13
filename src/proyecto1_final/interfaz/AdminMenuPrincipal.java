package proyecto1_final.interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.*;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;


public class AdminMenuPrincipal extends JFrame implements ActionListener
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
	
	 public AdminMenuPrincipal(InterfazFantasy interfazFantasy)
	    {
		 	fantasy = interfazFantasy;
	        setTitle( "Menu Principal Administrador" );
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
	        
	        mostrar_jugadores = new JButton( "Estadísticas y gráficas" );
	        mostrar_jugadores.setActionCommand( "mostrar_jugadores" );
	        mostrar_jugadores.addActionListener( this );
	        mostrar_jugadores.setPreferredSize( new Dimension( 2, 2 ) );
	        panelUsuario.add( mostrar_jugadores );
	        add(panelUsuario);
	        
	        mostrar_jugadores = new JButton( "Regresar a Registro" );
	        mostrar_jugadores.setActionCommand( "regresar" );
	        mostrar_jugadores.addActionListener( this );
	        mostrar_jugadores.setPreferredSize( new Dimension( 2, 2 ) );
	        panelUsuario.add( mostrar_jugadores );
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
		 
		 if( comando.equals("regresar") )
	        {
			 remove(panelUsuario);
	        dispose();
			 InterfazFantasy Fantasy = new InterfazFantasy();
			 Fantasy.setVisible(true);
	        }
	
		 if( comando.equals("salir") )
	        {
			 	remove(panelUsuario);
			 	dispose();
	            fantasy.salir();
	        }
		 
		}
	
	 
	    
}