import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class CheckLicensePlate {

	public static  Set<String> dataBaseLicensePlate(Set<String>availablePlate){
		availablePlate.add("BH-20-AAC");
		availablePlate.add("CJ-01-AAA");
		availablePlate.add("CJ-02-AAA");
		availablePlate.add("CJ-11-ABA");
		availablePlate.add("CJ-12-ABC");
		availablePlate.add("CJ-13-ABC");
		availablePlate.add("MM-01-ABC");
		availablePlate.add("MM-01-AAA");
		availablePlate.add("CJ-15-ABC");
		availablePlate.add("CJ-10-ABC");
		availablePlate.add("CJ-10-BBB");
		availablePlate.add("BH-10-AAC");
		return availablePlate;
		}
	public static void checkAvailablePlate() {
		String plate = null,user = null,userAnswer=null,aux=null;
		int counter=0;
		Scanner s,scan=new Scanner(System.in); 
		Set<String> checkMyPlate = new HashSet<String>();
		Collection<String> keepFirstTwoLetterSet = new ArrayList<>();
		System.out.println("Search for an available license plate:");
		Scanner scanner = new Scanner(System.in);
		user=scanner.next();
		user = user.toUpperCase();
		dataBaseLicensePlate(checkMyPlate);
		Iterator<String> it = checkMyPlate.iterator();	
		while(it.hasNext()) {
			plate = it.next();
			
			if (Objects.equals(plate, user)) {
				counter++;
				 System.out.println("The license plate is available.");
				 aux=plate;
			}
			else if (plate.indexOf(user) != -1) {
				System.out.print(plate);
				System.out.print(" ; ");
				aux=plate;
				counter++;	
			} 
		}
		while (counter== 0) {
			System.out.println("The licence plate is NOT available.Try another one? (y/n)");
			userAnswer=scanner.next();	
					if (userAnswer.indexOf("y") != -1) {
						checkAvailablePlate();
						System.exit(counter);
					}else {
							System.out.println("Thank you, good bye.");
							System.exit(counter);
						}
					}
		if (counter != 1) {
			System.out.println("Choose one from above: ");
			checkAvailablePlate();
		}
		if (counter==1) {
			System.out.println("Do you want to reserve it for your car? (y/n)");
			userAnswer=scanner.next();	
			if (userAnswer.indexOf("y") != -1) {
				System.out.println("The license plate "+aux+" is yours!");
				checkMyPlate.remove(aux);
				System.out.println(checkMyPlate);
				System.out.print("The total number of available license plates is now: "+ checkMyPlate.size()+" from which every county has: ");
			Iterator<String> it2 =checkMyPlate.iterator();
				while (it2.hasNext()) {
				String test= it2.next();
				String mai = test.substring(0,2);
			
				keepFirstTwoLetterSet.add(mai);
				}
			 Set<String> uniqueSet = new HashSet<String>(keepFirstTwoLetterSet);  
			  for (String i : uniqueSet) {  
		             System.out.print(i + ": " + Collections.frequency(keepFirstTwoLetterSet, i)); 
		             System.out.print("; ");
			  }  
			} else {
				System.out.println("Ok, good bye!");
				System.exit(counter);
			}
		}
	}
}

