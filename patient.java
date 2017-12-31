import java.io.Serializable;
import java.util.Date;

class patient implements Serializable {

	private static final long serialVersionUID=1L;

	static double fee;
	static int callNumberTracker;

	int callNumber;
	String name;
	String problem;
	Date date;
	String contactNumber;

	public patient(String name,String problem,String contactNumber) {
		
		//this.callNumber=++callNumberTracker;
		this.name=name;
		this.problem=problem;
		this.date= new Date();
		this.contactNumber=contactNumber;
	}

	public String toString() {
		//DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		return "Name: "+name+"\nProblem: "+problem+"\nDate of admission: "+date.toString()+"\nContact number: "+contactNumber;
	}
}