package com.assessment.saheed;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TestJavaRawHttpRequest {
    public static String performHttp(String url) throws URISyntaxException {
        HttpResponse<String> response = (HttpResponse<String>) HttpResponse.BodyHandlers.ofString();
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest requestProps = HttpRequest.newBuilder()
                    .uri(new URI(url)).build();
            response = client.send(requestProps, HttpResponse.BodyHandlers.ofString());
        }catch (Exception e) {
            e.printStackTrace();
        }
        return response.body();
    }
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
