package point.of.sale;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;


public class TestSale {
	
		
	@Before
	public void setUp() throws Exception{
		
	}

	@Test
	public void testScan() {
		
		Display display = mock(Display.class);
		
		Sale sale = new Sale(display);
		
		sale.scan("A1");
		verify(display).showLine("Milk , 3.99");
	}

}
