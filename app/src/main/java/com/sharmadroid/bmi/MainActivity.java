package com.sharmadroid.bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtweight, edtheightft,edtheightinch;
        Button btnCalculate;
        TextView txtresult;

        edtweight = findViewById(R.id.edtweight);
        edtheightft = findViewById(R.id.edtheightft);
        edtheightinch = findViewById(R.id.edtheightinch);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtresult = findViewById(R.id.txtresult);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt = Integer.parseInt(edtweight.getText().toString());
                int heightFt = Integer.parseInt(edtheightft.getText().toString());
                int heightIn = Integer.parseInt(edtheightinch.getText().toString());

                int totalInches = heightFt*12 + heightIn;

                double totalCm = totalInches*2.53;

                double totalM = totalCm/100;

                double bmi = wt/(Math.pow(totalM,2));

                if(bmi>25)
                {
                    txtresult.setText("You're Overweight!");
                }else if(bmi<18)
                {
                    txtresult.setText("You're Underweight!");
                }else{
                    txtresult.setText("You're Healty!");
                }
            }
        });

    }
}