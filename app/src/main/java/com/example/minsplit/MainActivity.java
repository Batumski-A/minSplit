package com.example.minsplit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public Button Submit;
    public EditText CheckText;
    public TextView SetNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Submit = findViewById(R.id.mSubmit);
        CheckText = findViewById(R.id.mCheckThis);
        SetNumber = findViewById(R.id.mSetNumber);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int integer = Integer.parseInt(CheckText.getText().toString());
                String getString = String.valueOf(minSplit(integer));
                SetNumber.setText(getString);
            }
        });

    }

    public int minSplit(int amount) {
        int amountF = 0;
        int[] mass2 = new int[10];
        int[] mass = {50, 20, 10, 5, 1};
        for (int i = 0; i < mass.length; i++) {
            mass2[i] = (int)(amount / mass[i]) * mass[i];
        }
        for (int i = 0; i < mass.length; i++) {
            if (i == 0) {
                amountF =amountF + mass2[i] / mass[i];
            } else {
                amountF = amountF +(mass2[i] - mass2[i - 1]) / mass[i];
            }
        }
        return amountF;
    }
}
