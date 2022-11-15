package proyecto1_final.objetos;

public class Usuario {

	    // -----------------------------------------------------------------
	    // Atributos
	    // -----------------------------------------------------------------

	    /**
	     * Cédula del pasajero.
	     */
	    private String cedula;

	    /**
	     * Nombre del pasajero.
	     */
	    private String nombre;

	    // -----------------------------------------------------------------
	    // Constructores
	    // -----------------------------------------------------------------

	    /**
	     * Crea un pasajero con su cédula y nombre. <br>
	     * <b>post: </b> El pasajero tiene sus datos básicos cédula y nombre asignados.
	     * @param pCedula Cédula del pasajero. pCedula > 0.
	     * @param pNombre Nombre del pasajero. pNombre != null && pNombre != "".
	     */
	    public Usuario( String pCedula, String pNombre )
	    {
	        cedula = pCedula;
	        nombre = pNombre;
	    }
	
	
	
}
