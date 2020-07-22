package com.example.ictproject.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.ictproject.fragment_adapter.FragmentChat;
import com.example.ictproject.fragment_adapter.FragmentHome;
import com.example.ictproject.fragment_adapter.FragmentPage;
import com.example.ictproject.fragment_adapter.FragmentRecommend;
import com.example.ictproject.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ImageView r_resume;
    private FirebaseUser user;
    private DatabaseReference dataRef;
    private FirebaseFirestore firebaseFirestore;
    private String uid;

    Fragment FragmentHome;
    Fragment FragmentRecommend;
    Fragment FragmentChat;
    Fragment FragmentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        FragmentHome = new FragmentHome();
        FragmentRecommend = new FragmentRecommend();
        FragmentChat = new FragmentChat();
        FragmentPage = new FragmentPage();

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, FragmentHome).commit();

        user = FirebaseAuth.getInstance().getCurrentUser();
        uid  = user.getUid();
        dataRef = FirebaseDatabase.getInstance().getReference("user");

        r_resume = findViewById(R.id.r_resume);

        dataRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.child("employee").hasChild(uid)){
                    r_resume.setEnabled(false);
                } else {
                    r_resume.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainActivity.this, Resume.class);
                            startActivity(intent);
                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(new OnSuccessListener<InstanceIdResult>() {
            @Override
            public void onSuccess(InstanceIdResult instanceIdResult) {
                String token = instanceIdResult.getToken();
                Map<String, String> map = new HashMap<>();
                map.put("pushToken", token);
                firebaseFirestore.getInstance().collection("token").document(uid).set(map);
            }
        });
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()){
                case R.id.homeItem:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, FragmentHome).commit();
                    return true;
                case R.id.recommendItem:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, FragmentRecommend).commit();
                    return true;
                case R.id.chatItem:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, FragmentChat).commit();
                    return true;
                case R.id.myPageItem:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, FragmentPage).commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }

}


