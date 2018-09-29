package project215;

public class InfoCriminal {

	private String name;
	private String age;
	private String crime;
	private String status;
	private String jail;
	
	public InfoCriminal() {
		name = "";
		age = "";
		crime = "";
		status ="";
		jail = "";
	}
	public InfoCriminal(String n,String a, String c, String s, String j) {
		name = n;
		age = a;
		crime = c;
		status = s;
		jail = j;
	}
	public void setName(String n) {
		name = n;
	}
	public void setAge(String a) {
		age = a;
	}
	public void setCrime(String c) {
		crime = c;
	}
	public void setStatus(String s) {
		status = s;
	}
	public void setJail(String j) {
		jail = j;
	}
	public String getName() {
		return name;
	}
	public String getCrime() {
		return crime;
	}
	public String getAge() {
		return age;
	}
	public String getStatus() {
		return status;
	}
	public String getJail() {
		return jail;
	}
}
