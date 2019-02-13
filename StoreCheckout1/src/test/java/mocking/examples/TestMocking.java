package mocking.examples;

import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class TestMocking {
	
	@Test
	public void test(){
		
		List<String> list = mock(List.class);
		
		when(list.get(0)).thenReturn("one");
		
		list.get(0);
		list.add("one");
		
		verify(list).get(0);
		verify(list).add("one");
		
		assertEquals("one",list.get(0));
		
		
	}

}
