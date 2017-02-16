package com.example.sridh.kisansahayak;

/**
 * Created by SatyamBansal on 06-11-2016.
 */

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;



public final class WebUtils {



    private WebUtils() {
    }


    public static List<Weather> extractEarthquakes(String URL) {

        URL url = createURL(URL);
        String jsonResponse = null;

        try {
            jsonResponse = makeHttpRequest(url);

        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Weather> data = extractDataFromJSON(jsonResponse);
        return data;

    }






    private static URL createURL(String u){

        URL urlObject = null;


        try {
            urlObject = new URL(u);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return urlObject;
    }

    private static String makeHttpRequest(URL url) throws IOException {

        String jsonResponse = "";
        if (url == null) {
            return jsonResponse;
        }
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;

        try {
            urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.setReadTimeout(10000);
            urlConnection.setConnectTimeout(15000);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            if(urlConnection.getResponseCode() == 200){
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(urlConnection!=null){
                urlConnection.disconnect();
            }
            if(inputStream!=null){
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    private static String readFromStream(InputStream inputStream) throws IOException {

        StringBuilder builder = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                builder.append(line);
                line = reader.readLine();
            }
        }
        return builder.toString();
    }

    private static List<Weather> extractDataFromJSON(String jsonResponse){

        // Create an empty ArrayList that we can start adding weatherData to

        if(TextUtils.isEmpty(jsonResponse)){
            return null;
        }
        List<Weather> weatherData = new ArrayList<>();

        // Try to parse the SAMPLE_JSON_RESPONSE. If there's a problem with the way the JSON
        // is formatted, a JSONException exception object will be thrown.
        // Catch the exception so the app doesn't crash, and print the error message to the logs.
        try {
            JSONObject rootObject = new JSONObject(jsonResponse);
            JSONArray featureArray = rootObject.getJSONArray("list");
            for(int i =0 ; i< 5 ; i++){
                JSONObject jsonObject = featureArray.getJSONObject(i);
                JSONObject temperature = jsonObject.getJSONObject("temp");
                long time = jsonObject.getLong("dt");

                double minTemp = temperature.getDouble("min") - 273.15;

                double maxTemp = temperature.getDouble("max") -273.15 ;
                JSONArray weatherArray = jsonObject.getJSONArray("weather");
                JSONObject weatherObject = weatherArray.getJSONObject(0);
                String description = weatherObject.getString("description");




                weatherData.add(new Weather(minTemp,maxTemp,description,time));
            }
            // build up a list of Earthquake objects with the corresponding data.

        } catch (JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e("WebUtils", "Problem parsing the Weather JSON results", e);
        }

        // Return the list of weatherData
        return weatherData;

    }
}
