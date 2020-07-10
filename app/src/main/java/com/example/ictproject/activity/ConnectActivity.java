package com.example.ictproject.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ictproject.R;
import com.example.ictproject.upload.CompanyUpload;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ConnectActivity extends AppCompatActivity {

    private Button button2, cancel_button;
    private EditText company, phone;
    private FirebaseUser user;
    private String uid;
    private DatabaseReference cDatabaseRef;
    private CompanyUpload cUpload;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);

        button2 = findViewById(R.id.call2_button);
        cancel_button = findViewById(R.id.cancel_button);
        company = findViewById(R.id.rCompanyName);
        phone = findViewById(R.id.rCompanyPhone);

        cDatabaseRef = FirebaseDatabase.getInstance().getReference("company");
        user = FirebaseAuth.getInstance().getCurrentUser();
        uid = user.getUid();


        cDatabaseRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChild(uid)){
                    cUpload = dataSnapshot.child(uid).getValue(CompanyUpload.class);
                    company.setText(cUpload.getCName());
                    phone.setText(cUpload.getCPhone());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
