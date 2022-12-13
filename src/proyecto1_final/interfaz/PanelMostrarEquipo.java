package proyecto1_final.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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


public class PanelMostrarEquipo extends JFrame implements ActionListener
{

	private JPanel panelUsuario;
	
	private JScrollPane scroll;
	
	private JList listaEspacios;
	
	private JTextField txtNombre;
	
	private JLabel IngreseNombre;
	
	private JButton botonBuscar;
	
	
	
	
	
	public PanelMostrarEquipo(DatosFantasy datosFantasy , String nombre)
    {
		 panelUsuario = new JPanel( );
		 setTitle( "Mostrar Equipo" );
	     setSize( 480, 600 );
	     setDefaultCloseOperation( JDialog.DISPOSE_ON_CLOSE );
	     panelUsuario.setLayout( new GridLayout( 2, 1, 1, 1 ) );
	     
	     IngreseNombre = new JLabel( "Bienvenido a " + nombre );
	     panelUsuario.add( IngreseNombre );
	     
	     
	     listaEspacios = new JList( );
	     listaEspacios.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
	     listaEspacios.setListData( datosFantasy.accederEquipoFantasia(nombre).toArray());
	       

        scroll = new JScrollPane( listaEspacios );
        scroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );
        scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        scroll.setBorder( new CompoundBorder( new EmptyBorder( 0, 0, 0, 0 ), new LineBorder( Color.BLACK, 1 ) ) );
        
        panelUsuario.add( scroll );
        
        
        //botonBuscar = new JButton( "Buscar" );
	     //botonBuscar.setActionCommand( "Aceptar" );
	    // botonBuscar.addActionListener( this );
	     //botonBuscar.setPreferredSize( new Dimension( 1, 1 ) );
	     //panelUsuario.add( botonBuscar );
	     
        add(panelUsuario);
        
        //add( scroll, BorderLayout.CENTER );
        //add( panelUsuario, BorderLayout.SOUTH );
      
        
    }



	public JList actualizarLista(DatosFantasy datosFantasy, String nombre) {
		
		listaEspacios = new JList( );
        listaEspacios.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        listaEspacios.setListData( datosFantasy.accederEquipoFantasia(nombre).toArray());
        
        return listaEspacios;
	}

	@Override
	 public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand();

        if( comando.equals( "Aceptar" ) )
        {
        	//actualizarLista();
        }
        
    
    }
	
	public void MostrarScroll() {
		panelUsuario.setVisible(true);
		
	}
	
	
	
	
	
	
	
}