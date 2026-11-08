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

public class HelloActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hello);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button ac1 = findViewById(R.id.ac1);
        int ps=0;
        if (getIntent().hasExtra("stev")) {
           ps = getIntent().getIntExtra("stev", 0);
        }
        TextView st = findViewById(R.id.st);
        st.setText(String.valueOf(ps));
        ac1.setOnClickListener(v -> {
            Intent intent = new Intent(HelloActivity.this, MainActivity.class);
            intent.putExtra("stev", Integer.parseInt(st.getText().toString()));
            startActivity(intent);
        });
    }
}