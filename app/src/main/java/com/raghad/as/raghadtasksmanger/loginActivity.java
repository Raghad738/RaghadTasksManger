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
        import com.google.firebase.database.FirebaseDatabase;

public class loginActivity extends AppCompatActivity {
    private EditText etEmail;
    private EditText etPassword;
    private Button btnSignIn;
    private Button btnSignUp;
    private Button btnForgotPassword;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail=(EditText)findViewById(R.id.etEmail);
        etPassword=(EditText)findViewById(R.id.etPassword);
        btnSignIn=(Button) findViewById(R.id.btnSignIn);
        btnSignUp=(Button) findViewById(R.id.btnSignUp);
        btnForgotPassword=(Button)findViewById(R.id.btnForgetPassword);
        auth=FirebaseAuth.getInstance();

        eventHandlrer();

    }

    /**
     *1. getting data from the ui form (edittext, checbox, radiobutton etc..)
     * 2. checking data (the email text is ok, the password,
     * 3. dealing with the data
     */
    private void dataHandler()
    {
        boolean isok=true;
        //1.getting data
        String stEmail=etEmail.getText().toString();
        String stPassword=etPassword.getText().toString();
        //2.checking
        if (stEmail.length()==0){
            etEmail.setError("Wrong Email");
        isok = false;}

        if (stPassword.length()==0){
            etPassword.setError("Wrong Password");
        isok = false;}
        if (isok);
        signIn(stEmail,stPassword);

    }

    /**
     * puttind event handler for (listeners)
     */
    private void  eventHandlrer()
    {
        btnSignIn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                dataHandler();

            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(loginActivity.this,SignUpActivity.class);
                startActivity(i);
            }
        });
        btnForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {


            }
        });
    }
    private void signIn(String email, String passw) {

        auth.signInWithEmailAndPassword(email,passw).addOnCompleteListener(loginActivity.this, new OnCompleteListener<AuthResult>() {

            @Override

            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful())

                {

                    Toast.makeText(loginActivity.this, "signIn Successful.", Toast.LENGTH_SHORT).show();

                    Intent i= new Intent(loginActivity.this, tasksListActivity.class);
                    startActivity(i);
                    // Intent intent=new Intent(LogInActivity.this,MainFCMActivity.class);

                    //   startActivity(intent);

                    //  finish();

                }

                else

                {

                    Toast.makeText(loginActivity.this, "signIn failed."+task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                    task.getException().printStackTrace();

                }

            }

        });
    }
}




