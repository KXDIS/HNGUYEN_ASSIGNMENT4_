import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

class PropertyTestStudent {

	Property p;
	
	
	
	@Before
	void setUp() throws Exception {
		p = new Property("Hendrick","Nguyen",1234.00, "Steven");
	}

	@After
	void tearDown() throws Exception {
		p = null;
	}

	   @Test
	    public void testGetPropertyName() {
	        assertEquals("Hendrick", p.getPropertyName());
	    }
	   
	   @Test
	    public void testGetOwner() {
	        assertEquals("Steven", p.getOwner());
	    }
	   @Test
	    public void testGetCity() {
	        assertEquals("Germantown", p.getCity());
	    }
}
