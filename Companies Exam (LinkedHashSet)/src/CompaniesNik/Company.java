package CompaniesNik;

import java.util.Set;


import logicalcollections.LogicalSet;

/**
 * 
 * @invar | getOwner() != null
 * @invar | getOwner().getOwnedCompanies().contains(this)
 */

public class Company extends Entity{
	
	//invars
	
	
	/**
	 * @invar | owner != null
	 * 
	 * Not sure why
	 * @invar | owner.companies.contains(this)
	 * 
	 * @peerObject
	 */
	Entity owner;
	
	
	//Getter
	
	
	/**
	 * @peerObject
	 * 
	 */
	public Entity getOwner() {
		return owner;
	}
	
	
	//const
	
	
	/**
	 * @throws IllegalArgumentException | owner == null
	 * 
	 * @post | getOwner() == owner
	 * @post | getOwnedCompanies().isEmpty()
	 * @post | owner.getOwnedCompanies().equals(LogicalSet.plus(old(owner.getOwnedCompanies()), this))
	 * 
	 */
	public Company(Entity owner) {
		this.owner = owner;
		owner.companies.add(this);
	}
	
	
	//methods 
	
	
	
	/**
	 * 
	 * 
	 * 
	 * 
	 */
	public Person getUltimateOwner() {
		
		Entity owner = this.owner;
		
		while(!(owner instanceof Person)) {
			owner = ((Company)owner).owner;
			
		}
		
		return (Person)owner;

		
	}
	
	
	
	
	/**
	 * @pre | other != null
	 * @pre | getOwner() != other
	 * 
	 * @mutates | this
	 * 
	 * @post | getOwner() == other
	 * 
	 * 
	 * @post | old(getOwner()).getOwnedCompanies().equals(LogicalSet.minus(old(getOwner().getOwnedCompanies()), this))
	 * @post | other.getOwnedCompanies().equals(LogicalSet.plus(old(other.getOwnedCompanies()), this))
	 * 
	 */
	public void transferTo(Entity other) {
		
		
		if (other == null)
			throw new IllegalArgumentException("other is null");
		if (other == owner)
			throw new IllegalArgumentException("Cannot transfer this company to its current owner");
		if (getOwnedCompanies().contains(other))
			throw new IllegalArgumentException("Cannot transfer this company to a company it transitively owns.");

		owner.companies.remove(this);
		owner = other;
		owner.companies.add(this);
		
	}



	
}
