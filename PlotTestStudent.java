import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;

import org.junit.jupiter.api.Test;

class PlotTestStudent {

	private Plot p1, p2, p3;
	
	@Before
	 public void setUp() throws Exception {
	        p1 = new Plot(3, 4, 2, 2);
	        p2 = new Plot(4, 5, 1, 1);
	        p3 = new Plot(0,0, 10, 10);
	    }
	

	@After
	void tearDown() throws Exception {
		  p1 = p2 = null;
	}
	
	   @Test
	    public void testOverlaps() {
	        assertTrue(p1.overlaps(p2));
	    }
	   
	   @Test
	    public void testEncompasses() {
	        assertTrue(p3.encompasses(p1));
	    }


}
