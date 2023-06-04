package examples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGDataProvider {
	
	@Test(dataProvider = "dp1")
	public void testMethod(String[] all) throws Exception{
		System.out.println(all[0]);
	}
	
	
	
	@DataProvider
	public Iterator<String[]> dp1() {
		
		  List<String[]> al = new ArrayList<String[]>();
		  
		  al.add(new String[] {"Baba", "Maa"});
		  al.add(new String[] {"Soumi", "Subh"});
		  
		  System.out.println(al);
		  
		  return al.iterator();
		  
	}
	
	

}
