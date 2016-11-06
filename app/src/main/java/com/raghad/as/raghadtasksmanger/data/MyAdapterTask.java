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

import com.raghad.as.raghadtasksmanger.R;

/**
 * Created by user on 10/30/2016.
 */
public class MyAdapterTask extends ArrayAdapter<MyTask>//
{

    public MyAdapterTask(Context context, int resource)
    {
        super(context, resource);
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        convertView= LayoutInflater.from(getContext()).inflate(R.layout.item_my_task,parent,false);
        TextView tvAddress=(TextView)convertView.findViewById(R.id.tvAddress);
        CheckBox ChDone=(CheckBox)convertView.findViewById(R.id.ChDone);
        ImageButton etPhone=(ImageButton) convertView.findViewById(R.id.btnItmCall);
        TextView tvTitle=(TextView)convertView.findViewById(R.id.tvItmTitle);
        RatingBar rtbltmPriority=(RatingBar) convertView.findViewById(R.id.rtbltmPriority);
        EditText etWhen=(EditText)convertView.findViewById(R.id.etWhen);
        final MyTask myTask=getItem(position);
        tvTitle.setText(myTask.getTitle());
        ChDone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

            }
        });
        tvAddress.setText(myTask.getAddress());
        tvTitle.setText(myTask.getTitle());
        rtbltmPriority.setRating(myTask.getPrioroty());
       etPhone.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

           }
       });


        etWhen.setText((CharSequence) myTask.getWhen());
        return convertView;

    }
}
