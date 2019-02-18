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
		
		ArgumentCaptor<String> argCaptor = ArgumentCaptor.forClass(String.class);
		
		Sale sale = new Sale(display, hashStorage);		
		sale.scan("A1");
		
		
		InOrder inOrder = inOrder(display, hashStorage);			
		
		inOrder.verify(hashStorage).barcode(argCaptor.capture());
		
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
