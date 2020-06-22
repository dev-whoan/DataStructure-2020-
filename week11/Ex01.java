package week11;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class Ex01 {
	public static void main(String[] args) {
		Dictionary dictionary = new Hashtable();
		System.out.println("201611253 ±ËπŒ»Ø");
		
		//put method
		dictionary.put("Apple", "A fruit");
		dictionary.put("Ball", "A round shaped toy");
		dictionary.put("Car", "A four wheeler vehicle designed to accomodate usually four people");
		dictionary.put("Dog",  "An animal with four legs and one tail");
		
		//get method
		System.out.println("\nApple: " + dictionary.get("Apple"));
		System.out.println("Ball: " + dictionary.get("Ball"));
		System.out.println("Dog: " + dictionary.get("Dog"));
		System.out.println("Elephant: " + dictionary.get("Elephant"));
		System.out.println();
		
		//elements method
		for(Enumeration i = dictionary.elements(); i.hasMoreElements();) {
			System.out.println("Values contained in Dictinoary : " + i.nextElement());
		}
		
		//keys method:
		for(Enumeration k = dictionary.keys(); k.hasMoreElements();) {
			System.out.println("Keys conatained in Dictinoary : " + k.nextElement());
		}
		
		//isEmpty method
		System.out.println("\nThe dictionary is empty? " + dictionary.isEmpty());
		//remove method
		dictionary.remove("Dog");
		//Checking if the value is removed or not
		System.out.println("\nDog: " + dictionary.get("Dog"));
		//size method
		System.out.println("\nSize of Dictionary: " + dictionary.size());
	}
}
