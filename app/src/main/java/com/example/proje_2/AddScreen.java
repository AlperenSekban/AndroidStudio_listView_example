package com.example.proje_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentProviderClient;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class AddScreen extends AppCompatActivity {
    EditText person;
    RadioButton man, woman, calisiyor, calismiyor;
    Button addBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_screen);
        defination();
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent();
                intent.putExtra(Utility.fullName,person.getText().toString());
                if(man.isChecked()){
                    intent.putExtra(Utility.gender,R.drawable.man);
                }
                else if(woman.isChecked()){
                    intent.putExtra(Utility.gender,R.drawable.woman);
                }
                if(calisiyor.isChecked()){
                    intent.putExtra(Utility.workingStatus,R.drawable.ic_action_calisiyor);
                }
                else if(calismiyor.isChecked()){
                    intent.putExtra(Utility.workingStatus,R.drawable.ic_action_calismiyor);
                }
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });



    }

    public void defination() {
        person = findViewById(R.id.person);
        man = findViewById(R.id.man);
        woman = findViewById(R.id.woman);
        calisiyor = findViewById(R.id.calisiyor);
        calismiyor = findViewById(R.id.calismiyor);
        addBtn = findViewById(R.id.addBtn);
    }
}