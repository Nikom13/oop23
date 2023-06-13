package CompaniesNik;

import java.util.LinkedHashSet;
import java.util.Set;

//We have logical bi-directional relationship

/**
 * 
 * 
 * Use methods here GETTERS
 * @invar | getOwnedCompanies().stream().allMatch(c -> c != null && c.getOwner() == this)
 * 
 *
 */
public abstract class Entity {
	
	
	//invars
	
	
	/**
	 * @representationObject
	 * @peerObjects
	 * 
	 * 
	 * @post | companies != null
	 * @post | companies.stream().allMatch(c -> c != null && c.owner != this)
	 * 
	 */
	Set<Company> companies = new LinkedHashSet<>();
	
	
	//internal getters 
	
	
	/**
	 * @creates | result
	 * @peerObjects
	 * 
	 * @post | result != null
	 * 
	 * 
	 */
	public Set<Company> getOwnedCompanies() { return Set.copyOf(companies); }

	
	
	//setters
	
	Entity(){}
	
	
	
	//constructor
	
	
	
	
	//methods
	
	

}
