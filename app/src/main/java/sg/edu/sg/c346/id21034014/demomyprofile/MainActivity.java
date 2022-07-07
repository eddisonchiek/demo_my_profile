package sg.edu.sg.c346.id21034014.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etName;
    EditText etGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);
    }

    @Override
    protected void onPause() {
        super.onPause();
        String strName = etName.getText().toString();
        float GPA = Float.parseFloat(etGPA.getText().toString());

        SharedPreferences prefs =  getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putString("name",strName);
        prefEdit.putFloat("gpa",GPA);

        prefEdit.commit();

    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        String strName = prefs.getString("name","john");
        float GPA = prefs.getFloat("gpa",0);
        etName.setText(strName);
        etGPA.setText(GPA + "");
    }
}