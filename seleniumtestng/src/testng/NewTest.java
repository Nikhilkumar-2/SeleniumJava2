package testng;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTest {
	// @Test
	public void f() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Anil");
		names.add("Badri");
		names.add("Ansha");
		names.add("Alekhya");
		names.add("Ram");
		int count = 0;
		for (int i = 0; i < names.size(); i++) {
			String actual = names.get(i);
			if (actual.startsWith("A"))
				count++;
		}
		System.out.println(count);
	}

	// @Test
	public void streamFilter() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Don");
		names.add("Alekhya");
		names.add("Adam");
		names.add("Ram");
		// there is no life for intermediate operation if there is no terminal operation
		// terminal operation will execute only if intermediate (filter) operation
		// returns true
		// we can create stream by importing stream package
		// how to use filter in stream API

		Long c = names.stream().filter(s -> s.startsWith("A")).count();
		System.out.println(c);

		Long d = Stream.of("Abhijeet", "Don", "Alekhya", "Adam", "Ram").filter(s -> {
			s.startsWith("A");
			return true;
		}).count();
		System.out.println(d);
		// print all the names of the array list
		// names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		names.stream().filter(s -> s.length() > 4).limit(1).forEach(s -> System.out.println(s));
	}

	//@Test
	public void streamMap() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("man");
		names.add("Don");
		names.add("women");
		
		
		/*
		 * // print names which have last letter as "a" with uppercase
		 * Stream.of("Abhijeet", "Don", "Alekhya", "Adam", "Rama").filter(s ->
		 * s.endsWith("a")).map(s -> s.toUpperCase()) .forEach(s ->
		 * System.out.println(s)); // print all the names with uppercase
		 * Stream.of("Abhijeet", "Don", "Alekhya", "Adam", "Rama").map(s ->
		 * s.toUpperCase()) .forEach(s -> System.out.println(s)); // print names which
		 * have first letter as a with uppercase and sorted
		 */	
		List<String> names1 = Arrays.asList("Azbhijeet", "Don", "Alekhya", "Adam", "Rama");
		//names1.stream().filter(s->s.startsWith("A")).sorted()
			//.map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		// Merging two different lists
		Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
		//newStream.sorted().forEach(s->System.out.println(s));
		boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("Adam"));
		System.out.println(flag);
		Assert.assertTrue(flag);	
	}
	@Test
	public void streamCollect()
	{
	// collect method will give u a list after applied modifications on it, below both examples are same 	
		List<String> ls = Stream.of("Abhijeet", "Don", "Alekhya", "Adam", "Rama").filter(s->s.endsWith("a"))
			.map(s->s.toUpperCase()).collect(Collectors.toList());
		System.out.println(ls.get(0));
		
		Stream.of("Abhijeet", "Don", "Alekhya", "Adam", "Rama").filter(s->s.endsWith("a"))
		.map(s->s.toUpperCase()).limit(1).forEach(s->System.out.println(s));;
		
		// print unique number from this array and then sort it
		
		List<Integer> values = Arrays.asList(3,2,2,7,5,1,9,7);
		//values.stream().distinct().sorted().forEach(s->System.out.println(s));
		List<Integer> li =values.stream().distinct().sorted().collect(Collectors.toList());	
		System.out.println(li.get(2));
		
	}
}
