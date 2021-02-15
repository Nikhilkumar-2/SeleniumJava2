package testng;

import java.util.ArrayList;

import org.testng.annotations.Test;

public class sreamss {
  @Test
  public void f() {
	  ArrayList<String> names = new ArrayList<String>();
	  names.add("Anil");
	  names.add("Badri");
	  names.add("Ansha");
	  names.add("Alekhya");
	  names.add("Ram");
	  int count = 0;
	  for(int i = 0; i<names.size();i++)
	  {
		  String actual = names.get(i);
		  if(actual.startsWith("A"))
			  count++;
	  }
	  System.out.println(count);
  }
  }

