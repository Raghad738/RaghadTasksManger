package raghad_12_1_2016.topspy;

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

import java.util.Calendar;

public class SignIn extends AppCompatActivity {

    private EditText etEmail;
    private EditText etPassword;
    private FirebaseAuth auth;
    private Button btnGo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        if (FirebaseAuth.getInstance().getCurrentUser()!=null)
        {
//            MyCall myCall = new MyCall();
//            myCall.setFile("koko");
//            myCall.setInOut(true);
//            myCall.setName("Raghad");
//            myCall.setNumber("0509606407");
//            SaveData.addCall(this, myCall);
//
//            MySMs mySMs = new MySMs();
//            mySMs.setInout(true);
//            mySMs.setSmsNumber("0235");
//            mySMs.setText("jo");
//            mySMs.setTime(Calendar.getInstance().getTime());//current time at the phone
//            SaveData.addSms(this, mySMs);
//
//            MyGps myGps = new MyGps();
//            myGps.setTime(Calendar.getInstance().getTime());
//            myGps.setLat(5);
//            myGps.setLng(3);
//            SaveData.addGbs(this, myGps);
        }

        etEmail=(EditText)findViewById(R.id.etEmeil);
        btnGo=(Button)findViewById(R.id.btnGo);
        etPassword=(EditText)findViewById(R.id.etPassword);
        auth=FirebaseAuth.getInstance();


        eventHandlrer();

    }
    private void dataHandler()
    {
        boolean isok=true;
        String stEmail=etEmail.getText().toString();
        String stPassword=etPassword.getText().toString();

        if (stEmail.length()==0){
            etEmail.setError("Wrong Email");
            isok=false;}
        if (stPassword.length()==0) {
            etPassword.setError("Wrong Password");
            isok = false;}
        if (isok)
            signIn(stEmail,stPassword);


    }

    /**
     * puttind event handler for (listeners)
     */
    private void eventHandlrer()
    {
        btnGo .setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view)
        {
            dataHandler();
//            Intent i= new Intent(SignIn.this, .class);
//            startActivity(i);

        }
    });


    }



    private void signIn(String email, String passw) {

        auth.signInWithEmailAndPassword(email,passw).addOnCompleteListener(SignIn.this, new OnCompleteListener<AuthResult>() {

            @Override

            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful())

                {

                    Toast.makeText(SignIn.this, "signIn Successful.", Toast.LENGTH_SHORT).show();
                    MyCall myCall = new MyCall();
                    myCall.setFile("koko");
                    myCall.setInOut(true);
                    myCall.setName("Raghad");
                    myCall.setNumber("0509606407");
                    SaveData.addCall(getBaseContext(), myCall);

//                    MySMs mySMs = new MySMs();
//                    mySMs.setInout(true);
//                    mySMs.setSmsNumber("0235");
//                    mySMs.setText("jo");
//                    mySMs.setTime(Calendar.getInstance().getTime());//current time at the phone
//                    SaveData.addSms(this, mySMs);
//
//                    MyGps myGps = new MyGps();
//                    myGps.setTime(Calendar.getInstance().getTime());
//                    myGps.setLat(5);
//                    myGps.setLng(3);
//                    SaveData.addGbs(this, myGps);

                    //Intent i= new Intent(SignIn.this, .class);
                   // startActivity(i);
                    // Intent intent=new Intent(LogInActivity.this,MainFCMActivity.class);

                    //   startActivity(intent);

                    //  finish();

                }

                else

                {

                    Toast.makeText(SignIn.this, "signIn failed."+task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                    task.getException().printStackTrace();

                }

            }

        });
    }










}