package aircontrolNik;

import logicalcollections.LogicalSet;

/**
 * 
 * @invar | getATC() != null
 * 
 * 
 *
 */

public class Aircraft {

	//Invars
	
	/**
	 * @invar | atc != null
	 * @invar | speed >= 0
	 * 
	 * 
	 * Set function
	 * @invar | atc.aircrafts.contains(this)
	 * 
	 * @peerObject
	 * 
	 */
	ATC atc;
	
	int speed;
	

	
	//Internal Getters and Setters
	

	/**
	 * @invar | speed != null
	 * @invar | speed >= 0
	 * 
	 */
	public int getSpeed() {
		return speed;
	}

	
	
	/**
	 * @peerObject
	 * @post | result != null
	 * 
	 */
	public ATC getATC() {
		return atc;
	}
	
	
	
	
	/**
	 * @pre | speed >= 0
	 * 
	 * @mutates_properties | getSpeed()
	 * 
	 * @post | getSpeed() == speed
	 * 
	 * 
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	

	
	/**
	 * Constructor 
	 * 
	 * Illegal works only with constructors
	 * @throws IllegalArgumentException | atc == null
	 * 
	 * 
	 * @mutates_properties | atc.getControlledAircraft()
	 * 
	 * @post | atc.getControlledAircraft().equals(LogicalSet.plus(old(atc.getControlledAircraft()), this))
	 * 
	 * 
	 * @post | getATC() == atc
	 * @post | getSpeed() == 0
	 */
	public Aircraft(airportATC atc) {
		
		this.atc = atc;
		
		//Add to the bidirectional set
		atc.aircrafts.add(this);
		
	}
	
	
	
	//Methods
	
	/**
	 * 
	 * @pre | atc != null
	 * 
	 * @mutates_properties | getATC(), getATC().getControlledAircraft()
	 * @post | getATC() == atc
	 * 
	 * 
	 * @post | atc == old(getATC()) ?
	 *       |     atc.getControlledAircraft().equals(old(atc.getControlledAircraft()))
	 *       | :
	 *       |     old(getATC()).getControlledAircraft().equals(LogicalSet.minus(old(getATC().getControlledAircraft()), this)) &&
	 *       |     atc.getControlledAircraft().equals(LogicalSet.plus(old(atc.getControlledAircraft()), this))
	 */
	public void transferATC(ATC atc) {
		
		
		//remove first
		this.atc.aircrafts.remove(this);		
		this.atc = atc;
		//Bidirection adding now
		
		atc.aircrafts.add(this);
	
	}
	


}
