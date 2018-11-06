package com.monyert.studentswork2;

import android.app.Notification;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.text.BreakIterator;

public class PrimeNumberActivity extends MainMenu implements NavigationView.OnNavigationItemSelectedListener {


    static TextView resultField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prime_number);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_prime);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        resultField = findViewById(R.id.text_resultado_numero_primo);
    }

    public void primeCheckWithAsyncTask(View view) {

        long parameter = Long.parseLong(String.valueOf(R.id.text_input));
        MyAsyncTaskPrime mAsyncTask = new MyAsyncTaskPrime();
        mAsyncTask.execute(parameter);
    }


    public class MyAsyncTaskPrime extends AsyncTask<Long, Integer, Boolean> {
        protected void onPreExecute() {
            PrimeNumberActivity.resultField.setText("Starting");
        }

        protected Boolean doInBackground(Long... n) {
            // Calling to the isPrime(…) method
            //TODO
            return false;
        }

        protected void onProgressUpdate(Integer... progress) {
            PrimeNumberActivity.resultField.setText((progress[0] * 10) + "% completed");
        }

        protected void onPostExecute(Boolean isPrime) {
            if (isPrime) PrimeNumberActivity.resultField.setText("Yes");
            else PrimeNumberActivity.resultField.setText("No");
        }

        private boolean isPrime(Long n) {
            // TODO }
            return false;
        }
    }
}
