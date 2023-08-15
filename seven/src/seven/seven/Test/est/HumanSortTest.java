package seven.Test.est;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import org.junit.Test;

import junit.framework.TestCase;
import seven.Adult;
import seven.CentennialStudent;
import seven.Human;
import seven.HumanComp;
import seven.Youth;

public class HumanSortTest extends TestCase {
		
	private Human[] createHumans() {
		int graduateBirthYear = LocalDateTime.now().getYear() - 18;
		String schoolName = "Centennial High School";
		Human[] humans = {				
				new Adult("Folco", "Gaukrogers", "Male", 1934, 11, 7, "Principal", schoolName),
				
				//CentennialStudent(int birthYear, int birthMonth, int birthDay, String firstName, String lastName, Gender gender, int schoolGrade, int homeRoom, String homeRoomTeacher)
				new CentennialStudent("Banazir", "Rumble", "Male", graduateBirthYear, 6, 4, 12, "310", "Wehnes"),
				new Youth("Munderic", "Wanderfoot", "Male", graduateBirthYear, 11, 17, 12, schoolName),
				new Adult("Ceufroy", "Longbottom", "Male", 1946, 4, 23, "Teacher", schoolName),
				new Youth("Meginhard", "Chubb", "Male", 1931, 8, 20, 12, schoolName),
				new Youth("Tolman", "Burns", "Male", graduateBirthYear, 12, 16, 12, schoolName),
				new Adult("Fulvus", "Hayward", "Male", 1901, 3, 14, "Teacher", schoolName),
				new Adult("Charles ", "Silverstring", "Male", 1946, 1, 3, "Teacher", schoolName),
				new Adult("Berenger", "Featherbottom", "Male", 1943, 4, 16, "Teacher", schoolName),
				new Adult("Waltgaud", "Headstrong", "Male", 1926, 7, 14, "Librarian", schoolName),
				new CentennialStudent("Neela", "Burrowes", "Female", graduateBirthYear, 6, 3, 12, "304", "Brunelle"),
				new Youth("Alura", "Rumblebelly", "Female", graduateBirthYear, 12, 16, 0, schoolName),
				new Adult("Liutgarde", "Sackville", "Female", 1948, 12, 24, "Teacher", schoolName),
				new Youth("Belinda", "Brockhouse", "Female", graduateBirthYear - 18, 3, 17, 12, schoolName),
				new Adult("Esmeralda", "Longfoot", "Female", 1921, 9, 16, "Teacher", schoolName),
				new Youth("Lauren", "Langham", "Female", graduateBirthYear, 7, 21, 12, schoolName),
				new Youth("Esmeralda", "Fairbairn", "Female", graduateBirthYear, 5, 31, 12, schoolName),
				new Adult("Nantechildis", "Tunnelly", "Female", 1936, 1, 20, "Councilor", schoolName),
				new CentennialStudent("Marcovefa", "Bunce", "Female", graduateBirthYear, 12, 19, 12, "301", "Marshall"),
				new Adult("Hamesindis", "Fallohide", "Female", 1968, 5, 27, "Facility Operator", schoolName)
		};
		return humans;
	}
	
	@Test
	public void testAgeOrder() {

		Comparator<Human> ageOrd = HumanComp.AgeOrder;
		Human human1 = new Human("Older", "Longtooth", "Female", 1965, 1, 1);
		Human human2 = new Human("Younger", "Babyface", "Female", 1965, 6, 1);
		
		assertEquals(true, ageOrd.compare(human1,human2) < 0);		
		assertEquals(true, ageOrd.compare(human2,human1) > 0);		
		assertEquals(true, ageOrd.compare(human1,human1) == 0);				
	}

	@Test
	public void testAssemblyOrder() {

		Comparator<Human> assemblyOrder = HumanComp.Assemblyorder;
		Human human = new Human("Sine", "Nomine", "Female", 1998, 04, 26);
		Adult adult = new Adult("Sine", "Nomine", "Female", 1998, 04, 26, "Some Company", "Some Job");
		Youth youth = new Youth("Sine", "Nomine", "Female", 1998, 04, 26, 12, "Some School");
		CentennialStudent abeStudent = new CentennialStudent("Sine", "Nomine", "Female", 1998, 04, 26, 12, "310", "Wehnes");
		
		assertEquals(true, assemblyOrder.compare(abeStudent,youth) < 0);		
		assertEquals(true, assemblyOrder.compare(youth,adult) < 0);		
		assertEquals(true, assemblyOrder.compare(adult,human) < 0);				

		assertEquals(true, assemblyOrder.compare(youth, abeStudent) > 0);		
		assertEquals(true, assemblyOrder.compare(adult,youth) > 0);		
		assertEquals(true, assemblyOrder.compare(human, adult) > 0);				

		assertEquals(true, assemblyOrder.compare(abeStudent, abeStudent) == 0);		
		assertEquals(true, assemblyOrder.compare(youth,youth) == 0);		
		assertEquals(true, assemblyOrder.compare(adult, adult) == 0);				
		assertEquals(true, assemblyOrder.compare(human, human) == 0);				

	}

	@Test
	public void testNameOrder() {

		Comparator<Human> nameOrder = HumanComp.Nameorder;
		Human human1 = new Human("Aaron", "Agamemnon", "Male", 1965, 1, 1);
		Human human2 = new Human("Zyzyk", "Zebulon", "Male", 1965, 6, 1);
		
		assertEquals(true, nameOrder.compare(human1,human2) < 0);		
		assertEquals(true, nameOrder.compare(human2,human1) > 0);		
		assertEquals(true, nameOrder.compare(human1,human1) == 0);				
	}

	public void testSortByAge() {

		Comparator<Human> c = HumanComp.AgeOrder;
		Human[] humans = createHumans();
		
        Arrays.sort(humans, c);

        System.out.println("\ntestSortByAge");
        printHumans(humans);

		assertEquals("Hayward", humans[0].getLastname());
		assertEquals("Longfoot", humans[1].getLastname());
		assertEquals("Headstrong", humans[2].getLastname());
		assertEquals("Chubb", humans[3].getLastname());
		assertEquals("Gaukrogers", humans[4].getLastname());
		assertEquals("Tunnelly", humans[5].getLastname());
		assertEquals("Featherbottom", humans[6].getLastname());
		assertEquals("Silverstring", humans[7].getLastname());
		assertEquals("Longbottom", humans[8].getLastname());
		assertEquals("Sackville", humans[9].getLastname());
		assertEquals("Fallohide", humans[10].getLastname());
		assertEquals("Brockhouse", humans[11].getLastname());
		assertEquals("Fairbairn", humans[12].getLastname());
		assertEquals("Burrowes", humans[13].getLastname());
		assertEquals("Rumble", humans[14].getLastname());
		assertEquals("Langham", humans[15].getLastname());
		assertEquals("Wanderfoot", humans[16].getLastname());
		assertEquals("Burns", humans[17].getLastname());
		assertEquals("Rumblebelly", humans[18].getLastname());
		assertEquals("Bunce", humans[19].getLastname());

		
	}

	public void testSortByName() {

		Comparator<Human> c = HumanComp.Nameorder;
		Human[] humans = createHumans();
		
        Arrays.sort(humans, c);

        System.out.println("\ntestSortByName");
        printHumans(humans);
		
		assertEquals("Brockhouse", humans[0].getLastname());
		assertEquals("Bunce", humans[1].getLastname());
		assertEquals("Burns", humans[2].getLastname());
		assertEquals("Burrowes", humans[3].getLastname());
		assertEquals("Chubb", humans[4].getLastname());
		assertEquals("Fairbairn", humans[5].getLastname());
		assertEquals("Fallohide", humans[6].getLastname());
		assertEquals("Featherbottom", humans[7].getLastname());
		assertEquals("Gaukrogers", humans[8].getLastname());
		assertEquals("Hayward", humans[9].getLastname());
		assertEquals("Headstrong", humans[10].getLastname());
		assertEquals("Langham", humans[11].getLastname());
		assertEquals("Longbottom", humans[12].getLastname());
		assertEquals("Longfoot", humans[13].getLastname());
		assertEquals("Rumble", humans[14].getLastname());
		assertEquals("Rumblebelly", humans[15].getLastname());
		assertEquals("Sackville", humans[16].getLastname());
		assertEquals("Silverstring", humans[17].getLastname());
		assertEquals("Tunnelly", humans[18].getLastname());
		assertEquals("Wanderfoot", humans[19].getLastname());
		
	}
	
	public void testSortByAsemblyOrder() {

		Comparator<Human> c = HumanComp.Assemblyorder;
		Human[] humans = createHumans();

        Arrays.sort(humans, c);

        System.out.println("\ntestSortByAsemblyOrder");
        printHumans(humans);

		assertEquals("Bunce", humans[0].getLastname());
		assertEquals("Burrowes", humans[1].getLastname());
		assertEquals("Rumble", humans[2].getLastname());
		assertEquals("Brockhouse", humans[3].getLastname());
		assertEquals("Burns", humans[4].getLastname());
		assertEquals("Chubb", humans[5].getLastname());
		assertEquals("Fairbairn", humans[6].getLastname());
		assertEquals("Langham", humans[7].getLastname());
		assertEquals("Rumblebelly", humans[8].getLastname());
		assertEquals("Wanderfoot", humans[9].getLastname());
		assertEquals("Fallohide", humans[10].getLastname());
		assertEquals("Featherbottom", humans[11].getLastname());
		assertEquals("Gaukrogers", humans[12].getLastname());
		assertEquals("Hayward", humans[13].getLastname());
		assertEquals("Headstrong", humans[14].getLastname());
		assertEquals("Longbottom", humans[15].getLastname());
		assertEquals("Longfoot", humans[16].getLastname());
		assertEquals("Sackville", humans[17].getLastname());
		assertEquals("Silverstring", humans[18].getLastname());
		assertEquals("Tunnelly", humans[19].getLastname());
		
	}

	public void testComparable() {
		
		Human[] humans = createHumans();
		ArrayList<Human> humansList = new ArrayList<Human>(Arrays.asList(humans));
		Comparator<Human> c = HumanComp.AgeOrder;
		
		Collections.sort(humansList, c);
		Human[] sortedHumans = new Human[humansList.size()];
		humansList.toArray(sortedHumans);
		
        System.out.println("\ntestComparable");
        printHumans(sortedHumans);
				
		assertEquals("Hayward", sortedHumans[0].getLastname());
		assertEquals("Longfoot", sortedHumans[1].getLastname());
		assertEquals("Headstrong", sortedHumans[2].getLastname());
		assertEquals("Chubb", sortedHumans[3].getLastname());
		assertEquals("Gaukrogers", sortedHumans[4].getLastname());
		assertEquals("Tunnelly", sortedHumans[5].getLastname());
		assertEquals("Featherbottom", sortedHumans[6].getLastname());
		assertEquals("Silverstring", sortedHumans[7].getLastname());
		assertEquals("Longbottom", sortedHumans[8].getLastname());
		assertEquals("Sackville", sortedHumans[9].getLastname());
		assertEquals("Fallohide", sortedHumans[10].getLastname());
		assertEquals("Brockhouse", sortedHumans[11].getLastname());
		assertEquals("Fairbairn", sortedHumans[12].getLastname());
		assertEquals("Burrowes", sortedHumans[13].getLastname());
		assertEquals("Rumble", sortedHumans[14].getLastname());
		assertEquals("Langham", sortedHumans[15].getLastname());
		assertEquals("Wanderfoot", sortedHumans[16].getLastname());
		assertEquals("Burns", sortedHumans[17].getLastname());
		assertEquals("Rumblebelly", sortedHumans[18].getLastname());
		assertEquals("Bunce", sortedHumans[19].getLastname());
		
	}
	
	private void printHumans(Human[] humans) {
		System.out.println("----------------");
	
		for (int i = 0; i < humans.length; i++) {
			System.out.println(toFullDescriptionString(humans[i]));			
		}
	}
		
	private String toFullDescriptionString(Human h) {
		return String.format("%-20s%-20s%-25s (%04d/%02d/%02d)", h.getLastname(), h.getFirstname(), h.getClass(), h.getbirthYear(), h.getbirthMonth(), h.getbirthDay());				
	}
	
}