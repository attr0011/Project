package student1;

import java.util.Objects;

/**
This is the Action Superclass class that provides a catalog of actions to be carried out in view of COVID-19 OPH protocols.
You are required to complete read and review this code to appropriately fill the required loopholes.
*/
public abstract class Action
{
private String description;

/**
   Constructs an action without a description.
*/
public Action()
{
   description = ""; 
}

/**
   Sets the description of this action.
   @param description the text description of the action
*/
public void setDescription(String description)
{
   this.description = description;
}

public String getDescription() {
	return description;
}

/**
   Determines if this action occurs on the specified date.
   @param year the year
   @param month the month
   @param day the day
   @return true if the action activity occurs on the specified date.
*/

/**
YOUR TASK - TO DO: Write your abstract method named occursOn() here.
 
*/
        public abstract boolean occursOn (int year, int month , int days) ;
        
        public boolean equals (Object obj)
        {
        	if (this==obj) 
        		return true;
        	if (!(obj instanceof Action)) 
        	return false;
        	Action action = (Action)obj ;
        	return Objects.equals(description , action.description);
        		
        }
               
  

/**
   Converts action activity to string description.
*/
public String toString()
{
   return description;   
}
}


