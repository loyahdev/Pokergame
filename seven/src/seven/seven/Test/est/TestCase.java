package seven.Test.est;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Test;

import seven.*;


public class TestCase {

	Human burns = new Human("Montgomery", "Burns", "Male", 1901, 03, 11);
	Adult homer = new Adult("Homer", "Simpson", "Male", 1987, 04, 19, "Springfield Nuclear Power Plant", "Nuclear Safety Inspector");
	Youth lisa = new Youth("Lisa", "Simpson", "Female", 2005, 01, 01, 3, "Springfield Elementary");
	CentennialStudent nemo = new CentennialStudent("Sine", "Nomine", "Female", 1998, 04, 26, 11, "310", "Wehnes");
	
	@Test
	public void testConstructors() {
		assertEquals(true, burns != null);
		assertEquals(true, homer != null);
		assertEquals(true, lisa != null);
		assertEquals(true, nemo != null);
	}
	
	@Test
	public void testAccessors() {
		assertEquals(1901, burns.getbirthYear());
		assertEquals(3, burns.getbirthMonth());
		assertEquals(11, burns.getbirthDay());
		assertEquals("Montgomery", burns.getFirstname());
		assertEquals("Burns", burns.getLastname());

		assertEquals(2005, lisa.getbirthYear());
		assertEquals(1, lisa.getbirthMonth());
		assertEquals(1, lisa.getbirthDay());
		assertEquals("Lisa", lisa.getFirstname());
		assertEquals("Simpson", lisa.getLastname());
		assertEquals(3, lisa.getGrade());
		assertEquals("Springfield Elementary", lisa.getSchool());

		assertEquals(1998, nemo.getbirthYear());
		assertEquals(04, nemo.getbirthMonth());
		assertEquals(26, nemo.getbirthDay());
		assertEquals("Sine", nemo.getFirstname());
		assertEquals("Nomine", nemo.getLastname());
		assertEquals(11, nemo.getGrade());
		assertEquals("Centennial High School", nemo.getSchool());
	}
	
	@Test
	public void testMutators() {
		burns.setFirstname("Monty");
		burns.setLastname("Burnsy");
		assertEquals("Monty", burns.getFirstname());
		assertEquals("Burnsy", burns.getLastname());
		
		homer.setFirstname("Ned");
		homer.setLastname("Flanders");
		assertEquals("Ned", homer.getFirstname());
		assertEquals("Flanders", homer.getLastname());
	}
	
	@Test
	public void testTypes() {
		Human person1 = nemo;		
		assertEquals(true, person1 instanceof Human);
		assertEquals(true, person1 instanceof Youth);
		assertEquals(true, person1 instanceof CentennialStudent);
		assertEquals(false, person1 instanceof Adult);

		Human person2 = homer;		
		assertEquals(true, person2 instanceof Human);
		assertEquals(false, person2 instanceof Youth);
		assertEquals(false, person2 instanceof CentennialStudent);
		assertEquals(true, person2 instanceof Adult);

		Human person3 = burns;		
		assertEquals(true, person3 instanceof Human);
		assertEquals(false, person3 instanceof Youth);
		assertEquals(false, person3 instanceof CentennialStudent);
		assertEquals(false, person3 instanceof Adult);
	}

	@Test
	public void testCalculateCurrentAge() {
		Adult bloggins;
		LocalDateTime testDate;
		LocalDateTime currentDate = LocalDateTime.now();

		testDate = currentDate.minusYears(40).minusMonths(1).minusDays(3);
		//should be 40 years 1 month 3 days old
		bloggins = new Adult("Bill", "Bloggins", "Male", testDate.getYear(), testDate.getMonthValue(), testDate.getDayOfMonth(), 
				"RCN", "Sailor");		
		assertEquals(40, bloggins.calculateAge());

		testDate = currentDate.minusYears(40).minusDays(1);
		//should be 40 years 1 day old
		bloggins = new Adult("Bill", "Bloggins", "Male", testDate.getYear(), testDate.getMonthValue(), testDate.getDayOfMonth(),
				"RCN", "Sailor");		
		assertEquals(40, bloggins.calculateAge());

		testDate = currentDate.minusYears(40);
		//should be exactly 40 years old
		bloggins = new Adult("Bill", "Bloggins", "Male", testDate.getYear(), testDate.getMonthValue(), testDate.getDayOfMonth(),
				"RCN", "Sailor");		
		assertEquals(40, bloggins.calculateAge());

		testDate = currentDate.minusYears(40).plusMonths(1);
		//should be 39 years 11 months old
		bloggins = new Adult("Bill", "Bloggins", "Male", testDate.getYear(), testDate.getMonthValue(), testDate.getDayOfMonth(), 
				"RCN", "Sailor");		
		assertEquals(39, bloggins.calculateAge());
		
		testDate = currentDate.minusYears(40).plusDays(1);
		//should be 39 years 364 days old
		bloggins = new Adult("Bill", "Bloggins", "Male", testDate.getYear(), testDate.getMonthValue(), testDate.getDayOfMonth(),
				"RCN", "Sailor");		
		assertEquals(39, bloggins.calculateAge());

		testDate = currentDate.minusYears(40).plusMonths(1).minusDays(3);
		//should be 39 years 11 months 25-28 days old
		bloggins = new Adult("Bill", "Bloggins", "Male", testDate.getYear(), testDate.getMonthValue(), testDate.getDayOfMonth(),
				"RCN", "Sailor");		
		assertEquals(39, bloggins.calculateAge());
	
	}
	
	@Test
	public void testPublicIntroduction() {
		System.out.println(Introducer.createIntroduction(burns));
		System.out.println(Introducer.createIntroduction(homer));
		System.out.println(Introducer.createIntroduction(lisa));
		System.out.println(Introducer.createIntroduction(nemo));		
	}
}
