package com.example.matricesequivalentes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText a11ET;
    EditText a12ET;
    EditText b1ET;
    EditText a21ET;
    EditText a22ET;
    EditText b2ET;

    TextView resultadoTV;
    TextView a11TV;
    TextView a12TV;
    TextView b1TV;
    TextView a21TV;
    TextView a22TV;
    TextView b2TV;

    Button equivalenteBT;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a11ET = findViewById(R.id.a11ET);
        a12ET = findViewById(R.id.a12ET);
        b1ET = findViewById(R.id.b1ET);
        a21ET = findViewById(R.id.a21ET);
        a22ET = findViewById(R.id.a22ET);
        b2ET = findViewById(R.id.b2ET);

        resultadoTV = findViewById(R.id.resultadoTV);
        a11TV = findViewById(R.id.a11TV);
        a12TV = findViewById(R.id.a12TV);
        b1TV = findViewById(R.id.b1TV);
        a21TV = findViewById(R.id.a21TV);
        a22TV = findViewById(R.id.a22TV);
        b2TV = findViewById(R.id.b2TV);

        equivalenteBT = findViewById(R.id.equivalenteBT);


    }


    public void seClickeoEquivalente(View view){

        String a11STR = a11ET.getText().toString();
        Float  a11FLT = Float.parseFloat(a11STR);

        String a12STR = a12ET.getText().toString();
        Float  a12FLT = Float.parseFloat(a12STR);

        String a21STR = a21ET.getText().toString();
        Float  a21FLT = Float.parseFloat(a21STR);

        String a22STR = a22ET.getText().toString();
        Float  a22FLT = Float.parseFloat(a22STR);

        String b1STR = b1ET.getText().toString();
        Float  b1FLT = Float.parseFloat(b1STR);

        String b2STR = b2ET.getText().toString();
        Float  b2FLT = Float.parseFloat(b2STR);

        if(a11FLT ==0 && a21FLT !=0){
            a11TV.setBackgroundColor(getResources().getColor(R.color.violeta));
            a22TV.setBackgroundColor(getResources().getColor(R.color.violeta));
            resultadoTV.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            resultadoTV.setText(R.string.matriz_escalonada);

            a11TV.setText(a21STR);
            a12TV.setText(a22STR);
            b1TV.setText(b2STR);

            a21TV.setText(a11STR);
            a22TV.setText(a12STR);
            b2TV.setText(b1STR);


        }
        else if(a11FLT !=0){
            Float matriz21 = a21FLT - a21FLT/a11FLT * a11FLT;
            Float matriz22= a22FLT - a21FLT/a11FLT * a12FLT;
            Float matrizb2= b2FLT - a21FLT/a11FLT * b1FLT;

            a11TV.setBackgroundColor(getResources().getColor(R.color.violeta));
            a22TV.setBackgroundColor(getResources().getColor(R.color.violeta));

            resultadoTV.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            resultadoTV.setText(R.string.matriz_escalonada);

            a11TV.setText(a11STR);
            a12TV.setText(a12STR);
            b1TV.setText(b1STR);

            a21TV.setText(matriz21.toString());
            a22TV.setText(matriz22.toString());
            b2TV.setText(matrizb2.toString());

        }else {
            a11TV.setText("");
            a12TV.setText("");
            b1TV.setText("");
            a21TV.setText("");
            a22TV.setText("");
            b2TV.setText("");
            a11TV.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            a22TV.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            resultadoTV.setTextColor(0xfff00000);
            resultadoTV.setText(R.string.resultado_error);
        }


    }
}
