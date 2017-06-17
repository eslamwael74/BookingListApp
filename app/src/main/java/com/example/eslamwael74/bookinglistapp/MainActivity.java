package com.example.eslamwael74.bookinglistapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Book> bookList = new ArrayList<>();
    ListView listView;
    RecyclerView mRecyclerView;
    RecyclerViewAdapter adapter;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);


        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new readJSON().execute("https://www.googleapis.com/books/v1/volumes?q=android");
            }
        });

    }

    class readJSON extends AsyncTask<String,Integer,String> {


        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... params) {
            return readURL(params[0]);
        }

        @Override
        protected void onPostExecute(String content) {
            progressBar.setVisibility(View.GONE);
            try {
                JSONObject jsonObject = new JSONObject(content);
                JSONArray jsonArray = jsonObject.getJSONArray   ("items");

                    for (int i=0; i<jsonArray.length(); i++) {

                        Book book = new Book();
                        JSONObject item = jsonArray.getJSONObject(i);
                        JSONObject volInfo = item.getJSONObject("volumeInfo");
                        String title = volInfo.getString("title");
                        String subTitle ="";
                        try {
                            subTitle = volInfo.getString("subtitle");
                        }
                        catch (Exception e){}
                        String publishedDate = volInfo.getString("publishedDate");
                        JSONObject imageLinks = new JSONObject(volInfo.getString("imageLinks"));
                        String smallThumbnail = imageLinks.getString("smallThumbnail");
                        JSONArray jsonArrayAuthors = volInfo.getJSONArray("authors");
                        String author = jsonArrayAuthors.getString(0);
                        book.setAuthor(author);
                        //String[] arr = new String[jsonArrayAuthors.length()];
                        //ArrayList<String> author = new ArrayList<>();
                        // for(int j=0; j<arr.length; j++){
                        //author.add(arr[j]);
                   // }

                    bookList.add(new Book(
                            smallThumbnail,
                            title,
                            subTitle,
                            author,
                            publishedDate

                    ));
                }


            } catch (JSONException e) {
                e.printStackTrace();
            }
            //Toast.makeText(getApplicationContext(),arrayList.size(),Toast.LENGTH_SHORT).show();
            if(content != null){

                adapter = new RecyclerViewAdapter(MainActivity.this,bookList);
                mRecyclerView.setAdapter(adapter);

            }
            else{
                Toast.makeText(MainActivity.this, "Failed to fetch data!", Toast.LENGTH_SHORT).show();
            }


        }
    }

    private static String readURL(String theUrl) {
        StringBuilder content = new StringBuilder();
        try {
            // create a url object
            URL url = new URL(theUrl);
            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();
            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}
