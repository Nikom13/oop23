package aircontrolNik;

import java.util.HashSet;
import java.util.Set;


/**
 * ABSTRACT CLASS
 * 
 * @author makar
 *
 */

public abstract class ATC {
	
	
	//INVARS

	
	/**
	 * @represeantaionObject
	 * 
	 * @invar | aircrafts != null
	 * @invar | aircrafts.stream().allMatch(a -> a != null && a.atc == this)
	 * 
	 * @peerObjects
	 */
	Set<Aircraft> aircrafts = new HashSet<>();
	
	
	
	/**
	 * @creates | result
	 * 
	 * @peerObjects
	 */
	public Set<Aircraft> getControlledAircraft() {
		return Set.copyOf(aircrafts);
	}
	
	
	
//	//SETTER
//	
//	public void setCanLand(boolean canLand) {
//		this.canLand = canLand;
//	}


	/**
	 * Constructor
	 */
	public ATC() {
		
	}
	
	
	//METHODS
	
	
	///ABSTRACT METHODS ARE NOT 
	/**
	 * 
	 */
	public abstract boolean canLand(Aircraft aircraft);
	
	/**
	 * work arpund
	 * 
	 */
	public abstract boolean isSimilarTo(ATC other);
	
	
}
