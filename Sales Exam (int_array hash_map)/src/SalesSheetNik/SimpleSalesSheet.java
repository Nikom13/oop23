package SalesSheetNik;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleSalesSheet extends SalesSheet{

	
	//Invars
		
	
	
//	/**
//	 * @represenationObject
//	 * 
//	 * @invar | periods != null
//	 * @invar | periods.stream().allMatch(p -> p != null)
//	 * 
//	 * 
//	 */
//	List<String> periods = new ArrayList<>();
//	
//	
//	/**
//	 * @represenationObject
//	 * 
//	 * @invar | locations != null
//	 * @invar | locations.stream().allMatch(l -> l != null)
//	 * 
//	 * 
//	 */
//	List<String> locations = new ArrayList<>();
//	
//	/**
//	 * @representationObject
//	 * 
//	 * @invar | flavours != null
//	 * @invar | flavours.stream().allMatch(f -> f != null)
//	 * 
//	 */
//	List<String> flavours = new ArrayList<>();
	
	
	
	
	/**
	 * @invar | nbF >= 0
	 * @invar | nbL >= 0
	 * @invar | nbP >= 0
	 * @invar | sales != null
	 * @invar | sales.length == nbF * nbL * nbP
	 * @invar | Arrays.stream(sales).allMatch( n -> 0 <= n)
	 * 
	 * 
	 */
	private int nbF;
	private int nbL;
	private int nbP;
	
	/**
	 * represenationObject
	 */
	private int[] sales;
	
	
	
	
	//Constructor 
	
	
	/**
	 * @throws IllegalArgumentException | nbF < 0 || nbL < 0 || nbP < 0
	 * @throws IllegalArgumentException | sales == null || sales.length != nbF * nbL * nbP
	 * @throws IllegalArgumentException | Arrays.stream(sales).anyMatch(n -> n < 0)
	 * 
	 * @inspects | sales
	 * 
	 * @post | getNbFlavours() == nbF
	 * @post | getNbLocations() == nbL
	 * @post | getNbPeriods() == nbP
	 * @post | Arrays.equals(getAllSales(), sales)
	 */
	public SimpleSalesSheet(int nbF, int nbL, int nbP, int[] sales) {
		
		
		this.nbF = nbF;
		this.nbL = nbL;
		this.nbP = nbP;
		this.sales = sales.clone();
	}


	
	
	//Methods


	@Override
	public int getNbFlavours() {
		return nbF;
	}




	@Override
	public int getNbLocations() {
		return nbL;
	}




	@Override
	public int getNbPeriods() {
		return nbP;
	}




	@Override
	public int getScoopsSold(int flavourIndex, int locationIndex, int periodIndex) {

		return sales[flavourIndex + nbF * (locationIndex + nbL * periodIndex) ];
	}




	@Override
	public void setScoopsSold(int flavourIndex, int locationIndex, int periodIndex, int scoops) {
		sales[flavourIndex + nbF * (locationIndex + nbL * periodIndex)] = scoops;		
	}




	@Override
	public int[] getAllSales() {
		return sales.clone();
	}
			
			
			
			
			
			
			
			
			
}
