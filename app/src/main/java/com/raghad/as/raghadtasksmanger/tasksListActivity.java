package com.raghad.as.raghadtasksmanger;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.raghad.as.raghadtasksmanger.data.MyAdapterTask;
import com.raghad.as.raghadtasksmanger.data.MyTask;

public class tasksListActivity extends AppCompatActivity {
    private EditText etFastAdd;
    private ImageButton ibPlus;
    private ListView lvTasks;
    private MyAdapterTask adapterTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        etFastAdd = (EditText) findViewById(R.id.etFastAdd);
        ibPlus = (ImageButton) findViewById(R.id.ibPlus);
        lvTasks = (ListView) findViewById(R.id.lvtasks);
        adapterTask=new MyAdapterTask(this,R.layout.item_my_task);
       lvTasks.setAdapter(adapterTask);

        eventHandlrer();
        dataHandler();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.Logout:
                Toast.makeText(getBaseContext(),"log Out",Toast.LENGTH_LONG).show();
                break;
            case R.id.Settings:
                Toast.makeText(getBaseContext(),"Settings",Toast.LENGTH_LONG).show();
                break;
        }
        return true;
    }

    private void dataHandler()
    {
        String stFastAdd=etFastAdd.getText().toString();
        if (stFastAdd.length()==0)
            etFastAdd.setError("Wrong FastAdd");
    }
    private void  eventHandlrer()
    {
        ibPlus.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(tasksListActivity.this, AddTaskActivity.class);
                startActivity(i);


            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        initListView();
    }

    private void initListView(){
      String email=FirebaseAuth.getInstance().getCurrentUser().getEmail().replace('.','_');
      DatabaseReference reference=FirebaseDatabase.getInstance().getReference(email);
      reference.child("raghadTasks").addValueEventListener(new ValueEventListener() {
          @Override
          public void onDataChange(DataSnapshot dataSnapshot) {
              adapterTask.clear();
              for (DataSnapshot ds:dataSnapshot.getChildren())
              {
                  MyTask myTask=ds.getValue(MyTask.class);
                  myTask.setId(ds.getKey());
                  adapterTask.add(myTask);
              }
          }

          @Override
          public void onCancelled(DatabaseError databaseError) {

          }
      });
  }

}



