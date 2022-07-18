package student1;

	
	public class OccasionalAction extends Action {
		
		/**
		 * PerMonthSchedule class has its own constructor chained to one-argument superclass constructor
		 */
	    public OccasionalAction() {
	        super();
	    }

		@Override
		public boolean occursOn(int year, int month, int days) {
			if (year==2022 && month ==12 && days ==20)
			{  setDescription("Wash your hands");
			setDescription("Get a booster shot");
		setDescription("Sit two meters apart");
			return true; 
			}
			
				return false;			

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
			
			
	}
		
				public String toString()
			{
		   return super.getDescription();   
			}
}
