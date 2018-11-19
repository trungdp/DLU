package vn.edu.itdlu.a1610234.dhdl.Home;

import android.support.v7.app.ActionBar;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import vn.edu.itdlu.a1610234.dhdl.R;

public class HomeActivity extends AppCompatActivity {
    private ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationView);
    }
}
