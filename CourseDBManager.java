import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * CourseDBManager Class
 * @author Talia Kouncar
 *
 */
public class CourseDBManager implements CourseDBManagerInterface {
	private CourseDBStructure courseDB;
	private CourseDBElement courseElement;
	private int maxSize;

	/**
	 * Constructor class, initialize variables
	 */
	public CourseDBManager() {
		maxSize = 20;
		courseDB = new CourseDBStructure(maxSize);
	}

	
	@Override
	/**
	 * adds a course with this new information to the coursedbsstructure
	 * @param courseId
	 * @param crn
	 * @param creditHours
	 * @param roomNumber
	 * @param instructorName
	 */
	public void add(String courseId, int crn, int creditHours, String roomNumber, String instructorName) {
	    if (courseDB != null) {
	        courseDB.add(new CourseDBElement(courseId, crn, creditHours, roomNumber, instructorName));
	    }
	}

	@Override
	/**
	 * based on the crn, it will find the coursedbelement
	 * @param crn
	 * @return
	 */
	public CourseDBElement get(int crn) {
		try {
			return courseDB.get(crn);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * reads course info from a tile and adds them to the coursedbstructure data structure
	 * @param inputFile
	 * @throws FileNotFoundException
	 */
	@SuppressWarnings("resource")
	@Override
	public void readFile(File inputFile) throws FileNotFoundException {
		Scanner fileScanner = new Scanner(inputFile);

		if (inputFile == null) {
			throw new FileNotFoundException();
		}

		while (fileScanner.hasNextLine()) {
			String[] courseInfo = fileScanner.nextLine().split(" ");
			add(courseInfo[0], Integer.parseInt(courseInfo[1]), Integer.parseInt(courseInfo[2]), courseInfo[3], courseInfo[4]);
		}
		fileScanner.close();
	}

	@Override
	/**
	 * returns an array list
	 */
	public ArrayList<String> showAll() {

		return courseDB.showAll();
	}
}