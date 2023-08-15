package seven;

public class Human {
	String first = "";
	String last = "";
	String gender = "";
	int year = 0;
	int month = 0;
	int day = 0;
	
	public Human(String fname, String lastn, String Gender, int byear, int bmonth, int bday) {
		this.first = fname;
		this.last = lastn;
		this.year = byear;
		this.month = bmonth;
		this.day = bday;
		if (Gender.contains("female") || Gender.contains("Female") || Gender.contains("male") || Gender.contains("Male") || Gender.contains("they") || Gender.contains("They") || Gender.contains("non") || Gender.contains("Non")) {
			this.gender = Gender;
		}
		else {
			System.out.println("Sorry! we haven't added that gender yet for now we will give you other. (This can be changed later)");
			this.gender = "Other";
		}
	}
	
	public String getFirstname() {
		return this.first;
	}
	
	public String getLastname() {
		return this.last;
	}
	
	public String getFullname() {
		return this.first + " " + this.last;
	}
	
	public String getGender() {
		return this.gender;
	}
	
	public void setFirstname(String newname) {
		this.first = newname;
	}
	
	public void setLastname(String newname) {
		this.last = newname;
	}
	
	public void setGender(String Gender) {
		if (Gender.contains("female") || Gender.contains("Female") || Gender.contains("male") || Gender.contains("Male") || Gender.contains("they") || Gender.contains("They") || Gender.contains("non") || Gender.contains("Non")) {
			this.gender = Gender;
		}
		else {
			System.out.println("Sorry! we haven't added that gender yet. For now we will give you other. (This can be changed later)");
			this.gender = "Other";
		}
	}
	
	public int getbirthYear() {
		return this.year;
	}
	
	public int getbirthMonth() {
		return this.month;
	}
	
	public int getbirthDay() {
		return this.day;
	}
	
	public int calculateAge() {
		int Age = (2022 - year);
		if (this.month > 10) {
			Age--;
		}
		if (this.month == 10 && this.day > 11) {
			Age--;
		}
		return Age;
	}
}