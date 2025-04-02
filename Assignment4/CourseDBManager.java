import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
public class CourseDBManager implements CourseDBManagerInterface {
    private CourseDBStructure courseStructure;

    public CourseDBManager() {
        courseStructure = new CourseDBStructure(100);
    }

    public void add(String id, int crn, int credits, String roomNum, String instructor) {
    	courseStructure.add(new CourseDBElement(id, crn, credits, roomNum, instructor));
    }

    public CourseDBElement get(int crn) {
    	try {
            return courseStructure.get(crn);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null; 	
        }
    }

    public ArrayList<String> showAll() {
        return courseStructure.showAll();
    }

    public void readFile(File input) throws FileNotFoundException {
        Scanner scanner = new Scanner(input);
        while (scanner.hasNextLine()) {
            String[] data = scanner.nextLine().split(" ");
            if (data.length >= 5) {
                String id = data[0];
                int crn = Integer.parseInt(data[1]);
                int credits = Integer.parseInt(data[2]);
                String roomNum = data[3];
                String instructor = "";
                for (int i = 4; i < data.length; i++) {
                    instructor += data[i] + " ";  
                }
                instructor = instructor.trim(); 
                
                add(id, crn, credits, roomNum, instructor);
            }
        }
        scanner.close();
    }

}
