package seven;

public class Introducer {
	static String pronouns = "";
	public static void main(String[] args) {
		Youth pain = new Youth("James", "Man", "Non-Binary", 1999, 3, 6, 225, "Your Momlol");
		System.out.println(createIntroduction(pain));
	}
	
	public static String createIntroduction(Human person) {
		String Name = nameIntro(person);
		String Age = ageIntro(person);
		String other = "";
		if (person instanceof Adult) {
			other = adultIntro((Adult) person);
		}
		else if (person instanceof Youth) {
			if (person instanceof CentennialStudent) {
				other = centIntro((CentennialStudent) person);
			}
			else {
				other = childIntro((Youth) person);
			}
		}
		
		return Name + "" + Age + "" + other;
	}
	
	public static String nameIntro(Human person) {
		return ("Hello, we are glad to introduce " + person.getFullname());
	}
	
	public static String ageIntro(Human person) {
		String gen = person.getGender();
		int age = person.calculateAge();
		if (gen.contains("female") || gen.contains("Female")) {
			pronouns = "She/Her";
			return (". Pronouns are She/Her. She is " + age + " years old. ");
		}
		else if (gen.contains("male") || gen.contains("Male")) {
			pronouns = "He/Him";
			return (". Pronouns are He/Him. He is " + age + " years old. ");
		}
		else if (gen.contains("non") || gen.contains("Non")) {
			pronouns = "They/Them";
			return (". Pronouns are They/Them. They are " + age + " years old. ");
		}
		else {
			pronouns = "Other";
			return (". They are " + age + " years old. ");
		}
	}
	
	public static String adultIntro(Adult person) {
		String Occu = person.getOccupation();
		String Work = person.getWorkplace();
		if (pronouns.contains("She/Her")) {
			return ("She works over at " + Work + " doing " + Occu + ". ");
		}
		else if (pronouns.contains("He/Him")) {
			return ("He works over at " + Work + " doing " + Occu + ". ");
		}
		else if (pronouns.contains("They/Them")) {
			return ("They works over at " + Work + " doing " + Occu + ". ");
		}
		else {
			return (person.getFullname() + " works over at " + Work + " doing " + Occu + ". ");
		}
	}
	
	public static String childIntro(Youth person) {
		String school = person.getSchool();
		int grade = person.getGrade();
		if (pronouns.contains("She/Her")) {
			return ("She is enrolled over at " + school + " in grade " + grade + ". ");
		}
		else if (pronouns.contains("He/Him")) {
			return ("He is enrolled over at " + school + " in grade " + grade + ". ");
		}
		else if (pronouns.contains("They/Them")) {
			return ("They are enrolled at " + school + " in grade " + grade + ". ");
		}
		else {
			return (person.getFullname() + " is enrolled at " + school + " in grade " + grade + ". ");
		}
	}
	
	public static String centIntro(CentennialStudent prisoner) {
		String school = prisoner.getSchool();
		int grade = prisoner.getGrade();
		String classe = prisoner.getClasse();
		if(classe.contains("ulti") || classe.contains("puter")) {
			classe = "the MultiMedia Lab.";
		}
		else if(classe.contains("ibary")|| classe.contains("afe")) {
			classe = "the " + prisoner.getClasse() + ".";
		}
		else {
			classe = "room " + prisoner.getClasse() + ".";
		}
		String teach = prisoner.getTeacher();
		String ret = "";
		if (pronouns.contains("She/Her")) {
			ret = ("She goes to " + school + " and is in grade " + grade + ". Her class is with " + teach + " in " + classe);
			return ret;
		}
		else if (pronouns.contains("He/Him")) {
			ret = ("He goes to " + school + " and is in grade " + grade + ". His class is with " + teach + " in " + classe);
			return ret;
		}
		else if (pronouns.contains("They/Them")) {
			ret = ("They goes to " + school + " and is in grade " + grade + ". Their class is with " + teach + " in " + classe);
			return ret;
		}
		else {
			ret = (prisoner.getFullname() + " goes to " + school + " and is in grade " + grade + ". They have class with " + teach + " in " + classe);
			return ret;
		}
	}
}