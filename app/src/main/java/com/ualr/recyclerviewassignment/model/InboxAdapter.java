package com.ualr.recyclerviewassignment.model;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ualr.recyclerviewassignment.Utils.DataGenerator;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ualr.recyclerviewassignment.R;
import com.ualr.recyclerviewassignment.Utils.DataGenerator;

import org.w3c.dom.Text;

import java.util.List;

public class InboxAdapter extends RecyclerView.Adapter<InboxAdapter.ViewHolder> {

    //declare list of inbox messages
    private List<Inbox> mInbox;
    int inboxPositon = 0;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        protected final TextView nameTextView;
        private final TextView emailTextView;
        private final TextView msgTextView;
        private final TextView dateTextView;
        private final TextView circleTextView;

        public ViewHolder(View itemView){
            super(itemView);


            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            emailTextView = (TextView) itemView.findViewById(R.id.emailTextView);
            msgTextView = (TextView) itemView.findViewById(R.id.msgTextView);
            dateTextView = (TextView) itemView.findViewById(R.id.dateTextView);
            circleTextView = (TextView) itemView.findViewById(R.id.circleTextView);


        }

        public TextView getNameTextView() { return nameTextView; }

        public TextView getEmailTextView() { return emailTextView; }

        public TextView getMsgTextView() { return msgTextView; }

        public TextView getDateTextView() { return dateTextView; }

        public TextView getCircleTextView() { return circleTextView; }
    }

    //initialize dataset
    public InboxAdapter(List<Inbox> inbox) {
        mInbox = inbox;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        // Inflate the custom layout
        View inboxView = inflater.inflate(R.layout.item_email, parent, false);

        // Return a new holder instance
        return new ViewHolder(inboxView);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        inboxPositon = position;
        holder.getNameTextView().setText((mInbox.get(position)).getFrom());
        holder.getEmailTextView().setText((mInbox.get(position)).getEmail());
        holder.getMsgTextView().setText((mInbox.get(position)).getMessage());
        holder.getDateTextView().setText((mInbox.get(position)).getDate());
        holder.getCircleTextView().setText( ((mInbox.get(position)).getFrom()).substring(0,1) );

    }

    public Inbox getInbox(int position){

        return mInbox.get(position);
    }

    @Override
    public int getItemCount() {
        return mInbox.size();
    }



}
