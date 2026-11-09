package com.example.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button ac1 = findViewById(R.id.ac1);
        Button ac2 = findViewById(R.id.button3);
        int ps=0;
        if (getIntent().hasExtra("stev")) {
            ps = getIntent().getIntExtra("stev", 0);
        }
        TextView st = findViewById(R.id.st);
        st.setText(String.valueOf(ps));
        ac1.setOnClickListener(v -> {
            Intent intent = new Intent(ThirdActivity.this, MainActivity.class);
            intent.putExtra("stev", Integer.parseInt(st.getText().toString()));
            startActivity(intent);
        });
        ac2.setOnClickListener(v -> {
            Intent intent = new Intent(ThirdActivity.this, HelloActivity.class);
            intent.putExtra("stev", Integer.parseInt(st.getText().toString()));
            startActivity(intent);
        });
        class OnSwipeTouchListener implements View.OnTouchListener {

            private final GestureDetector gestureDetector;

            public OnSwipeTouchListener(Context context) {
                gestureDetector = new GestureDetector(context, new GestureListener());
            }

            public void onSwipeLeft() {
                Intent intent = new Intent(ThirdActivity.this, MainActivity.class);
                intent.putExtra("stev", Integer.parseInt(st.getText().toString()));
                startActivity(intent);
            }

            public void onSwipeRight() {
                Intent intent = new Intent(ThirdActivity.this, HelloActivity.class);
                intent.putExtra("stev", Integer.parseInt(st.getText().toString()));
                startActivity(intent);
            }

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event == null) {
                    return false;
                }
                if (event.getAction() == MotionEvent.ACTION_UP && v != null) {
                    v.performClick();
                }
                return gestureDetector.onTouchEvent(event);
            }

            final class GestureListener extends GestureDetector.SimpleOnGestureListener {

                private static final int SWIPE_DISTANCE_THRESHOLD = 100;
                private static final int SWIPE_VELOCITY_THRESHOLD = 100;

                @Override
                public boolean onDown(@NonNull MotionEvent e) {
                    return true;
                }

                @Override
                public boolean onFling(@Nullable MotionEvent e1, @NonNull MotionEvent e2, float velocityX, float velocityY) {
                    if (e1 == null) {
                        return false;
                    }
                    float distanceX = e2.getX() - e1.getX();
                    float distanceY = e2.getY() - e1.getY();
                    if (Math.abs(distanceX) > Math.abs(distanceY) && Math.abs(distanceX) > SWIPE_DISTANCE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                        if (distanceX > 0) {
                            onSwipeRight();
                        } else {
                            onSwipeLeft();
                        }
                        return true;
                    }
                    return false;
                }
            }
        }
    }
}