package com.example.hellocompat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //Contiene al TextView
    private TextView mHelloTextView;

    //Matriz de colores
    private String[] mColorArray = {"red", "pink", "purple", "deep_purple",
            "indigo", "blue", "light_blue", "cyan", "teal", "green",
            "light_green", "lime", "yellow", "amber", "orange", "deep_orange",
            "brown", "grey", "blue_grey", "black" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHelloTextView = findViewById(R.id.hello_textview);

        //Se quede el color de la aplicación
        // restore saved instance state (the text color)
        if (savedInstanceState != null) {
            mHelloTextView.setTextColor(savedInstanceState.getInt("color"));
        }
    }

    //Guardar el estado
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // save the current text color
        outState.putInt("color", mHelloTextView.getCurrentTextColor());
    }

    public void changeColor(View view) {
        //Generar números aleatorios simples
        Random random = new Random();
        String colorName = mColorArray[random.nextInt(20)];//0-19

        //Identificar recurso
        int colorResourceName = getResources().getIdentifier(colorName,
                "color", getApplicationContext().getPackageName());

        int colorRes = ContextCompat.getColor(this, colorResourceName);

        mHelloTextView.setTextColor(colorRes);
    }
}