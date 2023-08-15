package seven;

public class Adult extends Human{
	String Occupation = "";
	String Workplace = "";
	
	public Adult(String fname, String lastn, String Gender, int byear, int bmonth, int bday, String Occu, String workp) {
		super(fname, lastn, Gender, byear, bmonth, bday);
		this.Occupation = Occu;
		this.Workplace = workp;
	}
	
	public String getOccupation() {
		return this.Occupation;
	}
	
	public String getWorkplace() {
		return this.Workplace;
	}
	
	public void setOccupation(String newoccu) {
		this.Occupation = newoccu;
	}
	
	public void setWorkplace(String newwork) {
		this.Workplace = newwork;
	}
	
}
