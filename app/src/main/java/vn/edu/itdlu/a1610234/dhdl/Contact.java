package vn.edu.itdlu.a1610234.dhdl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Contact {
    private String mName;
    private boolean mOnline;

    public Contact(String name, boolean online) {
        mName = name;
        mOnline = online;
    }

    public String getName() {
        return mName;
    }

    public boolean isOnline() {
        return mOnline;
    }

    private static int lastContactId = 0;

    public static ArrayList<Contact> createContactsList(int numContacts) {
        ArrayList<Contact> contacts = new ArrayList<Contact>();

        for (int i = 1; i <= numContacts; i++) {
            contacts.add(new Contact("Person " + ++lastContactId, i <= numContacts / 2));
        }

        return contacts;
    }

    public static class AuthActivity extends AppCompatActivity {
        protected final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_auth);

            Button testButton = (Button) findViewById(R.id.button);

            testButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
    //                Log.i("1234567", "start");
                    Intent intent = new Intent(AuthActivity.this, MenuActivity.class);
    //                intent.putExtra(EXTRA_MESSAGE,"12345");
    //                startActivity(intent);
    //                Log.i("1234567", "end");
    //                new CustomAlertDialog(
    //                        AuthActivity.this,
    //                        "Wrong Password",
    //                        "OK",
    //                        null)
    //                        .show();
                    new SubjectsInfoDialog(
                            AuthActivity.this,
                            "MAS1334",
                            "Nguyen ly lap trinh huong doi tuong",
                            "bat buoc",
                            4).show();
                }
            });
        }

        private Button creatTable;
        private Button cancelDialog;
        private EditText etTableName;
    }
}
