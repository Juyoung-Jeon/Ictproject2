package com.example.ictproject.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.ictproject.fragment_adapter.MyPagerAdapter;
import com.example.ictproject.R;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private ImageView r_resume;
    private FirebaseUser user;
    private DatabaseReference dataRef;
    private String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataRef = FirebaseDatabase.getInstance().getReference("user");
        user = FirebaseAuth.getInstance().getCurrentUser();
        uid  = user.getUid();

        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("알바생 찾기"));
        tabs.addTab(tabs.newTab().setText("추천 알바생"));
        tabs.addTab(tabs.newTab().setText("마이 페이지"));
        tabs.setTabGravity(tabs.GRAVITY_FILL);

        //어답터설정
        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        final MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), 3);
        viewPager.setAdapter(myPagerAdapter);

        //탭메뉴를 클릭하면 해당 프래그먼트로 변경-싱크화
        tabs.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs));

        r_resume = findViewById(R.id.r_resume);

        dataRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChild(uid)){
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
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
}


