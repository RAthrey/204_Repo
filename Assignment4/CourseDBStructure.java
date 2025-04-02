import java.io.IOException;
import java.util.*;
public class CourseDBStructure implements CourseDBStructureInterface {
    private LinkedList<CourseDBElement>[] hashTable;

    @SuppressWarnings("unchecked")
	public CourseDBStructure(int numElements) {
        int size = get4KPrime((int) (numElements / 1.5));
        hashTable = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            hashTable[i] = new LinkedList<>();
        }
    }

    @SuppressWarnings("unchecked")
	public CourseDBStructure(String test, int size) {
        hashTable = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            hashTable[i] = new LinkedList<>();
        }
    }

    public void add(CourseDBElement element) {
        int index = Math.abs(Integer.toString(element.getCRN()).hashCode() % hashTable.length);
        LinkedList<CourseDBElement> bucket = hashTable[index];
        if (!bucket.contains(element)) {
            bucket.add(element);
        }
    }

    @Override
    public CourseDBElement get(int crn) throws IOException {
        int index = Math.abs(Integer.toString(crn).hashCode() % hashTable.length);
        if (hashTable[index] != null) {
            for (CourseDBElement e : hashTable[index]) {
                if (e.getCRN() == crn) {
                    return e; 
                }
            }
        }
        throw new IOException("CRN: " + crn + " cannot be found!"); 
    }

    public ArrayList<String> showAll() {
        ArrayList<String> courses = new ArrayList<>();
        for (LinkedList<CourseDBElement> bucket : hashTable) {
            for (CourseDBElement e : bucket) {
                courses.add(e.toString());
            }
        }
        return courses;
    }

    public int getTableSize() {
        return hashTable.length;
    }

    public static int get4KPrime(int num) {
        while (true) {
            if (num % 4 == 3 && isPrime(num)) {
            	return num;
            }
            num++;
        }
    }

    private static boolean isPrime(int num) {
        if (num < 2) {
        	return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
            	return false;
            }
        }
        return true;
    }
}