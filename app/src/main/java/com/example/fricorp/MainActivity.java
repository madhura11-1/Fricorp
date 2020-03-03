package com.example.fricorp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.MediaRouteButton;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewDebug;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText age;
    EditText userId;
    private static final String TAG = "MainActivity";
    EditText pwd;
    FirebaseFirestore db;

    Spinner s_type;
    Spinner s_gender;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = FirebaseFirestore.getInstance();

        String[] arraySpinner_type = new String[]{
                "Teacher", "Student"
        };

        name = findViewById(R.id.edit_name);
        age = findViewById(R.id.edit_age);
        pwd = findViewById(R.id.edit_password);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);

        userId = findViewById(R.id.edit_userId);


        s_gender = findViewById(R.id.spinner_gender);


        ArrayAdapter<String> adapter_gender = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, new String[]{"Male", "Female"});
        adapter_gender.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s_gender.setAdapter(adapter_gender);


        s_type = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner_type);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s_type.setAdapter(adapter);


        String[] arraySpinner_place = new String[]{
                "Pune Institute of Computer Technology"
        };
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner_place);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        String[] arraySpinner_ambiance = new String[]{
                "Silent-1", "Noisy-5"
        };
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner_ambiance);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        Button next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (name.getText().toString().isEmpty()) {
                    name.setError("Cannot be empty");
                    name.requestFocus();

                }else if(age.getText().toString().isEmpty())
                {
                    pwd.setError("Cannot be Empty");
                    pwd.requestFocus();
                }
                else if (pwd.getText().toString().isEmpty()) {
                    pwd.setError("Cannot be empty");
                    pwd.requestFocus();
                } else {
                    db.collection("users").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        private int flag = 0;

                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                            for (QueryDocumentSnapshot document : queryDocumentSnapshots) {
                                Log.d(TAG, "onSuccess:  USER IDS : "+document.getId());
                                if (document.getId().equals(userId.getText().toString())) {
                                    userId.setError("USER ID ALREADY EXISTS");
                                    flag = 1;
                                    break;
                                }
                            }
                            if (flag == 0)
                                createUser();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(MainActivity.this, "FAILED", Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    });
                }
            }
        });
    }

    private void createUser() {

        String Name = name.getText().toString();
        Integer Age = Integer.valueOf(age.getText().toString());
        final String userid = userId.getText().toString();
        String password = pwd.getText().toString();
        String gender = s_gender.getSelectedItem().toString();
        String type = s_type.getSelectedItem().toString();

        User user = new User(Name, Age, gender, userid, password, type);
        progressBar.setVisibility(View.VISIBLE);
        db.collection("users").document(userid).set(user).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this, "DB FAILED", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            }
        }).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(MainActivity.this, "UPLOADED TO DB", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("userid", userid);
                startActivity(intent);
                finish();
            }
        });


    }
}

