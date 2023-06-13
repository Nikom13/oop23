package companies;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import logicalcollections.LogicalSet;

/**
 * @invar | getOwnedCompanies().stream().allMatch(c -> c != null && c.getOwner() == this)
 * @invar | !getTransitivelyOwnedCompanies().contains(this)
 */
public abstract class Entity {
	
	/**
	 * @invar | ownedCompanies != null
	 * @invar | ownedCompanies.stream().allMatch(c -> c != null && c.owner == this)
	 * @invar | !getTransitivelyOwnedCompaniesInternal().contains(this)
	 * 
	 * @representationObject
	 * @peerObjects
	 */
	Set<Company> ownedCompanies = new LinkedHashSet<>();
	
	/**
	 * @post | result != null
	 * @creates | result
	 * 
	 * @peerObjects
	 * @basic
	 */
	public Set<Company> getOwnedCompanies() { return Set.copyOf(ownedCompanies); }

	/**
	 * @post | Objects.equals(
	 *       |     result,
	 *       |     LogicalSet.<Company>matching(companies ->
	 *       |         getOwnedCompanies().stream().allMatch(c -> companies.contains(c)) &&
	 *       |         companies.allMatch(c ->
	 *       |             c.getOwnedCompanies().stream().allMatch(c1 -> companies.contains(c1)))))
	 */
	public Set<Company> getTransitivelyOwnedCompanies() {
		return getTransitivelyOwnedCompaniesInternal();
	}
	
	Set<Company> getTransitivelyOwnedCompaniesInternal() {
		return LogicalSet.matching(companies ->
		    ownedCompanies.stream().allMatch(c -> companies.contains(c)) &&
		    companies.allMatch(c -> c.ownedCompanies.stream().allMatch(c1 -> companies.contains(c1))));
	}
	
	// Keep the compiler from generating a public default constructor
	// so that clients cannot declare subclasses of Entity
	// and so that each Entity object is either a Person object or a Company object.
	Entity() {}
	
}
