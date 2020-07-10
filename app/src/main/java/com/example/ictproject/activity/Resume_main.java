package com.example.ictproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.ictproject.R;
import com.squareup.picasso.Picasso;

public class Resume_main extends AppCompatActivity {

    private TextView mEditTextFileName, mEditTextAge, mExperience, mRegion, mDay;
    private ImageView mImageView;
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume_main);

        button1 = findViewById(R.id.call1_button);


        mEditTextFileName = findViewById(R.id.edit_text_file_mName);
        mEditTextAge = findViewById(R.id.edit_text_mAge);
        mExperience = findViewById(R.id.mExperience);
        mRegion = findViewById(R.id.mPossible_region);
        mDay = findViewById(R.id.mPossible_day);
        mImageView = findViewById(R.id.mImage_view);

        Intent intent = getIntent();

        String name = intent.getExtras().getString("name");
        String imageUrl = intent.getExtras().getString("imageUrl");
        String age = intent.getExtras().getString("age");
        String experience = intent.getExtras().getString("experience");
        String region = intent.getExtras().getString("region");
        String day = intent.getExtras().getString("day");

        mEditTextFileName.setText(name);
        mEditTextAge.setText(age);
        mExperience.setText(experience);
        mRegion.setText(region);
        mDay.setText(day);

        Picasso.with(this)
                .load(imageUrl)
                .fit()
                .centerCrop()
                .into(mImageView);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Resume_main.this, ConnectActivity.class);
                startActivity(intent);
            }
        });
    }
}