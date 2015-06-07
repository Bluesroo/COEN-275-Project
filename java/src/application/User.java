package application;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * Simply gets the username and password from the .credentials file.
 *
 * @author Joseph Pariseau
 */
final class User {
    static final private String PATH_TO_CREDENTIALS = "/Users/Mugen/Dev/COEN-275-Project/java/src/resources/.credentials";

    static String username() {
        FileReader credentialsFile;
        try {
            credentialsFile = new FileReader(PATH_TO_CREDENTIALS);
        } catch (Exception e) {
            e.printStackTrace();
            return "Issue opening file.";
        }

        BufferedReader credentialsBuffer = new BufferedReader(credentialsFile);
        String usernameLine = "";
        try {
            usernameLine = credentialsBuffer.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return usernameLine.split("=")[1];
    }

    static String password() {
        FileReader credentialsFile;
        try {
            credentialsFile = new FileReader(PATH_TO_CREDENTIALS);
        } catch (Exception e) {
            e.printStackTrace();
            return "Issue opening file.";
        }

        BufferedReader credentialsBuffer = new BufferedReader(credentialsFile);
        String passwordLine = "";
        try {
            passwordLine = credentialsBuffer.readLine();
            passwordLine = credentialsBuffer.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return passwordLine.split("=")[1];
    }
}
