package student1;


/**
   This is code for Part 1.
   YOUR TASK is to create a subclass named RegularAction. This is 
   a subclass of the Action Superclass.
   Action has a description (for example,
   "Wash your hands") and occurs on one or more dates.
   A regularaction activity occurs every day.
*/

//YOUR CODE STARTS HERE!!!!

public class RegularAction extends Action {
	
	public RegularAction() {
		super();
	}
		
		  /**
	     * This method sets the daily activity
	     *
	     * @param year  the year in which the Action scheduled
	     * @param month the month in which the action scheduled
	     * @param day   the day in which the action scheduled
	     * @return true for daily activity
	     */

	    /**
	     * Override dueOn() method from super class Action
	     * with concrete implementation of objects required in daily schedule.
	     */
	
		public boolean occursOn (int year, int month , int days) {
			setDescription("Wash your hands");
			setDescription("Takes a PCR test");
		    setDescription("Sit two meters apart");
			 return true ;
 
		} 
		 
 	public String toString()
 	{
 	  return super.getDescription();   
 	}
		
}

 


















