import static org.junit.Assert.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Talia
 *
 */

public class CourseDBManager_STUDENT_Test {
	private CourseDBManagerInterface dataManag = new CourseDBManager();
	
	/**
	 * Create an instance of CourseDBManager
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		dataManag  = new CourseDBManager();
	}

	/**
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		dataManag  = null;
	}

	/**
	 * add method test
	 */
	@Test
	public void testAddToDB() {
		try {
			dataManag .add("ENEE204",53342,3,"SW320","Blake Senior");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
	/**
	 * showAll method test
	 */
	@Test
	public void testShowAll() { 
		dataManag.add("ENEE204",53342,3,"SW320","Blake Senior");
		dataManag.add("ENEE222",25534,4,"SW202","P Catravas");
		dataManag.add("CMSC204",10043,4,"SW214","Tarek");
		ArrayList<String> list = dataManag.showAll();
		assertEquals(list.get(0),"\nCourse:ENEE204 CRN:53342 Credits:3 Instructor:Blake Senior Room:SW320");
	 	assertEquals(list.get(1),"\nCourse:CMSC204 CRN:10043 Credits:4 Instructor:Tarek Room:SW214");
		assertEquals(list.get(2),"\nCourse:ENEE222 CRN:25534 Credits:4 Instructor:P Catravas Room:SW202");
	}
	
	/**
	 * read method test
	 */
	@Test
	public void testRead() {
		try {
			File inputFile = new File("Test.testtead.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("ENEE204 53342 3 SW320 Blake Senior");
			inFile.print("CMSC204 10043 4 SW214 Tarek");
			
			inFile.close();
			dataManag.readFile(inputFile);
			assertEquals("ENEE204",dataManag.get(53342).getID());
			assertEquals("CMSC204",dataManag.get(10043).getID());
			assertEquals("SW214",dataManag.get(10043).getRoomNum());
			assertEquals("Tarek",dataManag.get(10043).getInstructorName());
			assertEquals("SW320",dataManag.get(53342).getRoomNum());

		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
}
