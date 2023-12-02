package com.example.eva3_3_interfaz_grafica;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity
implements RadioGroup.OnCheckedChangeListener{

    RadioGroup rdEstadoCivil;

    Button btnNomCom;

    EditText editTextNom, editTextText2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //View es una clase, son las base de todos los componetes
        //grafica en Android, Es una area rectangular donde se dibuja algo
        //rdEstadoCivil = findViewById(R.id.RadioGroup1);
        btnNomCom = findViewById(R.id.btnNomCom);
        editTextText2 = findViewById(R.id.editTextText2);
        editTextNom = findViewById(R.id.editTextNom);

        //Vincular eventos : al igual que en java --->Listerns
        rdEstadoCivil.setOnCheckedChangeListener(this);
        btnNomCom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = editTextNom.getText().toString();
                String apellido = editTextText2.getText().toString();
                Toast.makeText(MainActivity.this, nombre + "" + apellido, Toast.LENGTH_SHORT).show();
                // para cerrar la actividad ----> finish();
            }
        });


    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
      if (i== R.id.RadioGroup1){
         Toast.makeText(this, "Soltero", Toast.LENGTH_SHORT).show();

         if (i==R.id.rd2){
             Toast.makeText(this, "Casado", Toast.LENGTH_SHORT).show();

              if (i==R.id.rd3){
                  Toast.makeText(this, "Viudo", Toast.LENGTH_SHORT).show();

                  if (i==R.id.rd4){
                      Toast.makeText(this, "Union Libre", Toast.LENGTH_SHORT).show();
                  }
             }
         }
      }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
