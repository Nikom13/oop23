package TEST;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import aircontrolNik.Aircraft;
import aircontrolNik.airportATC;
import aircontrolNik.areaATC;

import org.junit.jupiter.api.Test;

class TESTairplane {

	@Test
	void test() {
		airportATC atc1 = new airportATC(60);
		assertEquals(Set.of(), atc1.getControlledAircraft());
		assertEquals(60, atc1.getGates());
		
		Aircraft plane1 = new Aircraft(atc1);
		assertEquals(atc1, plane1.getATC());
		assertEquals(0, plane1.getSpeed());
		assertEquals(Set.of(plane1), atc1.getControlledAircraft());

		plane1.setSpeed(400);
		assertEquals(400, plane1.getSpeed());
		
		areaATC areaATC1 = new areaATC();
		assertEquals(Set.of(), areaATC1.getControlledAircraft());
		
		plane1.transferATC(areaATC1);
		assertEquals(areaATC1, plane1.getATC());
		assertEquals(Set.of(), atc1.getControlledAircraft());
		assertEquals(Set.of(plane1), areaATC1.getControlledAircraft());
		
		
		assertFalse(areaATC1.canLand(plane1));
		plane1.setSpeed(200);
		plane1.transferATC(atc1);
		assertTrue(atc1.canLand(plane1));
		
		areaATC areaATC2 = new areaATC();
		airportATC heathrow = new airportATC(100);
		airportATC schiphol = new airportATC(60);
		assertTrue(areaATC1.isSimilarTo(areaATC2));
		assertFalse(areaATC1.isSimilarTo(atc1));
		assertFalse(atc1.isSimilarTo(heathrow));
		assertTrue(atc1.isSimilarTo(schiphol));
		
		// Transfer to same ATC
		plane1.transferATC(atc1);
		
		
	}

}
