package point.of.sale;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import point.of.sale.*;

public class TestSale {
	
		
	@Before
	public void setUp() throws Exception{
		
	}

	@Test
	public void testScan() {
		
		Display display = new FakeDisplay();
		
		Sale sale = new Sale(display);
		
		sale.Scan("A1");
	}

}
