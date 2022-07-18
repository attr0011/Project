package student1;
/*
 * rareAction subclass of action superclass class
 */
public class RareAction extends Action {
	
	
	public RareAction () {
		super();
	}
	/**
     * This method sets the monthly activity on a particular date
     *
     * @param year  the year of the schedule
     * @param month the month of the schedule
     * @param day   the day of the schedule
     * @return true if given date is matched, false otherwise
     */
    /**
     * Override dueOn() method from super class Schedule
     * with concrete implementation of objects required in month schedule.
      */

	@Override
	public boolean occursOn(int year, int month, int days) {
		 if (year == 2022 && month == 06 && days == 03) {
	            setDescription("Take a PCR test");
	           setDescription("Get a booster shot");
	         setDescription("Sit two meters apart");
	            return true; 
	        }
		
			 return false; 
		 
	}
	/*
	 * return the  get description
	 */
		public String toString()
	{
	   return super.getDescription();   
	}
	
	
}
