import java.util.LinkedList;
import java.util.Objects;

public class CourseDBElement implements Comparable<CourseDBElement> {

	/**
	 * @author Talia Kouncar
	 */
	private String ID;
	private int CRN;
	private int NoOfCredits;
	private String RoomNum;
	private String InstructorName;

	/**
	 * Constructor class
	 */
	public CourseDBElement() {
		this.ID = null;
		this.CRN = 0;
		this.NoOfCredits = 0;
		this.RoomNum = null;
		this.InstructorName = null;
	}

	/**
	 * 
	 * @param courseID
	 * @param crn
	 * @param numOfCred
	 * @param roomN
	 * @param instructorName
	 */
	public CourseDBElement(String iD, int crn, int numofCred, String roomNum, String instructorName) {
		this.ID = iD;
		this.CRN = crn;
		this.NoOfCredits = numofCred;
		this.RoomNum = roomNum;
		this.InstructorName = instructorName;
	}

	/**
	 * getter
	 * 
	 * @return ID
	 */
	public String getID() {
		return ID;
	}

	/**
	 * setter
	 * 
	 * @param iD
	 */
	public void setID(String iD) {
		ID = iD;
	}

	/**
	 * getter
	 * 
	 * @return CRN
	 */
	public int getCRN() {
		return CRN;
	}

	/**
	 * setter
	 * 
	 * @param cRN
	 */
	public void setCRN(int crn) {
		CRN = crn;
	}

	/**
	 * getter
	 * 
	 * @return NofCredits
	 */
	public int getNofCredits() {
		return NoOfCredits;
	}

	/**
	 * setter
	 * 
	 * @param nofCredits
	 */
	public void setNofCredits(int numofCred) {
		NoOfCredits = numofCred;
	}

	/**
	 * getter
	 * 
	 * @return RoomNum
	 */
	public String getRoomNum() {
		return RoomNum;
	}

	/**
	 * setter
	 * 
	 * @param roomNum
	 */
	public void setRoomNum(String roomNum) {
		RoomNum = roomNum;
	}

	/**
	 * getter
	 * 
	 * @return InstructorName
	 */
	public String getInstructorName() {
		return InstructorName;
	}

	/**
	 * setter
	 * 
	 * @param instructorName
	 */
	public void setInstructorName(String instructorName) {
		InstructorName = instructorName;
	}

	@Override
	/**
	 * @param element
	 */
	public int compareTo(CourseDBElement element) {
		switch (Integer.compare(this.CRN, element.getCRN())) {
		case 0:
			return 0;
		case 1:
			return 1;
		default:
			return -1;
		}
	}

	@Override
	/**
	 * toString method
	 */
	public String toString() {
		return "\nCourse:" + this.ID + " CRN:" + this.CRN + " Credits:" + this.NoOfCredits + " Instructor:"
				+ this.InstructorName + " Room:" + this.RoomNum;
	}
}