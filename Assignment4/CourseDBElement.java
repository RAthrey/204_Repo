import java.io.*;
import java.util.*;

public class CourseDBElement {
    private String courseID;
    private int crn;
    private int credits;
    private String roomNum;
    private String instructor;

    public CourseDBElement() {}

    public CourseDBElement(String id, int crn, int credits, String roomNum, String instructor) {
        this.courseID = id;
        this.crn = crn;
        this.credits = credits;
        this.roomNum = roomNum;
        this.instructor = instructor;
    }

    public void setID(String id) { 
    	this.courseID = id;
    }
    public String getID() { 
    	return courseID; 
    }
    public void setCRN(int crn) { 
    	this.crn = crn;
    }
    public int getCRN() { 
    	return crn;
    }
    public void setCredits(int credits) { 
    	this.credits = credits; 
    }
    public int getCredits() { 
    	return credits;
    }
    public void setInstructor(String instructor) { 
    	this.instructor = instructor;
    }
    public String getInstructor() { 
    	return instructor; 
    }

    public void setRoomNum(String roomNum) { 
    	this.roomNum = roomNum; 
    }
    public String getRoomNum() {
    	return roomNum;
    }
    @Override
    public int hashCode() {
    	String key=Integer.toString(crn);
    	int sum = 0;
        for (int i=0;i< key.length();i++) {
            sum += (int) key.charAt(i);
        }        
        return sum;
    }
    @Override
    public boolean equals(Object obj) {
        CourseDBElement other = (CourseDBElement) obj;
        return this.crn == other.crn;
    }
    @Override
    public String toString() {
        return "Course:" + courseID + " CRN:" + crn + " Credits:" + credits +
                " Instructor:" + instructor + " Room:" + roomNum;
    }
}

