package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Json {
    public static List<User> readUsersFromFile(String fileName) throws IOException {
        List<User> users = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            String[] headers = null;

            if ((line = reader.readLine()) != null) {
                headers = line.split(" ");
            }

            while ((line = reader.readLine()) != null) {
                String[] values = line.split(" ");

                if (values.length == headers.length) {
                    User user = new User(values[0], Integer.parseInt(values[1]));
                    users.add(user);
                }
            }
        }
        return users;
    }

    public static void writeUsersToJsonFile(List<User> users, String fileName) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(fileName)) {
            gson.toJson(users, writer);
        }
    }
}
