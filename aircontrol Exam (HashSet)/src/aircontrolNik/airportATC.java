package aircontrolNik;

public class airportATC extends ATC{

	/**
	 * @ivar | gates > 0
	 * 
	 */
	final int gates;
	
	
	/**
	 * @post | getGates() == gates
	 * 
	 * 
	 * Not sure why
	 * @post | getControlledAircraft().isEmpty()
	 * 
	 * 
	 */
	public airportATC(int gates) {
		this.gates = gates;
		
	}
	
	
	//GEtters
	

	public int getGates() {
		return gates;
	}
	
	

	////NOT SURE
	@Override
	public boolean canLand(Aircraft aircraft) {
		return aircraft.getSpeed() < 300;
	}


	///NOT sure
	@Override
	public boolean isSimilarTo(ATC other) {
		
		
		///REMEMEVBR THIS 
		return other instanceof airportATC && gates == ((airportATC)other).gates;
	}

	
	
	
}
