package com.example.eva3_4_listas;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView Lista;
    String[] datos = {

     "Tacos 1",
     "Tacos 2",
     "Tacos 3",
     "Tacos 4 ",
     "Tacos 5 ",
     "Tacos 6",
     "Tacos 7",
     "Tacos 8",
     "Tacos 9",
     "Tacos 10",
     "Tacos 11"

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Lista = findViewById(R.id.Lista);
        Lista.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,datos));

        Lista.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                        Toast.makeText(MainActivity.this, "Valor Seleccionado" + datos[i], Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this,Menu.class);
                        startActivity(intent);
                        intent.putExtra("Orden",datos[i]);
                    }
                }
        );
    }
}