//Description: The police wants to keep evidence of  all the registration numbers that are available for a county.
//The registration numbers consist of 2 letters, which represent the county, 2 digits and 3 letters.
// The user can ask for a license plate, containing just a part or the full name. (AAA, 01, CJ or CJ-01-AAA)
// The user can also give up his license plate, and so that license plate becomes available for another to take it
// The purpose is to work with the Set collection from Java and use add, iterator, count, remove functions.

import java.util.*;
public class StateLicensePlateRegister extends CheckLicensePlate{
	public static void main(String[] args) {
		String plate = null,user = null,userAnswer=null ;
		int counter=0;
		int menuOption = 0;
		Scanner scanner,scan = new Scanner(System.in);
		Scanner s = new Scanner(System.in);
		Set<String> checkMyPlate = new HashSet<String>();
		Collection<String> keepFirstTwoLetterSet = new ArrayList<>();
		System.out.println("Please choose one of the options below.");
		System.out.println("1. I want to give up my old license plate;");
		System.out.println("2. I need a new license plate;");
		System.out.print("Press 1 or 2: ");
		menuOption=s.nextInt();
		if (menuOption==1) {
			dataBaseLicensePlate(checkMyPlate);
			System.out.println("Please enter the licence plate you want to dispose: ");
			userAnswer = scan.next();
			userAnswer = userAnswer.toUpperCase();
			checkMyPlate.add(userAnswer);
			System.out.println("Great! The license plate is now available to be taken again. ");
			System.out.println(checkMyPlate);
			System.out.println("The total number of available license plates is now: "+ checkMyPlate.size()+" from which every county has: ");
			Iterator<String> it2 =checkMyPlate.iterator();
			while 	(it2.hasNext()) 
					{
					String test= it2.next();
					String mai = test.substring(0,2);
					keepFirstTwoLetterSet.add(mai);
					}
					 Set<String> uniqueSet = new HashSet<String>(keepFirstTwoLetterSet);  
					 for (String i : uniqueSet) 
					 {  
				             System.out.print(i + ": " + Collections.frequency(keepFirstTwoLetterSet, i)); 
				             System.out.print("; ");
				     }  
		}else if (menuOption==2) checkAvailablePlate();
		 else System.out.println("Next time, press 1 or 2!");
	}
}
