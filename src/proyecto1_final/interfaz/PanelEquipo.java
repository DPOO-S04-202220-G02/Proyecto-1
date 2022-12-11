package proyecto1_final.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import proyecto1_final.objetos.DatosFantasy;
import proyecto1_final.interfaz.AgregarJugadorEquipo;
import proyecto1_final.modelo.Equipo_Fantasia;

public class PanelEquipo extends JFrame implements ActionListener
{

	private JPanel panelEquipo;
	
	private JLabel CreaTuEquipo;
	
	private JTextField NombreEquipo;
	
	private JButton AgregarJugador;
	
	private JScrollPane ScrollJugadores;
	
	private AgregarJugadorEquipo dAgregarJugadorEquipo;
	
	private DatosFantasy datosFantasy;
	
	private JList ListaJugadoresEquipo;
	
	private ArrayList jugadoresAgregados = new ArrayList();
		
	
	
	public PanelEquipo(DatosFantasy datos)
    {
		datosFantasy = datos;
		datosFantasy.equipoNuevo = new Equipo_Fantasia("", true);
		panelEquipo = new JPanel( );
		setTitle( "Crear Equipo" );
	    setSize( 550, 700 );
	    setDefaultCloseOperation( JDialog.DISPOSE_ON_CLOSE );
	   
	    panelEquipo.setBorder( new CompoundBorder( new TitledBorder( "Crea tu equipo" ), new EmptyBorder( 3, 3, 3, 3 ) ) );
	    panelEquipo.setLayout( new GridLayout( 2, 2, 1, 1 ) );
	  
	    JLabel NombreDelEquipo = new JLabel( "Nombre de tu Equipo" );
	    panelEquipo.add( NombreDelEquipo );
	    
	    NombreEquipo = new JTextField(  "" );
	    NombreEquipo.setEditable( true );
	    panelEquipo.add( NombreEquipo );
	    
	    AgregarJugador = new JButton( "AgregarJugador" );
	    AgregarJugador.setActionCommand( "AgregarJugador" );
	    AgregarJugador.addActionListener( this );
	    AgregarJugador.setPreferredSize( new Dimension( 5, 5 ) );
	    panelEquipo.add( AgregarJugador );
	    

        ListaJugadoresEquipo = new JList( );
        ListaJugadoresEquipo.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
    

	    ScrollJugadores = new JScrollPane(ListaJugadoresEquipo );
	    ScrollJugadores.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );
	    ScrollJugadores.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED );
	    ScrollJugadores.setBorder( new CompoundBorder( new EmptyBorder( 3, 3, 10, 3 ), new LineBorder( Color.BLACK, 1 ) ) );

        panelEquipo.add( ListaJugadoresEquipo );
        add(panelEquipo);
        
    }





	public void registrarJugador( )
    {
		dAgregarJugadorEquipo = new AgregarJugadorEquipo(this, datosFantasy);
		dAgregarJugadorEquipo.setVisible( true );
    }
	
	public void agregarJugador(String jugador)
	{
		jugadoresAgregados.add(jugador);
		ListaJugadoresEquipo.setListData( jugadoresAgregados.toArray());
		if ((ListaJugadoresEquipo.getModel().getSize()) == 15) {
			
			JLabel equipoCompleto = new JLabel( "Has completado tu equipo" );
			panelEquipo.add( equipoCompleto );
	        add(panelEquipo);
			
		}
		
		
	}
 @Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	 registrarJugador();
	}
	
	public void MostrarScroll() {
		panelEquipo.setVisible(true);
		
	}
	
	
}