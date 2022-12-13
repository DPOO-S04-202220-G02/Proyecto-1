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
	
	
	
	
	
	public PanelMostrarEquipo(DatosFantasy datosFantasy, InterfazFantasy fantasy)
    {
		panelUsuario = new JPanel( );
		 setTitle( "Jugadores" );
	     setSize( 580, 700 );
	     setDefaultCloseOperation( JDialog.DISPOSE_ON_CLOSE );
	     
	     

        listaEspacios = new JList( );
        listaEspacios.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
        listaEspacios.setListData( datosFantasy.ejecutarAccederListaJugadores().toArray());
    

        scroll = new JScrollPane( listaEspacios );
        scroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );
        scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        scroll.setBorder( new CompoundBorder( new EmptyBorder( 3, 3, 3, 3 ), new LineBorder( Color.BLACK, 1 ) ) );

        add( scroll, BorderLayout.CENTER );
        JPanel panelUsuario = new JPanel();
        panelUsuario.setLayout( new GridLayout(1, 2 ));
        
        add( panelUsuario, BorderLayout.SOUTH );
      
        
    }





	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void MostrarScroll() {
		panelUsuario.setVisible(true);
		
	}
	
	
	
	
	
	
	
}