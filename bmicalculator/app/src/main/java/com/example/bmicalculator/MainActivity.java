package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.UserManager;
import android.service.autofill.UserData;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText weight,height;
    TextView displayResult,result;
    Button calculateBMI;
    Float userWeight ,userHeight,BMI;
    String calculation,BMIresult;
    UserValues userValues = new UserValues();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weight = findViewById(R.id.inputweight);
        height = findViewById(R.id.inputheight);
        calculateBMI = findViewById(R.id.calculateBMI);
        displayResult = findViewById(R.id.displayresult);
        result = findViewById(R.id.result);

        calculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userValues.setWeightUser(weight.getText().toString());
                userValues.setHeightuser(height.getText().toString());
                userWeight = Float.parseFloat(weight.getText().toString());
                userHeight = Float.parseFloat(height.getText().toString());
                userHeight = userHeight/100;
                BMI = userWeight/(userHeight*userHeight);

                if(BMI<18.5)
                {
                    BMIresult="You are underweight";
                }
                else if(BMI>=18.5 && BMI<=24.9)
                {
                    BMIresult="You have normal weight";
                }
                else if(BMI>=25 && BMI<=29.9)
                {
                    BMIresult = "You are overweight";
                }
                calculation ="BMI:\n\n"+BMI+"\n"+BMIresult;
                result.setText(calculation);

            }
        });

    }

}
