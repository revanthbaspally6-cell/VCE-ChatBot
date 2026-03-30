package vasavichatbot;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileUtils {

    private static final Path DATA_DIR = Paths.get("data");
    private static final Path USERS_FILE = DATA_DIR.resolve("users.dat");
    private static final Path FACULTY_FILE = DATA_DIR.resolve("faculty.dat");

    static {
        try {
            if (!Files.exists(DATA_DIR)) Files.createDirectories(DATA_DIR);
            if (!Files.exists(USERS_FILE)) Files.createFile(USERS_FILE);
            if (!Files.exists(FACULTY_FILE)) Files.createFile(FACULTY_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Save username|password
    public static synchronized boolean saveUser(String username, String password) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(USERS_FILE.toFile(), true))) {
            bw.write(username + "|" + password);
            bw.newLine();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static synchronized boolean userExists(String username) {
        try (BufferedReader br = new BufferedReader(new FileReader(USERS_FILE.toFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split("\\|");
                if (arr.length >= 2 && arr[0].equals(username)) return true;
            }
        } catch (IOException ignored) {}
        return false;
    }

    public static synchronized boolean validateUser(String username, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader(USERS_FILE.toFile()))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split("\\|");
                if (arr.length >= 2 && arr[0].equals(username) && arr[1].equals(password))
                    return true;
            }
        } catch (IOException ignored) {}
        return false;
    }

    // Optional: raw faculty text helpers
    public static List<String> readFacultyRaw() {
        List<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FACULTY_FILE.toFile()))) {
            String line;
            while ((line = br.readLine()) != null) list.add(line);
        } catch (IOException ignored) {}
        return list;
    }

    public static void appendFacultyRecord(String record) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FACULTY_FILE.toFile(), true))) {
            bw.write(record);
            bw.newLine();
        } catch (IOException ignored) {}
    }
}
