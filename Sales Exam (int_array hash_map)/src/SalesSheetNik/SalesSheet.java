package SalesSheetNik;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public abstract class SalesSheet{



	
	//Getters
	
	
	
	//Setters
	
	
	
	//Constructor 
	
	
	SalesSheet(){}
	
	
	//Methods
	
	//--Number F flavours offered by the chain
	
	//--Number of L locations at which chain operates 
	
	//--Number of P periods recorded in the sheet
	
	
	/**
	 * 
	 */
	public abstract int getNbFlavours();

	
	/**
	 * 
	 */
	public abstract int getNbLocations();
	
	
	/**
	 * 
	 */
	public abstract int getNbPeriods();
	
	
	//--Getter for scoops of ice cream (int), by using the 
	//--index of the flavours from the array,
	//--index of the location and index of period
	
	
	/**
	 * @pre | flavourIndex < getNbFlavours() && flavourIndex >= 0
	 * @pre | locationIndex < getNbLocations() && locationIndex >= 0
	 * @pre | periodIndex < getNbPeriods() && periodIndex >= 0
	 * 
	 * 
//	 * @post | result == getAllSales()
	 * 
	 */
	public abstract int getScoopsSold( int flavourIndex, 
			int locationIndex, int periodIndex);
	
	
	//--Setter for scoops of ice cream (int), by using the 
	//--index of the flavours from the array,
	//--index of the location and index of period
	
	
	/**
//	 * @creates | result
	 * 
	 * @pre | flavourIndex < getNbFlavours() && flavourIndex >= 0
	 * @pre | locationIndex < getNbLocations() && locationIndex >= 0
	 * @pre | periodIndex < getNbPeriods() && periodIndex >= 0
	 * @pre | scoops >= 0
	 * 
	 * 
	 * 
	 * @mutates | this
	 * 
	 * CHECK GET ALL SALES FUNCTION
	 * @post | IntStream.range(0 , getNbFlavours()).allMatch(f ->
	 * 		 | 		IntStream.range(0, getNbLocations()).allMatch(l -> 
	 * 		 |			IntStream.range(0, getNbPeriods()).allMatch(p -> 
	 * 		 |				getAllSales()[f + getNbFlavours() * (l + getNbLocations() * p)] == (
	 *       |                  f == flavourIndex && l == locationIndex && p == periodIndex ?
	 *       |                      scoops
	 *       |                  :
	 *       |                      old(getAllSales())[f + getNbFlavours() * (l + getNbLocations() * p)]
	 *       |              )
	 *       |          )
	 *       |     )
	 *       | )
	 * 
	 */
	public abstract void setScoopsSold( int flavourIndex, 
			int locationIndex, int periodIndex, int scoops);
	
	
	//--getAllSales lenght(P * L * F)
	
	/**
	 * Why int[]? Not sure
	 */
	public abstract int[] getAllSales();
	
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof SalesSheet s &&
				getNbFlavours() == s.getNbFlavours() &&
				getNbLocations() == s.getNbLocations() &&
				getNbPeriods() == s.getNbPeriods() &&
				Arrays.equals(getAllSales(), s.getAllSales());
	}
	
	
}
