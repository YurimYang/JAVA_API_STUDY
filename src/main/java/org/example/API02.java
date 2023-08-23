package org.example;

import org.json.*;

import java.io.FileReader;
import java.io.IOException;

public class API02 {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("books.json");
            StringBuilder jsonString = new StringBuilder();
            int character;
            while ((character = reader.read()) != -1) {
                jsonString.append((char) character);
            }
            reader.close();
            JSONObject jsonObject = new JSONObject(jsonString.toString());
            JSONArray booksArray = jsonObject.getJSONArray("books");
            for (int i = 0; i < booksArray.length(); i++) {
                JSONObject bookObject = booksArray.getJSONObject(i);
                String title = bookObject.getString("title");
                String company = bookObject.getString("company");
                String name = bookObject.getString("name");
                int price = bookObject.getInt("price");
                System.out.println("Title: " + title);
                System.out.println("Company: " + company);
                System.out.println("Name: " + name);
                System.out.println("Price: " + price);
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
