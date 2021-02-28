package com.example.final_hack;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button upload, show, set;

    private static final int Gallery_Request_Code = 123;
    private ProgressBar progressBar;

    private StorageReference storageReference;
    private DatabaseReference databaseReference;
    private StorageTask mUploadTask;
    private EditText mEditTextFileName;
    EditText name, phone, age, gender;
    String na, po, gend, ag;

    Button sign;
    FirebaseDatabase rootnode;
    List<String> ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        gender = findViewById(R.id.gender);
        age = findViewById(R.id.age);


        upload = findViewById(R.id.upload);
        show = findViewById(R.id.show);


        progressBar = findViewById(R.id.progressBar);


        //storageReference = FirebaseStorage.getInstance().getReference("Users");
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                uploadFile();


            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch_voting();
            }
        });


    }

    private void switch_voting() {
        Intent intent = new Intent(MainActivity.this, Voting_Activity.class);
        intent.putExtra("Phone number", po);
        startActivity(intent);
    }

    private void uploadFile() {

        rootnode = FirebaseDatabase.getInstance();
        databaseReference = rootnode.getReference("Users");

        //Initializing the views
        na = name.getText().toString();
        po = phone.getText().toString();
        gend = gender.getText().toString();
        ag = age.getText().toString();


        userhelper helper = new userhelper(na, po, gend, ag, "0");

        databaseReference.child(po).setValue(helper);
        verify();


    }

    public void verify() {
        String gend1 = gender.getText().toString();

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Users");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot nar : snapshot.getChildren()) {

                    String num= (String) nar.child("hash").getValue();

                    if (gend1 == num)
                    {
                        Toast.makeText(MainActivity.this,"YOU HAVE BEEN VERIFIED",Toast.LENGTH_SHORT).show();


                    }



                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }


        });


    }
}