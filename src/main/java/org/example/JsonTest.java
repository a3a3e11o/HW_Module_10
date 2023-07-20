package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.List;

public class JsonTest {
    public static void main(String[] args) {
        try {
            List<User> users = Json.readUsersFromFile("files/file2.txt");
            Json.writeUsersToJsonFile(users, "files/user.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
