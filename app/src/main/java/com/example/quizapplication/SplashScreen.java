package com.example.quizapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashScreen extends AppCompatActivity {

    Animation top_anim, bottom_anim;
    ImageView image;
    TextView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);

        // Handle window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize views
        image = findViewById(R.id.imageview);
        logo = findViewById(R.id.textview);
        // Remove or add 'slogan' if it's not used or not in the layout
        // slogan = findViewById(R.id.textview2);

        // Load animations
        top_anim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottom_anim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        // Apply animations
        image.setAnimation(top_anim);
        logo.setAnimation(bottom_anim);
        // slogan.setAnimation(bottom_anim);

        // Delay and move to next activity
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashScreen.this, Register.class);  // Fix here
            startActivity(intent);  // Fixed typo: StartActivity → startActivity
            finish();
        }, 3000);  // Fixed delayMills syntax
    }
}
