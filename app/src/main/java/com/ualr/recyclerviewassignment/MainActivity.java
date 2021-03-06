package com.ualr.recyclerviewassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ualr.recyclerviewassignment.Utils.DataGenerator;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ualr.recyclerviewassignment.model.Inbox;
import com.ualr.recyclerviewassignment.model.InboxAdapter;

import java.util.List;

// TODO 05. Create a new Adapter class and the corresponding ViewHolder class in a different file. The adapter will be used to populate
//  the recyclerView and manage the interaction with the items in the list
// NOTE: These are located under Model
// TODO 06. Detect click events on the list items. Implement a new method to toggle items' selection in response to click events
// Done it InboxAdapter
// TODO 07. Detect click events on the thumbnail located on the left of every list row when the corresponding item is selected.
//  Implement a new method to delete the corresponding item in the list
//Done In InboxAdapter
// TODO 08. Create a new method to add a new item on the top of the list. Use the DataGenerator class to create the new item to be added.
//Done alongside TO-Do 10
public class MainActivity extends AppCompatActivity {


    private FloatingActionButton mFAB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_multi_selection);
        initComponent();
    }

    private void initComponent() {
        // TODO 01. Generate the item list to be displayed using the DataGenerator class
        List<Inbox> emails = DataGenerator.getInboxData(this);

        //set recyclerView
        // TODO 03. Do the setup of a new RecyclerView instance to display the item list properly
        RecyclerView rvEmail = (RecyclerView) findViewById(R.id.rvEmail);

        // TODO 04. Define the layout of each item in the list
        //Done in item_email.xml under res/layout

        // TODO 09. Create a new instance of the created Adapter class and bind it to the RecyclerView instance created in step 03
        InboxAdapter adapter= new InboxAdapter(emails);
        rvEmail.setAdapter(adapter);
        rvEmail.setLayoutManager(new LinearLayoutManager(this));


        mFAB = findViewById(R.id.fab);
        mFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO 10. Invoke the method created to a new item to the top of the list so it's
                //  triggered when the user taps the Floating Action Button

                //This also is TO-DO 8 since it was easily done in a single line
                emails.add(0, DataGenerator.getRandomInboxItem(getApplicationContext()));

                adapter.notifyDataSetChanged();

            }
        });
    }

}