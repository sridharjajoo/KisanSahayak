package com.example.sridh.kisansahayak;

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

/**
 * Created by sridh on 06-11-2016.
 */

public final class CommodityUtils
{

    private static final String LOG_TAG = CommodityUtils.class.getSimpleName();
    public ArrayList<KisanCommodity> fetchCommodityData(String requestUrl) {


        Log.i(LOG_TAG,"Inside fetch earth..................");



        // Create URL object
        URL url = createUrl(requestUrl);

        // Perform HTTP request to the URL and receive a JSON response back
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem making the HTTP request.", e);
        }

        // Extract relevant fields from the JSON response and create a list of {@link Earthquake}s
        ArrayList<KisanCommodity> commodity = extractJSONResponse(jsonResponse);


        // Return the list of {@link Earthquake}s
        return commodity;
    }


    public URL createUrl(String stringUrl) {

        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException exception) {

            Log.e( LOG_TAG,"Error with creating URL", exception);
            return null;
        }
        return url;
    }

    public String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = null;
        if(url==null){
            return jsonResponse;
        }

        else{

            HttpURLConnection urlConnection = null;
            InputStream inputStream = null;
            try {
                urlConnection = (HttpURLConnection) url.openConnection();

                urlConnection.setRequestMethod("GET");
                urlConnection.setReadTimeout(10000 /* milliseconds */);
                urlConnection.setConnectTimeout(15000 /* milliseconds */);
                urlConnection.connect();

                if(urlConnection.getResponseCode()==200){

                    inputStream = urlConnection.getInputStream();
                    jsonResponse = readFromStream(inputStream);}

                else{Log.e(LOG_TAG,"Error response code" + urlConnection.getResponseCode());
                }}

            catch (IOException e) {
                Log.e(LOG_TAG,"Problem receiving commodity response result",e);


            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (inputStream != null) {
                    // function must handle java.io.IOException here
                    inputStream.close();
                }
            }
            return jsonResponse;
        }}



    private String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);  //help us read text from the input stream
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }


    public static ArrayList<KisanCommodity> extractJSONResponse(String JSONResponse) {

        if (TextUtils.isEmpty(JSONResponse)) {
            return null;
        }

        ArrayList<KisanCommodity> earthquakes = new ArrayList<>(); //Creating an empty ArrayList

        try {

            JSONObject baseJsonResponse = new JSONObject(JSONResponse);
            JSONArray recordsArray =  baseJsonResponse.getJSONArray("records");

            for(int i=0;i<recordsArray.length();i++)
            {

                JSONObject currentrecord = recordsArray.getJSONObject(i);

                String state = currentrecord.getString("state");
                String market = currentrecord.getString("market");
                int min_price = currentrecord.getInt("min_price");
                int max_price = currentrecord.getInt("max_price");
                String commodity1 = currentrecord.getString("commodity");


                earthquakes.add(new KisanCommodity(state ,market ,min_price ,max_price ,commodity1));

            }



        }

        catch (JSONException e)
        {
            Log.e("CommodityUtils", "Problem parsing the earthquake JSON results", e);
        }

        // Return the list of earthquakes
        return earthquakes;
    }

}
