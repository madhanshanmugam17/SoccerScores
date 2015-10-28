package com.madhan.soccerscores;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.madhan.soccerscores.Models.Fixture;
import com.madhan.soccerscores.Models.TeamFixtures;

import java.util.ArrayList;
import java.util.List;

import adapter.SimpleArrayAdapter;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class FixturesActivity extends ActionBarActivity {

    List<Fixture> fixtureList;
    ListView listView ;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixtures);

        listView = (ListView) findViewById(R.id.list);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();




            Call<TeamFixtures> call = ApiClient.getHDBackendApiClient().getFixtures();
            call.enqueue(new Callback<TeamFixtures>() {


                @Override
                public void onResponse(Response<TeamFixtures> response, Retrofit retrofit) {


                    if (response.body() != null) {
                        List<Fixture> fixtures = response.body().getFixtures();
                        fixtureList = response.body().getFixtures();
                        SimpleArrayAdapter adapt = new SimpleArrayAdapter(getApplicationContext(), fixtureList);
                        listView.setAdapter(adapt);
                        progressDialog.dismiss();
                    } else {
                        Toast.makeText(getApplicationContext(), "No data from server", Toast.LENGTH_LONG).show();
                        progressDialog.dismiss();
                    }


                }

                @Override
                public void onFailure(Throwable t) {
                    progressDialog.dismiss();
                    Log.v(t.getLocalizedMessage(), "Error");
                }
            });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fixtures, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
