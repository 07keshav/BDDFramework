package DemoJava;

import org.testng.annotations.Test;

public class CheckEmptyorNull {
	int [] arr ;
	@Test
	public void checkNullorEmpty() {
	
	try {
		if(arr.length==0)
		
		{
			System.out.println("Empty Array");
		}
	}catch(NullPointerException e )
	{
		System.out.println("Array not initialized pointing to null");
	}

}
}
