package com.example.fricorp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Main4Activity extends AppCompatActivity {


    private StorageReference mStorageRef;
    private FirebaseStorage mStorage;
    private ImageView mImageView;
    String gender;
    ArrayList<String> values;
    Integer i;
    User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Intent intent = getIntent();
        String userid = intent.getStringExtra("userid");

        values = intent.getStringArrayListExtra("values");
        mStorageRef = FirebaseStorage.getInstance().getReference();
        mStorage = FirebaseStorage.getInstance();
        mImageView = findViewById(R.id.image_view);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("users").document(userid).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                gender = documentSnapshot.getString("gender");
            }
        });


        final int[] i = {0};


        delay(i);


    }


    void delay(final int[] i) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                display(i);

            }
        }, 6000);
    }


    void display(final int[] i) {
        String kind;
        if (i[0] < 3) {
            kind = "high_valence";
        } else if (i[0] < 6) {
            kind = "high_valence";
        } else if (i[0] < 9) {
            kind = "high_valence";
        } else if (i[0] < 12) {
            kind = "high_valence";
        } else if (i[0] < 15) {
            kind = "high_valence";
        } else {
            kind = "high_valence";
        }


        Toast.makeText(Main4Activity.this, values.get(i[0]) + " : " + kind, Toast.LENGTH_LONG).show();

        mStorageRef.child("Male").child(kind).child(values.get(i[0]) + ".jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                //  Toast.makeText(Main4Activity.this, uri.toString(), Toast.LENGTH_LONG).show();
                Picasso.with(getApplicationContext()).load(uri)
                        /*.centerCrop()*/
                        .rotate(90)
                        .fit()
                        .into(mImageView);


            }
        }).addOnCompleteListener(new OnCompleteListener<Uri>() {
            @Override
            public void onComplete(@NonNull Task<Uri> task) {
                i[0]++;


                if (i[0] < 18) {
                    Toast.makeText(Main4Activity.this, "VALUE of i = " + i[0], Toast.LENGTH_SHORT).show();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            display(i);

                        }
                    }, 6000);
                }

            }
        })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Main4Activity.this, "unable to download" + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });

    }
}


 /*       String kind = "high_arousal";
        String kind;
        for (int i = 0; i < 18; i++) {
            if (i < 3) {
                kind = "high_arousal";
            } else if (i < 6) {
                kind = "high_dominance";
            } else if (i < 9) {
                kind = "high_valence";
            } else if (i < 12) {
                kind = "low_arousal";
            } else if (i < 15) {
                kind = "low_dominance";
            } else {
                kind = "low_valence";
            }*/

        /*Random random = new Random();
        i = random.nextInt(2);
        mStorageRef.child("Male").child("high_valence").child(values.get(i) + ".jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Toast.makeText(Main4Activity.this, uri.toString(), Toast.LENGTH_LONG).show();
                Picasso.with(getApplicationContext()).load(uri)
                        .centerCrop()
                        .rotate(90)
                        .fit()
                        .into(mImageView);
            }
        })
                .addOnFailureListener(
                        new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Main4Activity.this, "unable to download", Toast.LENGTH_SHORT).show();
                            }
                        });

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                i = random.nextInt(9);
                mStorageRef.child("Male").child("high_valence").child(values.get(i) + ".jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        Toast.makeText(Main4Activity.this, uri.toString(), Toast.LENGTH_LONG).show();
                        Picasso.with(getApplicationContext()).load(uri)
                                .centerCrop()
                                .rotate(90)
                                .fit()
                                .into(mImageView);
                    }
                })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(Main4Activity.this, "unable to download", Toast.LENGTH_SHORT).show();
                                    }
                                });
            }
        }, 6000);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                i = random.nextInt(5);
                mStorageRef.child("Male").child("high_valence").child(values.get(i) + ".jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        Toast.makeText(Main4Activity.this, uri.toString(), Toast.LENGTH_LONG).show();
                        Picasso.with(getApplicationContext()).load(uri)
                                .centerCrop()
                                .rotate(90)
                                .fit()
                                .into(mImageView);
                    }
                })
                        .addOnFailureListener(
                                new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(Main4Activity.this, "unable to download", Toast.LENGTH_SHORT).show();
                                    }
                                });
            }
        }, 6000);
    }
        }*/


/*}
* mHandler.postDelayed(new Runnable() {
                    Random random = new Random();
                    Integer x1 = random.nextInt(6);
                    String sx1 = Integer.toString(x1);

                    @Override
                    public void run() {
                        st.child("images").child(sx1 + ".png").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {

                                Toast.makeText(Main2Activity.this, uri.toString(), Toast.LENGTH_LONG).show();
                                Picasso.with(getApplicationContext()).load(uri).into(imgst);
                            }
                        })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(Main2Activity.this, "unable to download", Toast.LENGTH_SHORT).show();
                                    }
                                });
                    }

                }, 9000);*/
