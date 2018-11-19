package vn.edu.itdlu.a1610234.dhdl.Auth;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import vn.edu.itdlu.a1610234.dhdl.Database.Student;
import vn.edu.itdlu.a1610234.dhdl.Database.StudentManager;
import vn.edu.itdlu.a1610234.dhdl.Home.MainActivity;
import vn.edu.itdlu.a1610234.dhdl.R;

public class AuthActivity extends AppCompatActivity {
    protected final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        Button testButton = (Button) findViewById(R.id.button);
        etId = (EditText) findViewById(R.id.etId);

        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AuthActivity.this, MainActivity.class);
                //                intent.putExtra(EXTRA_MESSAGE,"12345");
                startActivity(intent);
                //                Log.i("1234567", "end");
//                new CustomAlertDialog(
//                        AuthActivity.this,
//                        "Wrong Password",
//                        "OK",
//                        null)
//                        .show();

            }
        });

        Student student = new Student("1610234",
                "Dang Phuong Trung",
                "trungtrs1998@gmail.com",
                "Da lat",
                3,
                "trungtrs1998");
        studentManager.update(student);
//        Student  student =  studentManager.getStudent("1610234");

        etId.setText(student.getPassword());

    }

    private Button creatTable;
    private Button cancelDialog;
    private EditText etTableName;
    StudentManager studentManager = new StudentManager(this);
    private EditText etId;

}
