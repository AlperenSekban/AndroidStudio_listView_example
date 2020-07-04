package com.example.proje_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class EditScreen extends AppCompatActivity {

    TextView person;
    TextView gender;
    TextView workingStatus;
    Button delete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_screen);

        final Bundle bundle = getIntent().getExtras();
        defination();
        seting(bundle);
        delete(bundle);


    }

    public void delete(final Bundle bundle) {
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.putExtra(Utility.position,bundle.getInt(Utility.position));
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
    }

    public void seting(Bundle bundle) {
        person.setText(bundle.getString(Utility.fullName));
        if(bundle.getInt(Utility.gender)==R.drawable.man){
            gender.setText(R.string.common_man);
        }
        else if(bundle.getInt(Utility.gender)==R.drawable.woman){
            gender.setText(R.string.common_woman);
        }

        if(bundle.getInt(Utility.workingStatus)==R.drawable.ic_action_calismiyor){
            workingStatus.setText(R.string.common_notWorking);
        }
        else if(bundle.getInt(Utility.workingStatus)==R.drawable.ic_action_calisiyor){
            workingStatus.setText(R.string.common_working);
        }
    }

    public void defination() {
        person=findViewById(R.id.activity_edit_screen_fullName_textView);
        gender=findViewById(R.id.activity_edit_screen_gender_TextView);
        workingStatus=findViewById(R.id.activity_edit_screen_workingSatatus_TextView);
        delete=findViewById(R.id.activity_edit_screen_removePerson_button);
    }
}