package proyecto1_final.interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.*;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import proyecto1_final.objetos.DatosFantasy;
import proyecto1_final.interfaz.PanelJugadores;
import proyecto1_final.interfaz.AgregarJugadorEquipo;



public class InterfazFantasy extends JFrame implements ActionListener
{
	private JTextField txtCedula;
	
	private JTextField txtContraseña;
	
	private JButton registrar;

	private MenuPrincipal dMenu;
	
	private static DatosFantasy datosFantasy;
	
	private  JPanel panelUsuario;
	
	
	 public InterfazFantasy( )
	    {
		 	datosFantasy = new DatosFantasy();
	        setTitle( "Liga de Fantasia" );
	        setSize( 580, 700 );
	        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	        
	        panelUsuario = new JPanel( );

	        panelUsuario.setBorder( new CompoundBorder( new TitledBorder( "Registro del Usuario" ), new EmptyBorder( 3, 3, 3, 3 ) ) );
	        panelUsuario.setLayout( new GridLayout( 5, 2, 1, 1 ) );

	        // Cédula
	        JLabel nombreUsuario = new JLabel( "Nombre de usuario: " );
	        panelUsuario.add( nombreUsuario );

	        txtCedula = new JTextField(  "" );
	        txtCedula.setEditable( true );
	        panelUsuario.add( txtCedula );
	        
	        JLabel contraseña = new JLabel( "Contraseña: " );
	        panelUsuario.add( contraseña );
	        txtContraseña = new JTextField(  "" );
	        txtContraseña.setEditable( true );
	        panelUsuario.add( txtContraseña );
	        
	        registrar = new JButton( "Registrar" );
	        registrar.setActionCommand( "Registrar" );
	        registrar.addActionListener( this );
	        registrar.setPreferredSize( new Dimension( 2, 2 ) );
	        panelUsuario.add( registrar );
	        add(panelUsuario);

	    }
	 
	 public void registrarUsuario( )
	    {
		 	dMenu = new MenuPrincipal( this );
		 	dMenu.setVisible( true );
	    }
	 
	 @Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		 	registrarUsuario();
		}
	 
	 public void cargarJugadores()
	 {
		 datosFantasy.ejecutarCargarJugadores();
		 
	 }
	 
	 public void cargarJornada()
	 {
		 datosFantasy.ejecutarCargarResultadosPartido();
	 }
	 
	 public void mostrarJugadores()
	 {
		 datosFantasy.ejecutarAccederListaJugadores();
		 PanelJugadores Jugadores = new PanelJugadores(datosFantasy);
		 Jugadores.setVisible(true);
		 
	 }
	 public void crearequipo()
	 {
		 PanelEquipo Equipo = new PanelEquipo(datosFantasy);
		 Equipo.setVisible(true);
	 }
	 public void accederequipo()
	 {
		 datosFantasy.ejecutarInformacionEquipoFantasia();
	 }
	 public void modificaralineacion()
	 {
		 datosFantasy.ejecutarModificarAlineacionEquipo();
	 }
	 public void salir()
	 {
		 remove( panelUsuario );
		 dispose( );
	 }
	 
	 
	 	
	 
	  public static void main( String[] pArgs )
	    {
	        try
	        {
	        	datosFantasy = new DatosFantasy();
	            // Unifica la interfaz para Mac y para Windows.
	            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );

	            InterfazFantasy interfaz = new InterfazFantasy( );
	            interfaz.setVisible( true );
	        }
	        catch( Exception e )
	        {
	            e.printStackTrace( );
	        }
	    }
}
