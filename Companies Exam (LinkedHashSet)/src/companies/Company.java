package companies;

import logicalcollections.LogicalSet;

/**
 * @invar | getOwner() != null
 * @invar | getOwner().getOwnedCompanies().contains(this)
 */
public class Company extends Entity {
	
	/**
	 * @invar | owner != null
	 * @invar | owner.ownedCompanies.contains(this)
	 * 
	 * @peerObject
	 */
	Entity owner;
	
	/**
	 * @peerObject
	 * @basic
	 */
	public Entity getOwner() { return owner; }
	
	public Person getUltimateOwner() {
		Entity owner = this.owner;
		while (!(owner instanceof Person))
			owner = ((Company)owner).owner;
		return (Person)owner;
	}
	
	/**
	 * @pre | owner != null
	 * @mutates_properties | owner.getOwnedCompanies()
	 * @post | getOwner() == owner
	 * @post | getOwnedCompanies().isEmpty()
	 * @post | owner.getOwnedCompanies().equals(LogicalSet.plus(old(owner.getOwnedCompanies()), this)) 
	 */
	public Company(Entity owner) {
		this.owner = owner;
		owner.ownedCompanies.add(this);
	}
	
	/**
	 * @throws IllegalArgumentException | other == null
	 * @throws IllegalArgumentException | other == getOwner()
	 * @throws IllegalArgumentException | getTransitivelyOwnedCompanies().contains(other)
	 * @mutates_properties | getOwner(), getOwner().getOwnedCompanies(), other.getOwnedCompanies()
	 * @post | getOwner() == other
	 * @post | old(getOwner()).getOwnedCompanies().equals(LogicalSet.minus(old(getOwner().getOwnedCompanies()), this))
	 * @post | other.getOwnedCompanies().equals(LogicalSet.plus(old(other.getOwnedCompanies()), this))
	 */
	public void transferTo(Entity other) {
		if (other == null)
			throw new IllegalArgumentException("other is null");
		if (other == owner)
			throw new IllegalArgumentException("Cannot transfer this company to its current owner");
		if (getTransitivelyOwnedCompanies().contains(other))
			throw new IllegalArgumentException("Cannot transfer this company to a company it transitively owns.");
		
		owner.ownedCompanies.remove(this);
		owner = other;
		owner.ownedCompanies.add(this);
	}

}
