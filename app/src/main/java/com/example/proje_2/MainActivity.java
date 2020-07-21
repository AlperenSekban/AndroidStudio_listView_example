package com.example.proje_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.widget.AdapterView.OnItemClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import static com.example.proje_2.R.drawable.ic_action_calismiyor;

public class MainActivity extends AppCompatActivity {


    ListView listView;
    List<KisiModel> kisiModels;
    PersonListAdapter adp;
    FloatingActionButton fabBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        defination();
        if (kisiModels == null) {
            createList();
        }

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            listView.setAdapter(adp);
        }

        fabBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAdd = new Intent(getApplicationContext(), AddScreen.class);
                startActivityForResult(intentAdd, Utility.requestCode_addScreen);
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intentEdit = new Intent(getApplicationContext(), EditScreen.class);
                intentEdit.putExtra(Utility.gender, kisiModels.get(i).getGender());
                intentEdit.putExtra(Utility.fullName, kisiModels.get(i).getPerson());
                intentEdit.putExtra(Utility.workingStatus, kisiModels.get(i).getWorkingstatus());
                intentEdit.putExtra(Utility.position, i);
                startActivityForResult(intentEdit, Utility.requestCode_editScreen);


            }
        });


    }


    protected void onActivityResult(int i, int j, Intent data) {

        super.onActivityResult(i, j, data);
        if (Utility.requestCode_editScreen == i) {
            if (j == Activity.RESULT_OK) {

                kisiModels.remove(data.getIntExtra(Utility.position, 0));
                listView.setAdapter(adp);


            }
        } else if (Utility.requestCode_addScreen == i) {
            if (j == Activity.RESULT_OK) {
                kisiModels.add(new KisiModel(data.getStringExtra(Utility.fullName), data.getIntExtra(Utility.gender, 0), data.getIntExtra(Utility.workingStatus, 0)));
                listView.setAdapter(adp);
            }
        }
    }


    public void defination() {

        listView = findViewById(R.id.activity_main_person_listView);
        fabBtn = findViewById(R.id.activity_main_add_floatActionButton);
    }

    public void createList() {

        kisiModels = new ArrayList<>();
        KisiModel k1 = new KisiModel("Alperen Sekban", R.drawable.man, ic_action_calismiyor);
        KisiModel k2 = new KisiModel("Derya Egeli", R.drawable.woman, R.drawable.ic_action_calisiyor);
        KisiModel k3 = new KisiModel("Recep Arslan", R.drawable.man, R.drawable.ic_action_calisiyor);
        KisiModel k4 = new KisiModel("Canan Kocadağ", R.drawable.woman, ic_action_calismiyor);
        KisiModel k5 = new KisiModel("Ahmet Çırak", R.drawable.man, ic_action_calismiyor);
        kisiModels.add(k1);
        kisiModels.add(k2);
        kisiModels.add(k3);
        kisiModels.add(k4);
        kisiModels.add(k5);
        adp = new PersonListAdapter(kisiModels, this);
        listView.setAdapter(adp);
    }


}