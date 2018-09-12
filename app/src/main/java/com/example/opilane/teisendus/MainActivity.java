package com.example.opilane.teisendus;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //faktor, mille abil toimub teisendamine

    private static final double factor = 1.609344;
    EditText text;
    RadioButton ml, km;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.txt_number);
        ml = findViewById(R.id.btn_ml);
        km = findViewById(R.id.btn_km);
    }
    public static double toKM(double miles){
        return miles*factor;
    }

    public static double toML(double kilometers){
        return kilometers/factor;
    }

    public void onClick(View view) {
        if(view.getId()==R.id.btn_clear){
            text.setText("");
        }
        else if(view.getId()==R.id.btn_ok){
            if(text.getText().length()==0){
                Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show();
                return;
            }
            double value = Double.parseDouble(text.getText().toString());
            if(ml.isChecked()) text.setText(String.valueOf(toKM(value)));
            else text.setText(String.valueOf(toML(value)));
        }

    }
}
