package mocking.examples;

import java.util.List;
import java.util.LinkedList;
import java.util.Stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class TestMocking {
	
	
	
	@Test
	public void testSpy(){
		
		List<String> list = new LinkedList<String>(); //a real linkedList
		
		List<String> listspy = spy(list); // a mocked list spying on real one
		
		//stub size
		when(listspy.size()).thenReturn(100);
		
		listspy.add("first");
		
		assertEquals(listspy.get(0), "first");
		assertEquals(listspy.size(), 100);
		
	}
	
	
	@Test
	public void testStack(){
	
		//making a mocked stack
		 Stack stack = mock(Stack.class);
		 
		 //stub mocked.pop with 1 2 3	 
		 when(stack.pop()).thenReturn("3","2","1","null");
		 
		 assertEquals("3", stack.pop());
		 verify(stack).pop();
		 
		 
		 
	}
	
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
