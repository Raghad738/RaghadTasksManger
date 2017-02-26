package raghad_12_1_2016.topspy;

import android.content.Context;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by user on 11/10/2016.
 */
public class SaveData
{

    public static void addSms(final Context context, MySMs sms)
    {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();
        email = email.replace(".", "_");

        //smslist                       //oject MySMS
        reference.child(email).child("MySMS").push().setValue(sms, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError == null)//addtion successful
                {
                    Toast.makeText(context, "MySMS Saved", Toast.LENGTH_LONG).show();

                } else//adding failed
                {

                    Toast.makeText(context, "Saving Failed" + databaseError.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public static void addCall(final Context context, MyCall call)
    {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();
        email = email.replace(".", "_");

        //smslist                       //oject MySMS
        reference.child(email).child("MyCall").push().setValue(call, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError == null)//addtion successful
                {
                    Toast.makeText(context, "Saved", Toast.LENGTH_LONG).show();

                } else//adding failed
                {

                    Toast.makeText(context, "Saving Failed" + databaseError.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public static void addGbs(final Context context, MyGps gbs)
    {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();
        email = email.replace(".", "_");

        //smslist                       //oject MySMS
        reference.child(email).child("MyGbs").push().setValue(gbs, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError == null)//addtion successful
                {
                    Toast.makeText(context, "Saved", Toast.LENGTH_LONG).show();

                } else//adding failed
                {

                    Toast.makeText(context, "Saving Failed" + databaseError.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

    }


}




