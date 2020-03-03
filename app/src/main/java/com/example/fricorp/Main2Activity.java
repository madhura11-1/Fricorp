package com.example.fricorp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.HashMap;
import java.util.Map;

public class Main2Activity extends AppCompatActivity {

    EditText userID;
    EditText pwd;
    Button next;
    private FirebaseFirestore db;
    Spinner s_place;
    Spinner s_ambiance;
    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        final String userid = intent.getStringExtra("userid");

        userID = findViewById(R.id.edit_userId);
        userID.setText(userid);
        pwd = findViewById(R.id.edit_password);
        next = findViewById(R.id.next);
        mProgressBar = findViewById(R.id.progressBar2);
        mProgressBar.setVisibility(View.GONE);
        db = FirebaseFirestore.getInstance();

        String[] arraySpinner1 = new String[]{
                "Pune Institute of Computer Technology"
        };
        s_place = findViewById(R.id.spinner_3);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s_place.setAdapter(adapter1);
        String[] arraySpinner2 = new String[]{
                "Silent-1", "Noisy-5"
        };
        s_ambiance = findViewById(R.id.spinner_4);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s_ambiance.setAdapter(adapter2);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String password = pwd.getText().toString();
                if (password.isEmpty()) {
                    pwd.setError("Cannot be empty");
                    pwd.requestFocus();
                } else {
                    mProgressBar.setVisibility(View.VISIBLE);
                    db.collection("users").document(userid).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            if(password.equals(documentSnapshot.get("password"))){
                                Map<String, String> map = new HashMap<>();
                                map.put("place", s_place.getSelectedItem().toString() );
                                map.put("ambiance", s_ambiance.getSelectedItem().toString());
                                db.collection("users").document(userid).collection("tests").document().set(map)
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {
                                                Toast.makeText(Main2Activity.this, "DONE", Toast.LENGTH_SHORT).show();
                                                Intent intent1 = new Intent(Main2Activity.this, Main3Activity.class);
                                                mProgressBar.setVisibility(View.GONE);
                                                intent1.putExtra("userid", userid);
                                                startActivity(intent1);
                                                finish();
                                            }
                                        }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(Main2Activity.this, "FAILED", Toast.LENGTH_SHORT).show();
                                        mProgressBar.setVisibility(View.GONE);
                                    }
                                });
                            }else{
                                pwd.setError("INVALID PASSWORD");
                                pwd.setText("");
                                pwd.requestFocus();
                                mProgressBar.setVisibility(View.GONE);
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Main2Activity.this, "FAILED", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }

}
