package com.example.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView st = findViewById(R.id.st);
        Button count = findViewById(R.id.button5);
        Button ac2 = findViewById(R.id.button3);
        Button ac3 = findViewById(R.id.button4);

        final int[] stevilo = {0};

        if (getIntent().hasExtra("stev")) {
           int ps = getIntent().getIntExtra("stev", 0);
            stevilo[0]=ps;
        }

        st.setText(String.valueOf(stevilo[0]));

        count.setOnClickListener(v -> {
             stevilo[0] = Integer.parseInt(st.getText().toString());
            stevilo[0]++;
            st.setText(String.valueOf(stevilo[0]));
        });
        ac2.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, HelloActivity.class);
            intent.putExtra("stev", Integer.parseInt(st.getText().toString()));
            startActivity(intent);
        });
        ac3.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
            intent.putExtra("stev", Integer.parseInt(st.getText().toString()));
            startActivity(intent);
        });
    }
}