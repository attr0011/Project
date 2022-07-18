package student1;
/*
 * test the sub classes for part 2
 */
public class ActionDriver2 {

	public static void main(String[] args) {
		
    	  System.out.println("SAMPLE OUTPUT FOR PART 2");
    	  System.out.println(""); 
    	  	  
    	  RegularAction regularaction = new RegularAction();
    	  
    	  OccasionalAction ocassionalaction = new OccasionalAction();
    	  
          RareAction rareaction = new RareAction(); 
          
          System.out.println("OccasionalAction is subclass of Action: true");
        System.out.println("Expected: " + (ocassionalaction instanceof Action));	
          
          System.out.println("RareAction is subclass of Action: true");
        System.out.println("Expected: " + (ocassionalaction instanceof Action));
        /**
         * Checking occasional action has no extra fields
         */    
       Action  action = ocassionalaction;
        
        System.out.println("OccasionalAction have no extra fields:true");
        System.out.println("Expected: " + (ocassionalaction==action));
        /**
         * Checking rare action has no extra fields
         */
        action = rareaction;
        System.out.println("Rare action have no extra fields:true");
        System.out.println("Expected: " + (rareaction==action));
        /**
         * initializing year,month and day
         */
 
	}

}

