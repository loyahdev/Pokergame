package seven;

public class CentennialStudent extends Youth{
	String Classe = "";
	String Teach = "";
	static String school = "Centennial High School";
	
	public CentennialStudent(String fname, String lastn, String Gender, int byear, int bmonth, int bday, int grade, String homeR, String teech) {
		super(fname, lastn, Gender, byear, bmonth, bday, grade, school);
		this.Classe = homeR;
		this.Teach = teech;
	}
	
	public void setSchool(String newSchool) {
		this.schoolName = "Centennial High School";
	}
	
	public String getClasse() {
		return this.Classe;
	}
	
	public String getTeacher() {
		return this.Teach;
	}
	
	public void setClasse(String Clase) {
		this.Classe = Clase;
	}
	
	public void setTeacher(String Teacher) {
		this.Teach = Teacher;
	}
	
}
