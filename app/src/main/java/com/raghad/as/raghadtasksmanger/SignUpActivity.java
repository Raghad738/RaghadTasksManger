package com.raghad.as.raghadtasksmanger;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity {
    private EditText etEmail;
    private EditText etPassw1;
    private EditText etPassw2;
    private EditText etFullName;
    private Button btnSignUp;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etEmail=(EditText)findViewById(R.id.etEmail);
        etPassw1=(EditText)findViewById(R.id.etPassw1);
        etPassw2=(EditText)findViewById(R.id.etPassw2);
        etFullName=(EditText)findViewById(R.id.etFullName);
        btnSignUp=(Button)findViewById(R.id.btnSignUp);

        eventHandlrer();
        auth=FirebaseAuth.getInstance();


    }
    private void dataHandler()
    {
        String stEmail=etEmail.getText().toString();
        String stPassw1=etPassw1.getText().toString();
        String stPassw2=etPassw2.getText().toString();
        String stFullName=etFullName.getText().toString();
        boolean isok=true;

        if (stEmail.length()==0) {
            etEmail.setError("Wrong Email");
            isok = false;
        }
        if (stPassw1.length()==0) {
            etPassw1.setError("Wrong Paasword");
            isok = false;
        }

        if (stPassw2.length()==0) {
            etPassw2.setError("Wrong Password");
            isok = false;
        }
        if (stFullName.length()==0){
            etFullName.setError("Wrong Full Name");
        isok=false;}

        if (isok);
        creatAcount( stEmail,stPassw1);


    }
    private void  eventHandlrer()
    {
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               dataHandler();



            }
        });
    }
    private FirebaseAuth.AuthStateListener authStateListener=new FirebaseAuth.AuthStateListener() {

        @Override

        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

            //4.

            FirebaseUser user=firebaseAuth.getCurrentUser();

            if(user!=null)

            {

                //user is signed in

                Toast.makeText(SignUpActivity.this, "user is signed in.", Toast.LENGTH_SHORT).show();


            }

            else

            {

                //user signed out

                Toast.makeText(SignUpActivity.this, "user signed out.", Toast.LENGTH_SHORT).show();


            }

        }

    };
    @Override

    protected void onStart() {

        super.onStart();

        auth.addAuthStateListener(authStateListener);

    }

    @Override

    protected void onStop() {

        super.onStop();

        if(authStateListener!=null)

            auth.removeAuthStateListener(authStateListener);

    }

    private void creatAcount(String email, String passw) {

        auth.createUserWithEmailAndPassword(email,passw).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {

            @Override

            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful())

                {

                    Toast.makeText(SignUpActivity.this, "Authentication Successful.", Toast.LENGTH_SHORT).show();

                    //updateUserProfile(task.getResult().getUser());

                    finish();

                }

                else

                {
                  Toast.makeText(SignUpActivity.this, "Authentication failed."+task.getException().getMessage(),
                          Toast.LENGTH_SHORT).show();

                    task.getException().printStackTrace();
                }
            }
        });
    }
}
