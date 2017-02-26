package com.raghad.as.raghadtasksmanger.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.raghad.as.raghadtasksmanger.R;

/**
 * Created by user on 10/30/2016.
 */
public class MyAdapterTask extends ArrayAdapter<MyTask>//
{
    private DatabaseReference reference;

    public MyAdapterTask(Context context, int resource)
    {
        super(context, resource);
        String email= FirebaseAuth.getInstance().getCurrentUser().getEmail().replace('.','_');
         reference= FirebaseDatabase.getInstance().getReference(email).child("raghadTasks");

    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        convertView= LayoutInflater.from(getContext()).inflate(R.layout.item_my_task,parent,false);
        TextView tvItmPhone=(TextView)convertView.findViewById(R.id.tvItmPhone);
        ImageButton etPhone=(ImageButton) convertView.findViewById(R.id.btnItmCall);
        TextView tvItmTitle=(TextView)convertView.findViewById(R.id.tvItmTitle);
        RatingBar rtbltmPriority=(RatingBar) convertView.findViewById(R.id.rtbltmPriority);
        TextView tvItmText=(TextView)convertView.findViewById(R.id.tvItmText);
        ImageButton btnDel=(ImageButton) convertView.findViewById(R.id.btnDel);

        final MyTask myTask=getItem(position);
        tvItmPhone.setText(myTask.getPhone());
       tvItmText.setText(myTask.getAddress());
       tvItmTitle.setText(myTask.getTitle());
        rtbltmPriority.setRating(myTask.getPrioroty());

       etPhone.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

           }
       });
        //del 02
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference.child(myTask.getId()).removeValue(new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                        if (databaseError==null)
                        {
                            Toast.makeText(getContext(),"Deleted!",Toast.LENGTH_LONG).show();
                            remove(myTask);
                            setNotifyOnChange(true);
                        }
                    }
                });


            }
        });
        return convertView;


    }

}
