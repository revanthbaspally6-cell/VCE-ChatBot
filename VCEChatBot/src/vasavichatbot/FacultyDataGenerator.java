package vasavichatbot;

import vasavichatbot.models.Faculty;
import java.io.*;
import java.util.*;

public class FacultyDataGenerator {
    public static void main(String[] args) {
        List<Faculty> facultyList = new ArrayList<>();

        facultyList.add(new Faculty("F001", "Dr. Anil Kumar", "CSE", "anil.kumar@vasavi.edu.in", "9000000001"));
        facultyList.add(new Faculty("F002", "Dr. Sita Reddy", "ECE", "sita.reddy@vasavi.edu.in", "9000000002"));
        facultyList.add(new Faculty("F003", "Dr. Ravi Teja", "ME", "ravi.teja@vasavi.edu.in", "9000000003"));
        facultyList.add(new Faculty("F004", "Dr. Latha Devi", "CSE", "latha.devi@vasavi.edu.in", "9000000004"));
        facultyList.add(new Faculty("F005", "Dr. Sunil Varma", "EEE", "sunil.varma@vasavi.edu.in", "9000000005"));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/vasavichatbot/data/faculty.dat"))) {
            oos.writeObject(facultyList);
            System.out.println("faculty.dat generated successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
