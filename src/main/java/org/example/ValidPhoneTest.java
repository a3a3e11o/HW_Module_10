package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ValidPhoneTest {
    public static void main(String[] args) {
        File file = new File("files/file1.txt");
        System.out.println("File exists: " + file.exists());

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String str = String.valueOf(scanner.nextLine());
                if (str.strip().matches("\\d{3}-\\d{3}-\\d{4}") || str.strip().matches("\\(\\d{3}\\) \\d{3}-\\d{4}")) {
                    System.out.println(str.strip());
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}