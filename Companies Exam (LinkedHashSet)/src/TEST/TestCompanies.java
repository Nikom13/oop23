package TEST;


import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;

import CompaniesNik.Person;
import CompaniesNik.Company;


class TestCompanies {

	@Test
	void test() {
		
		Person man = new Person();
		assertTrue(man.getOwnedCompanies().isEmpty());
		
		Company kek = new Company(man);
		assertEquals(man, kek.getOwner());
		assertEquals(man, kek.getUltimateOwner());
		assertFalse(man.getOwnedCompanies().isEmpty());
		assertEquals(Set.of(kek), man.getOwnedCompanies() );
		
		
		Company lel = new Company(kek);
		assertEquals(kek, lel.getOwner());
		

		Person woman = new Person();
		kek.transferTo(woman);
		assertEquals(woman, kek.getOwner());
		
		assertEquals(woman, lel.getUltimateOwner());

		
	}

}
