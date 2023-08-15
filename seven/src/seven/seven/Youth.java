package seven;

public class Youth extends Human{
	int Grade = 0;
	String schoolName = "";
	
	public Youth(String fname, String lastn, String Gender, int byear, int bmonth, int bday, int grade, String sname) {
		super(fname, lastn, Gender, byear, bmonth, bday);
		this.Grade = grade;
		this.schoolName = sname;
	}
	
	public int getGrade() {
		return this.Grade;
	}
	
	public String getSchool() {
		return this.schoolName;
	}
	
	public void setGrade(int newGrade) {
		this.Grade = newGrade;
	}
	
	public void setSchool(String newSchool) {
		this.schoolName = newSchool;
	}
}
