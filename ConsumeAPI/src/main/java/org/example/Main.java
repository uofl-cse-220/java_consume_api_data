package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        try {
            // Construct a URI (preferred approach)
            URI uri = new URI("https", "iu2mua5qjd.execute-api.us-east-1.amazonaws.com", "/prod/njruss01/test", null);

            // Convert URI to URL
            URL url = uri.toURL();

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");

            // Get the response code
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) { // HTTP OK
                // Read the response
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
                in.close();

                // Print the response (optional)
                System.out.println("Raw Response: " + response);

//                // Parse the JSON response into the User record
//                ObjectMapper mapper = new ObjectMapper();
//                User user = mapper.readValue(response.toString(), User.class);
//
//                // Print the User object
//                System.out.println("Parsed Response:");
//                System.out.println(user);
            } else {
                System.out.println("Failed to fetch data. HTTP Status: " + responseCode);
            }

            // Disconnect the connection
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
