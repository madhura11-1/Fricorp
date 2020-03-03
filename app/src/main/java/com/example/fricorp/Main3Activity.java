package com.example.fricorp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;

public class Main3Activity extends AppCompatActivity {


    private ArrayList<String> female_high_arousal;
    private ArrayList<String> female_high_dominance;
    private ArrayList<String> female_high_valence;
    private ArrayList<String> female_low_arousal;
    private ArrayList<String> female_low_dominance;
    private ArrayList<String> female_low_velence;
    private ArrayList<String> values;
    private ArrayList<String> male_high_arousal,male_high_dominance,male_high_valence,male_low_arousal,male_low_dominance,male_low_valence;

    private boolean done = false;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        female_high_arousal = new ArrayList<>();
        female_high_dominance = new ArrayList<>();
        female_high_valence = new ArrayList<>();
        female_low_arousal = new ArrayList<>();

        female_low_velence = new ArrayList<>();
        female_low_dominance = new ArrayList<>();

        male_high_arousal = new ArrayList<>();
        male_high_dominance = new ArrayList<>();
        male_high_valence = new ArrayList<>();
        male_low_arousal =new ArrayList<>();
        male_low_dominance = new ArrayList<>();
        male_low_valence = new ArrayList<>();

        values = new ArrayList<>();


        Intent intent = getIntent();

        final String userid = intent.getStringExtra("userid");


        next = findViewById(R.id.next);

        next.setVisibility(View.INVISIBLE);

        fillArrayList();


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(Main3Activity.this, Main4Activity.class);
                intent1.putExtra("userid", userid);
                intent1.putStringArrayListExtra("values", values);
                startActivity(intent1);
                finish();

            }
        });
    }



    void fillArrayList() {



        male_high_arousal.add("1050");
        male_high_arousal.add("1120");
        male_high_arousal.add("2811");
        male_high_arousal.add("3000");
        male_high_arousal.add("3010");
        male_high_arousal.add("3053");
        male_high_arousal.add("3060");
        male_high_arousal.add("3069");
        male_high_arousal.add("3071");
        male_high_arousal.add("3080");
        male_high_arousal.add("3130");
        male_high_arousal.add("3170");
        male_high_arousal.add("3400");
        male_high_arousal.add("3500");
        male_high_arousal.add("5621");
        male_high_arousal.add("6230");
        male_high_arousal.add("6250");
        male_high_arousal.add("6260");
        male_high_arousal.add("6313");
        male_high_arousal.add("6350");
        male_high_arousal.add("6510");
        male_high_arousal.add("6550");
        male_high_arousal.add("6563");
        male_high_arousal.add("8030");
        male_high_arousal.add("8160");
        male_high_arousal.add("8179");
        male_high_arousal.add("8185");
        male_high_arousal.add("8492");
        male_high_arousal.add("9410");
        male_high_arousal.add("9940");

        male_high_dominance.add("1450");
        male_high_dominance.add("1500");
        male_high_dominance.add("1540");
        male_high_dominance.add("1600");
        male_high_dominance.add("1610");
        male_high_dominance.add("1620");
        male_high_dominance.add("2000");
        male_high_dominance.add("2040");
        male_high_dominance.add("2050");
        male_high_dominance.add("2058");
        male_high_dominance.add("2165");
        male_high_dominance.add("2260");
        male_high_dominance.add("5000");
        male_high_dominance.add("5010");
        male_high_dominance.add("5030");
        male_high_dominance.add("5500");
        male_high_dominance.add("5510");
        male_high_dominance.add("5750");
        male_high_dominance.add("5760");
        male_high_dominance.add("5779");
        male_high_dominance.add("7004");
        male_high_dominance.add("7010");
        male_high_dominance.add("7080");
        male_high_dominance.add("7090");
        male_high_dominance.add("7200");
        male_high_dominance.add("7240");
        male_high_dominance.add("7330");
        male_high_dominance.add("7350");
        male_high_dominance.add("7545");
        male_high_dominance.add("8531");

        male_high_valence.add("1440");
        male_high_valence.add("1441");
        male_high_valence.add("1460");
        male_high_valence.add("1710");
        male_high_valence.add("1750");
        male_high_valence.add("1920");
        male_high_valence.add("2030");
        male_high_valence.add("2040");
        male_high_valence.add("2050");
        male_high_valence.add("2070");
        male_high_valence.add("2080");
        male_high_valence.add("2154");
        male_high_valence.add("2260");
        male_high_valence.add("2340");
        male_high_valence.add("2398");
        male_high_valence.add("4250");
        male_high_valence.add("5210");
        male_high_valence.add("5700");
        male_high_valence.add("5760");
        male_high_valence.add("5825");
        male_high_valence.add("5833");
        male_high_valence.add("8080");
        male_high_valence.add("8170");
        male_high_valence.add("8190");
        male_high_valence.add("8300");
        male_high_valence.add("8370");
        male_high_valence.add("8420");
        male_high_valence.add("8470");
        male_high_valence.add("8499");
        male_high_valence.add("8501");
        male_high_valence.add("8510");

        male_low_arousal.add("7490");
        male_low_arousal.add("2190");
        male_low_arousal.add("2440");
        male_low_arousal.add("2840");
        male_low_arousal.add("5020");
        male_low_arousal.add("5130");
        male_low_arousal.add("5740");
        male_low_arousal.add("5800");
        male_low_arousal.add("7000");
        male_low_arousal.add("7004");
        male_low_arousal.add("7006");
        male_low_arousal.add("7010");
        male_low_arousal.add("7020");
        male_low_arousal.add("7026");
        male_low_arousal.add("7031");
        male_low_arousal.add("7041");
        male_low_arousal.add("7060");
        male_low_arousal.add("7080");
        male_low_arousal.add("7090");
        male_low_arousal.add("7110");
        male_low_arousal.add("7150");
        male_low_arousal.add("7175");
        male_low_arousal.add("7185");
        male_low_arousal.add("7187");
        male_low_arousal.add("7217");
        male_low_arousal.add("7490");
        male_low_arousal.add("7491");
        male_low_arousal.add("7900");
        male_low_arousal.add("7950");
        male_low_arousal.add("9360");

        male_low_dominance.add("1050");
        male_low_dominance.add("1304");
        male_low_dominance.add("3001");
        male_low_dominance.add("3010");
        male_low_dominance.add("3053");
        male_low_dominance.add("3060");
        male_low_dominance.add("3071");
        male_low_dominance.add("3080");
        male_low_dominance.add("3100");
        male_low_dominance.add("3102");
        male_low_dominance.add("3110");
        male_low_dominance.add("3131");
        male_low_dominance.add("3230");
        male_low_dominance.add("3500");
        male_low_dominance.add("3530");
        male_low_dominance.add("6230");
        male_low_dominance.add("6231");
        male_low_dominance.add("6250.2");
        male_low_dominance.add("6250");
        male_low_dominance.add("6510");
        male_low_dominance.add("6540");
        male_low_dominance.add("6560");
        male_low_dominance.add("9075");
        male_low_dominance.add("9600");
        male_low_dominance.add("9623");
        male_low_dominance.add("9630");
        male_low_dominance.add("9910");
        male_low_dominance.add("9920");
        male_low_dominance.add("9930");
        male_low_dominance.add("9940");

        male_low_valence.add("2095");
        male_low_valence.add("3000");
        male_low_valence.add("3001");
        male_low_valence.add("3005.1");
        male_low_valence.add("3015");
        male_low_valence.add("3053");
        male_low_valence.add("3060");
        male_low_valence.add("3064");
        male_low_valence.add("3069");
        male_low_valence.add("3071");
        male_low_valence.add("3080");
        male_low_valence.add("3100");
        male_low_valence.add("3102");
        male_low_valence.add("3110");
        male_low_valence.add("3120");
        male_low_valence.add("3130");
        male_low_valence.add("3131");
        male_low_valence.add("3168");
        male_low_valence.add("3170");
        male_low_valence.add("3225");
        male_low_valence.add("3266");
        male_low_valence.add("3350");
        male_low_valence.add("3530");
        male_low_valence.add("9040");
        male_low_valence.add("9183");
        male_low_valence.add("9405");
        male_low_valence.add("9520");
        male_low_valence.add("9560");
        male_low_valence.add("9570");
        male_low_valence.add("9940");


        female_high_arousal.add("1120");
        female_high_arousal.add("2811");
        female_high_arousal.add("3000");
        female_high_arousal.add("3010");
        female_high_arousal.add("3053");
        female_high_arousal.add("3060");
        female_high_arousal.add("3063");
        female_high_arousal.add("3064");
        female_high_arousal.add("3069");
        female_high_arousal.add("3080");
        female_high_arousal.add("3102");
        female_high_arousal.add("3120");
        female_high_arousal.add("3130");
        female_high_arousal.add("3170");
        female_high_arousal.add("3266");
        female_high_arousal.add("3400");
        female_high_arousal.add("3500");
        female_high_arousal.add("6230");
        female_high_arousal.add("6313");
        female_high_arousal.add("6350");
        female_high_arousal.add("6510");
        female_high_arousal.add("6520");
        female_high_arousal.add("6540");
        female_high_arousal.add("6550");
        female_high_arousal.add("8030");
        female_high_arousal.add("8185");
        female_high_arousal.add("8492");
        female_high_arousal.add("9410");
        female_high_arousal.add("9412");
        female_high_arousal.add("1120");


        female_high_dominance.add("1500");
        female_high_dominance.add("1602");
        female_high_dominance.add("1603");
        female_high_dominance.add("1604");
        female_high_dominance.add("1620");
        female_high_dominance.add("1999");
        female_high_dominance.add("2040");
        female_high_dominance.add("2050");
        female_high_dominance.add("2057");
        female_high_dominance.add("2070");
        female_high_dominance.add("2075");
        female_high_dominance.add("2080");
        female_high_dominance.add("2260");
        female_high_dominance.add("2320");
        female_high_dominance.add("2347");
        female_high_dominance.add("2360");
        female_high_dominance.add("2660");
        female_high_dominance.add("4641");
        female_high_dominance.add("5000");
        female_high_dominance.add("5030");
        female_high_dominance.add("5760");
        female_high_dominance.add("5779");
        female_high_dominance.add("5825");
        female_high_dominance.add("7035");
        female_high_dominance.add("7233");
        female_high_dominance.add("7281");
        female_high_dominance.add("7545");
        female_high_dominance.add("7900");
        female_high_dominance.add("8050");
        female_high_dominance.add("8510");

        female_high_valence.add("1441");
        female_high_valence.add("1460");
        female_high_valence.add("1610");
        female_high_valence.add("1710");
        female_high_valence.add("1750");
        female_high_valence.add("2040");
        female_high_valence.add("2045");
        female_high_valence.add("2050");
        female_high_valence.add("2057");
        female_high_valence.add("2070");
        female_high_valence.add("2071");
        female_high_valence.add("2091");
        female_high_valence.add("2150");
        female_high_valence.add("2154");
        female_high_valence.add("2160");
        female_high_valence.add("2165");
        female_high_valence.add("2260");
        female_high_valence.add("2340");
        female_high_valence.add("2347");
        female_high_valence.add("2360");
        female_high_valence.add("2388");
        female_high_valence.add("2395");
        female_high_valence.add("2550");
        female_high_valence.add("2660");
        female_high_valence.add("4622");
        female_high_valence.add("5210");
        female_high_valence.add("5760");
        female_high_valence.add("5830");
        female_high_valence.add("5910");
        female_high_valence.add("7502");


        female_low_arousal.add("2190");
        female_low_arousal.add("2381");
        female_low_arousal.add("2397");
        female_low_arousal.add("2480");
        female_low_arousal.add("2620");
        female_low_arousal.add("2840");
        female_low_arousal.add("5711");
        female_low_arousal.add("5726");
        female_low_arousal.add("5800");
        female_low_arousal.add("5870");
        female_low_arousal.add("7000");
        female_low_arousal.add("7004");
        female_low_arousal.add("7006");
        female_low_arousal.add("7010");
        female_low_arousal.add("7020");
        female_low_arousal.add("7026");
        female_low_arousal.add("7031");
        female_low_arousal.add("7041");
        female_low_arousal.add("7052");
        female_low_arousal.add("7059");
        female_low_arousal.add("7060");
        female_low_arousal.add("7110");
        female_low_arousal.add("7150");
        female_low_arousal.add("7175");
        female_low_arousal.add("7187");
        female_low_arousal.add("7217");
        female_low_arousal.add("7490");
        female_low_arousal.add("7491");
        female_low_arousal.add("7900");
        female_low_arousal.add("7950");


        female_low_dominance.add("3001");
        female_low_dominance.add("3010");
        female_low_dominance.add("3015");
        female_low_dominance.add("3059");
        female_low_dominance.add("3266");
        female_low_dominance.add("3500");
        female_low_dominance.add("6230");
        female_low_dominance.add("6231");
        female_low_dominance.add("6243");
        female_low_dominance.add("6250");
        female_low_dominance.add("6263");
        female_low_dominance.add("6300");
        female_low_dominance.add("6350");
        female_low_dominance.add("6370");
        female_low_dominance.add("6510");
        female_low_dominance.add("6520");
        female_low_dominance.add("6550");
        female_low_dominance.add("6560");
        female_low_dominance.add("6563");
        female_low_dominance.add("9075");
        female_low_dominance.add("9163");
        female_low_dominance.add("9183");
        female_low_dominance.add("9187");
        female_low_dominance.add("9410");
        female_low_dominance.add("9412");
        female_low_dominance.add("9413");
        female_low_dominance.add("9600");
        female_low_dominance.add("9908");
        female_low_dominance.add("9940");


        female_low_velence.add("2095");
        female_low_velence.add("2800");
        female_low_velence.add("3001");
        female_low_velence.add("3005");
        female_low_velence.add("3010");
        female_low_velence.add("3015");
        female_low_velence.add("3030");
        female_low_velence.add("3059");
        female_low_velence.add("3068");
        female_low_velence.add("3069");
        female_low_velence.add("3100");
        female_low_velence.add("3110");
        female_low_velence.add("3130");
        female_low_velence.add("3168");
        female_low_velence.add("3266");
        female_low_velence.add("3301");
        female_low_velence.add("3530");
        female_low_velence.add("6350");
        female_low_velence.add("9040");
        female_low_velence.add("9075");
        female_low_velence.add("9183");
        female_low_velence.add("9187");
        female_low_velence.add("9410");
        female_low_velence.add("9412");
        female_low_velence.add("9413");
        female_low_velence.add("9433");
        female_low_velence.add("9570");
        female_low_velence.add("9571");
        female_low_velence.add("9635");
        female_low_velence.add("9940");


        done = true;


        generateNumbers();

    }

    private void generateNumbers() {

        Random random = new Random();

     /*   values.add(female_high_arousal.get(random.nextInt(10)));
        values.add(female_high_arousal.get(random.nextInt(20)));
        values.add(female_high_arousal.get(random.nextInt(30)));
        values.add(female_high_dominance.get(random.nextInt(10)));
        values.add(female_high_dominance.get(random.nextInt(20)));
        values.add(female_high_dominance.get(random.nextInt(30)));
        values.add(female_high_valence.get(random.nextInt(10)));
        values.add(female_high_valence.get(random.nextInt(20)));
        values.add(female_high_valence.get(random.nextInt(30)));
        values.add(female_low_arousal.get(random.nextInt(10)));
        values.add(female_low_arousal.get(random.nextInt(20)));
        values.add(female_low_arousal.get(random.nextInt(30)));
        values.add(female_low_dominance.get(random.nextInt(9)));
        values.add(female_low_dominance.get(random.nextInt(19)));
        values.add(female_low_dominance.get(random.nextInt(29)));
        values.add(female_low_velence.get(random.nextInt(10)));
        values.add(female_low_velence.get(random.nextInt(20)));
        values.add(female_low_velence.get(random.nextInt(30)));*/

        values.add(male_high_valence.get(random.nextInt(10)));
        values.add(male_high_valence.get(random.nextInt(20)));
        values.add(male_high_valence.get(random.nextInt(30)));
        values.add(male_high_valence.get(random.nextInt(10)));
        values.add(male_high_valence.get(random.nextInt(20)));
        values.add(male_high_valence.get(random.nextInt(30)));
        values.add(male_high_valence.get(random.nextInt(10)));
        values.add(male_high_valence.get(random.nextInt(20)));
        values.add(male_high_valence.get(random.nextInt(30)));
        values.add(male_high_valence.get(random.nextInt(10)));
        values.add(male_high_valence.get(random.nextInt(20)));
        values.add(male_high_valence.get(random.nextInt(30)));
        values.add(male_high_valence.get(random.nextInt(9)));
        values.add(male_high_valence.get(random.nextInt(19)));
        values.add(male_high_valence.get(random.nextInt(29)));
        values.add(male_high_valence.get(random.nextInt(10)));
        values.add(male_high_valence.get(random.nextInt(20)));
        values.add(male_high_valence.get(random.nextInt(30)));

        next.setVisibility(View.VISIBLE);

    }


}
