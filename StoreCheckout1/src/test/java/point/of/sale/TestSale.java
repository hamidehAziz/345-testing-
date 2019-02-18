package point.of.sale;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;

import point.of.sale.Display;
import point.of.sale.HashStorage;
import point.of.sale.Sale;

import static org.mockito.Mockito.*;

public class TestSale {
	
		
	@Before
	public void setUp() throws Exception{
		
	}

	@Test
	public void testScan() {
		
		Display display = mock(Display.class);
		HashStorage hashStorage = mock(HashStorage.class);		
		when(hashStorage.barcode("A1")).thenReturn("Milk, 3.99");
		

		//Set it up for barcode(String barcode)
		ArgumentCaptor<String> argCaptor = ArgumentCaptor.forClass(String.class);
		
		Sale sale = new Sale(display, hashStorage);		
		sale.scan("A1");
		
		
		InOrder inOrder = inOrder(display, hashStorage);			
		
		//Capture what was passed to barcode
		inOrder.verify(hashStorage).barcode(argCaptor.capture());
		
		//Use that arg value later to verify what was displayed
		inOrder.verify(display).showLine(argCaptor.getValue());
		
		inOrder.verify(display).showLine("Milk, 3.99");
		
		
	}
	
	
	@Test
	public void testFun() {
		
		HashStorage hashStorage = mock(HashStorage.class);
		
		when(hashStorage.barcode("select *")).thenReturn("peter");
		when(hashStorage.barcode("A1")).thenReturn("Milk, 3.99");
		
		System.out.print(hashStorage.barcode("Milk, 3.99"));
		
		hashStorage.put("A1","Milk, 3.99");
		verify(hashStorage).put("A1", "Milk, 3.99");
		
	}

}
