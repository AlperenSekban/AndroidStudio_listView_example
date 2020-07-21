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
import android.widget.Toast;

public class AddScreen extends AppCompatActivity {
    EditText person;
    RadioButton man, woman, calisiyor, calismiyor;
    Button addBtn;
    RadioGroup rGGender, rGworkingStatus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_screen);
        defination();
        addButtonClick();


    }

    private void addButtonClick() {
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (person.getText().toString().isEmpty() || !(isSelected(rGGender)) || !(isSelected(rGworkingStatus))) {
                    Toast.makeText(getApplicationContext(), R.string.activity_add_screen_warningMessage, Toast.LENGTH_SHORT).show();

                } else {
                    Intent intent = new Intent();
                    intent.putExtra(Utility.fullName, person.getText().toString());
                    if (man.isChecked()) {
                        intent.putExtra(Utility.gender, R.drawable.man);
                    } else if (woman.isChecked()) {
                        intent.putExtra(Utility.gender, R.drawable.woman);
                    }
                    if (calisiyor.isChecked()) {
                        intent.putExtra(Utility.workingStatus, R.drawable.ic_action_calisiyor);
                    } else if (calismiyor.isChecked()) {
                        intent.putExtra(Utility.workingStatus, R.drawable.ic_action_calismiyor);
                    }
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                }

            }
        });
    }

    private void defination() {
        person = findViewById(R.id.activitiy_add_screen_person_editText);
        man = findViewById(R.id.activity_add_screen_man_radioButton);
        woman = findViewById(R.id.activity_add_screen_woman_radioButton);
        calisiyor = findViewById(R.id.activity_add_screen_calisiyor_radioButton);
        calismiyor = findViewById(R.id.activity_add_screen_calismiyor_radioButton);
        addBtn = findViewById(R.id.activity_add_screen_addButton);
        rGGender = findViewById(R.id.activity_add_screeen_gender_radioGroup);
        rGworkingStatus = findViewById(R.id.activity_add_screen_workingStatus_radioGroup);
    }

    private boolean isSelected(RadioGroup radioGroup) {
        if (radioGroup.getCheckedRadioButtonId() == -1) {
            return false;
        } else {
            return true;
        }
    }
}