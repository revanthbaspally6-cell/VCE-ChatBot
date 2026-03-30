package vasavichatbot;

import java.util.*;
import java.io.*;
import vasavichatbot.models.Faculty;

public class FacultyLoader {

    private static final String FILE_PATH = "data/faculty.dat";

    public static List<Faculty> loadFaculty() {
        List<Faculty> list = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(FILE_PATH);
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (List<Faculty>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            // ignore exceptions to avoid breaking the bot
        }
        return list;
    }

    /** 
     * FIXED: Now supports partial & case-insensitive matching 
     * e.g., "aruna" matches "Aruna Reddy", "Dr. Aruna", etc.
     */
    public static Faculty findByName(String name) {
        if (name == null) return null;

        String key = name.trim().toLowerCase();
        if (key.isEmpty()) return null;

        for (Faculty f : loadFaculty()) {
            if (f.getName() == null) continue;

            String storedName = f.getName().trim().toLowerCase();

            // exact match
            if (storedName.equals(key)) {
                return f;
            }

            // partial match (main fix)
            if (storedName.contains(key)) {
                return f;
            }
        }

        return null;
    }

    public static List<Faculty> findByDepartment(String dept) {
        List<Faculty> result = new ArrayList<>();
        if (dept == null) return result;

        for (Faculty f : loadFaculty()) {
            if (f.getDepartment() != null &&
                f.getDepartment().equalsIgnoreCase(dept)) {
                result.add(f);
            }
        }

        return result;
    }
}
