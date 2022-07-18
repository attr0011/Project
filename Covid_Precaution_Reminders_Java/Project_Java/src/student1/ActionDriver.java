package student1;

/*
 * Testing the action and regular class  
 * compare RegularAction’s superclass with the Action class itself.
 */
public class ActionDriver {
	//main class start 
	public static void main(String[] args) {
		
		
		System.out.println("Sample Output For assignment 1");
    	System.out.println("");
    	System.out.println("part 1");
    	System.out.println("");
    	
    	RegularAction regularaction = new RegularAction();
    	
    	Action action = regularaction;
    	
    	/**
         * print the expected result and boolean value
         */
        System.out.println("RegularAction is just a subclass of Action: true");
        /**
         * using instance of operator to test RegularAction is inherited from its superclass
         */
        System.out.println("Expected: " + (regularaction instanceof Action ));
        /**
         * print the expected result and boolean value
         */
        System.out.println("RegularAction has no extra field: true");
        /**
         * using instance of operator to test PerDaySchedule is inherited from its superclass
         */
        System.out.println("Expected: " + (regularaction.equals(action)));
        /**
         * print the expected result and boolean value
         */
        System.out.println("Looking at Regular Actions: Wash your hands"); 
        System.out.println("Expected: Wash your hands");
        /**
         * calling occursOn() method to output the result
         */
      System.out.println(regularaction.occursOn(2022,06,03));
        /**
         * output description of schedule task using object perDayschedule toString() method
         */
        System.out.println("Expected: " + regularaction.occursOn(2022,06,03) );
    	  	
    	
		
	}
}
