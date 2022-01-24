package ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class bean
 */
@Stateless
@LocalBean



public class bean {
	private String msg;
    /**
     * Default constructor. 
     */
    public bean() {
        // TODO Auto-generated constructor stub
    }
    
    public String message() {
    	msg = "salut c'est EJB";
    	return msg;
    	
    	
    }
}
