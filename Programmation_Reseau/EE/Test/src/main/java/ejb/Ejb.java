package ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class Ejb
 */
@Stateless
@LocalBean
public class Ejb {

    /**
     * Default constructor. 
     */
    public Ejb() {
        // TODO Auto-generated constructor stub
    }
    
    public String message() {
    	String p = "pr�parez-vous pour la bagarre...";
    	return p;
    }

}
