package aircontrolNik;

public class areaATC extends ATC {

	
	
	
	
	/**
	 * @post | getControlledAircraft().isEmpty()
	 */
	public areaATC() {
		super();
	}

	@Override
	public boolean canLand(Aircraft aircraft) {
		return false;
	}

	@Override
	public boolean isSimilarTo(ATC other) {
		return other instanceof areaATC;
	}

	

	
	
}
