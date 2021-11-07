package com.ualr.recyclerviewassignment.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ualr.recyclerviewassignment.R;
import com.ualr.recyclerviewassignment.Utils.DataGenerator;

import java.util.List;

//TODO 11. Remove This https://guides.codepath.com/android/using-the-recyclerview thanks for the help
public class InboxAdapter extends
        RecyclerView.Adapter<InboxAdapter.ViewHolder> {

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View inboxView = inflater.inflate(R.layout.item_email, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(inboxView);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        // Get the data model based on position
        Inbox inbox = mInbox.get(position);

        // Set item views based on your views and data model
        TextView nameText = holder.nameTextView;
        nameText.setText(inbox.getFrom());
        TextView addrText = holder.emailTextView;
        addrText.setText(inbox.getEmail());
        TextView msgText = holder.msgTextView;
        msgText.setText(inbox.getMessage());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView nameTextView;
        public TextView emailTextView;
        public TextView msgTextView;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            emailTextView = (TextView) itemView.findViewById(R.id.emailTextView);
            msgTextView = (TextView) itemView.findViewById(R.id.msgTextView);
        }
    }

    private List<Inbox> mInbox;

    public InboxAdapter(List<Inbox> inbox) {
        mInbox = inbox;
    }
}
