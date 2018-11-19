package vn.edu.itdlu.a1610234.dhdl;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import vn.edu.itdlu.a1610234.dhdl.Home.HomeActivity;

public class MenuActivity extends AppCompatActivity {
    ArrayList<Contact> contacts;
    private Toolbar toolbar;
    private Spinner spinner_nav;
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        this.SetupContactAdapter();

        this.SetupMenuAdapter();
//        Log.i("1234567", "START");
//
//        // Get the message from the intent
//        Intent intent = getIntent();
//        String message = intent.getStringExtra(AuthActivity.EXTRA_MESSAGE);
//
//        // Create the text view
//        TextView textView = new TextView(this);
//        textView.setTextSize(40);
//        textView.setText(message);
//
//        // Set the text view as the activity layout
//        setContentView(textView);
//
//        Log.i("1234567", "END");
    }

    private LinearLayoutManager SetupLayoutManager(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        layoutManager.scrollToPosition(10);
        return layoutManager;
    }

    private void SetupContactAdapter(){
        RecyclerView contactRecycleView = findViewById(R.id.recycleView);
        contacts = Contact.createContactsList(15);
        ContactAdapter contactAdapter = new ContactAdapter(contacts);
        contactRecycleView.setAdapter(contactAdapter);
        contactRecycleView.setLayoutManager(this.SetupLayoutManager());
    }

    private void SetupMenuAdapter(){
        toolbar = findViewById(R.id.toolbar);
        spinner_nav = findViewById(R.id.spinner_nav);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        addItemsToSpinner();
    }

    public void addItemsToSpinner() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Top News");
        list.add("Movies");
        list.add("Video");
        list.add("Sports");
        list.add("Tech");

        MenuToolBarAdapter spinAdapter = new MenuToolBarAdapter(
                getApplicationContext(), list);
        spinner_nav.setAdapter(spinAdapter);
        spinner_nav.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapter, View v,
                                       int position, long id) {
                // Item selected
                String item = adapter.getItemAtPosition(position).toString();
                // Show Data
                Toast.makeText(getApplicationContext(), "Selected  : " + item,
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });

    }

    @SuppressLint("ResourceType")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        Intent intent = new Intent(MenuActivity.this, HomeActivity.class);
        switch (item.getItemId()) {
//            case R.id.new_game:
//                newGame();
//                return true;
//            case R.id.help:
//                showHelp();
//                return true;

            default:
                startActivity(intent);
                return super.onOptionsItemSelected(item);
        }
    }

}
