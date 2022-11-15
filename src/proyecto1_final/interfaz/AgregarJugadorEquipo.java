package proyecto1_final.interfaz;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import proyecto1_final.objetos.DatosFantasy;


public class AgregarJugadorEquipo extends JDialog implements ActionListener
{

    /**
     * Opción Aceptar.
     */
    public final static String ACEPTAR = "ACEPTAR";

    /**
     * Opción Cancelar.
     */
    public final static String CANCELAR = "CANCELAR";

    /**
     * Opción para la clase ejecutiva.
     */

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------
    private JPanel panelAnadirJugador;
    
    private JLabel IngreseNombre;
    private JLabel error;
    
    /**
     * Botón aceptar.
     */
    private JButton botonAceptar;

    /**
     * Botón cancelar.
     */
    private JButton botonCancelar;

    /**
     * Texto de ingreso de cédula.
     */
    private JTextField txtNombre;
    
    private DatosFantasy datosFantasy;
   
    private PanelEquipo panelEquipoCreado;
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el formulario de asignación de pasajeros.
     * @param pPrincipal Ventana o frame padre del diálogo. pPrincipal != null.
     * @param pAvion Avión sobre el que se hará la asignación. pAvion != null.
     */
    public AgregarJugadorEquipo(PanelEquipo panelEquipo, DatosFantasy datos)
    {
    	panelEquipoCreado = panelEquipo;
    	datosFantasy = datos;
        setTitle( "Registro de Jugador" );
        setSize( 300, 230 );
        setDefaultCloseOperation( JDialog.DISPOSE_ON_CLOSE );

        panelAnadirJugador = new JPanel( );
        
        panelAnadirJugador.setBorder( new CompoundBorder( new TitledBorder( "Agrega un jugador" ), new EmptyBorder( 3, 3, 3, 3 ) ) );
        panelAnadirJugador.setLayout( new GridLayout( 5, 2, 1, 1 ) );
        
        IngreseNombre = new JLabel( "Ingrese el nombre de un jugador " );
        panelAnadirJugador.add( IngreseNombre );

        txtNombre = new JTextField(  "" );
        txtNombre.setEditable( true );
        panelAnadirJugador.add( txtNombre );
        
        botonAceptar = new JButton( "Aceptar" );
        botonAceptar.setActionCommand( "Aceptar" );
        botonAceptar.addActionListener( this );
        botonAceptar.setPreferredSize( new Dimension( 2, 2 ) );
        panelAnadirJugador.add( botonAceptar );
        
        botonCancelar = new JButton( "Cancelar" );
        botonCancelar.setActionCommand( "Cancelar" );
        botonCancelar.addActionListener( this );
        botonCancelar.setPreferredSize( new Dimension( 2, 2 ) );
        panelAnadirJugador.add( botonCancelar );
        
        error = new JLabel( "valida" );
        panelAnadirJugador.add( error );
        add(panelAnadirJugador);
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Procesa el registro de un pasajero. Recoge los datos del pasajero y de la clase y ubicación en la que desea su silla y procesa su registro. <br>
     * <b>post: </b> Si el pasajero no está registrado y hay silla con las características solicitadas se asigna el pasajero a una silla del avión. <br>
     * Si el registro no se puede hacer correctamente, muestra un mensaje.
     
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );

        if( comando.equals( "Aceptar" ) )
        {
        	if(datosFantasy.AgregarJugador(txtNombre.getText()))
    		{
        		remove(panelAnadirJugador);
        		dispose();
        		panelEquipoCreado.agregarJugador(txtNombre.getText());
    		}
        	else
        	{
        		panelAnadirJugador.remove(error);
        		error = new JLabel( "El jugador no existe o ya esta en su equipo" );
                panelAnadirJugador.add( error );
                add(panelAnadirJugador);
        	}
        }
        else if( comando.equals( CANCELAR ) )
        {
           
        }
    
    }
}