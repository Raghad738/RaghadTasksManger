package com.raghad.as.raghadtasksmanger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.raghad.as.raghadtasksmanger.data.MyTask;

import java.util.Calendar;
import java.util.Date;

public class AddTaskActivity extends AppCompatActivity {
    private EditText etText;
    private EditText etPhone;
    private EditText etLocation;
    private Button btnContact;
    private Button btnSave;
    private RatingBar rtBarPriority;
    private ImageButton ibLocation;
    DatabaseReference reference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        etText=(EditText)findViewById(R.id.etText);
        etPhone=(EditText)findViewById(R.id.etPhone);
        etLocation=(EditText)findViewById(R.id.etLocation);
        btnContact=(Button) findViewById(R.id.btnContacts);
        btnSave=(Button)findViewById(R.id.btnSave);
        rtBarPriority=(RatingBar)findViewById(R.id.rtBarPriority);
        ibLocation=(ImageButton) findViewById(R.id.ibLocation);

        eventHandlrer();

    }

    private void dataHandler() {
        String stText = etText.getText().toString();
        String stPhone = etPhone.getText().toString();
        String stLocation = etLocation.getText().toString();
        Float stBarProiority = rtBarPriority.getRating();
        boolean isok = true;
        if (stText.length() == 0) {
            etText.setError("Wrong Text");
            isok = false;
        }
        if (stPhone.length() == 0) {
            etPhone.setError("Wrong Phone");
            isok = false;
        }
        if (stLocation.length() == 0) {
            etLocation.setError("Wrong Location");
            isok = false;
        }
        if (isok) {
            MyTask myTask = new MyTask();
            myTask.setAddress(stLocation);
            myTask.setPhone(stPhone);
            myTask.setPrioroty(stBarProiority);
            myTask.setTitle(stText);

            DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
            String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();
            email = email.replace(".", "_");


            reference.child(email).child("raghadTasks").push().setValue(myTask, new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                    if (databaseError == null)//addtion successful
                    {
                        Toast.makeText(AddTaskActivity.this, "Saved", Toast.LENGTH_LONG).show();

                    } else//adding failed
                    {

                        Toast.makeText(AddTaskActivity.this, "Saving Failed" + databaseError.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            });

        }
    }


    private void  eventHandlrer()
    {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               dataHandler();





            }
        });
        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });
        ibLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}


