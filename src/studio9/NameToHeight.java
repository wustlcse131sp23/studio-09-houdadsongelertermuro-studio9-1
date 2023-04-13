package studio9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import support.cse131.NotYetImplementedException;

public class NameToHeight {
	/**
	 * Construct and fill a map with your studio group members' names, each
	 * associated with his or her height.
	 * 
	 * Construct an ArgsProcessor and loop asking the args processor for a name to
	 * lookup the height. When the user cancels (that is: when args processor
	 * returns null), break from the loop. Otherwise, loop up the name in the map
	 * and output the results. Be sure to handle the case where the map does not
	 * contain a specified name.
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		Map<String, Integer> height = new HashMap<>();
		
		height.put("Will", 65);
		height.put("Matthew", 75);
		height.put("Adaora", 63);
		height.put("Jared", 69);

		System.out.println("What is the name?");
		String name = in.next();
		
		System.out.println(height.get(name));

		System.out.println("quit?");
		String quit = in.next();
		
		while (!quit.equals("quit")) {
			System.out.println("What is the name?");
			name = in.next();
			
			System.out.println(height.get(name));
			System.out.println("quit?");
			quit = in.next();
		}

	}
}
