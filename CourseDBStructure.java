import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 
 * @author Talia Kouncar
 *
 */
public class CourseDBStructure implements CourseDBStructureInterface {
    private double loadFactor = 1.5;
    private int tableSize;
    private ArrayList<String> courseStrings;
    private int linkedListSize;
    private LinkedList<CourseDBElement>[] buckets;

    /**
     * constructor
     * @param na
     */
    public CourseDBStructure(int na) {
        linkedListSize = calculateTableSize(na, loadFactor);
        buckets = new LinkedList[linkedListSize];
        tableSize = 0;
        courseStrings = new ArrayList<>();
    }

    /**
     * 
     * @param str
     * @param na
     */
    public CourseDBStructure(String str, int na) {
        linkedListSize = na;
        buckets = new LinkedList[linkedListSize];
        tableSize = 0;
        courseStrings = new ArrayList<>();
    }

    @Override
    /**
     * @param element
     */
    public void add(CourseDBElement element) {
        boolean exists = false;
        int index = getElementHash(element);

        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
            courseStrings.add(element.toString());
        } else {
            for (int i = 0; i < buckets[index].size(); i++) {
                if (buckets[index].get(i).compareTo(element) == 0) {
                    buckets[index].set(i, element);
                    exists = true;
                }
            }
        }
        if (!exists) {
            buckets[index].add(element);
            tableSize++;
        }
    }

    @Override
    /**
     * @param crn
     */
    public CourseDBElement get(int crn) throws IOException {
        int index = getCRNHash(crn);

        if (buckets[index] != null) {
            for (int i = 0; i < buckets[index].size(); i++) {
                if (buckets[index].get(i).getCRN() == crn) {
                    return buckets[index].get(i);
                }
            }
        }
        throw new IOException();
    }

    @Override
    /**
     * 
     */
    public ArrayList<String> showAll() {
        ArrayList<String> courseStringsList = new ArrayList<>(tableSize);
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {
                for (int j = 0; j < buckets[i].size(); j++) {
                    courseStringsList.add(buckets[i].get(j).toString());
                }
            }
        }
        return courseStringsList;
    }

    @Override
    /**
     * 
     */
    public int getTableSize() {
        return linkedListSize;
    }

    /**
     * 
     * @param element
     * @return
     */
    public int getElementHash(CourseDBElement element) {
        Integer crnHash = element.getCRN();
        int index = crnHash.hashCode() % linkedListSize;
        return index;
    }

    /**
     * 
     * @param crn
     * @return
     */
    public int getCRNHash(int crn) {
        Integer crnString = crn;
        int index = crnString.hashCode() % linkedListSize;
        return index;
    }

    /**
     * 
     * @param an
     * @param loadFactor
     * @return
     */
    public static int calculateTableSize(int an, double loadFactor) {
        boolean isFourKPlus3 = false;
        boolean isPrime = false;
        int prime, highDivisor, d;

        prime = (int) (an / loadFactor);
        if (prime % 2 == 0) 
            prime = prime + 1;

        while (!isFourKPlus3) {
            while (!isPrime) {
                highDivisor = (int) (Math.sqrt(prime) + 0.5);
                for (d = highDivisor; d > 1; d--) {
                    if (prime % d == 0)
                        break; 
                }
                if (d != 1) 
                    prime = prime + 2;
                else
                    isPrime = true;
            }
            if ((prime - 3) % 4 == 0)
                isFourKPlus3 = true;
            else {
                prime = prime + 2;
                isPrime = false;
            }
        }
        return prime;
    }
}
