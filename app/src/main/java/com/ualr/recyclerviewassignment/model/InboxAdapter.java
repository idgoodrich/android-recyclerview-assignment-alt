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

import org.w3c.dom.Text;

import java.util.List;

public class InboxAdapter extends RecyclerView.Adapter<InboxAdapter.ViewHolder> {

    //declare list of inbox messages
    private List<Inbox> mInbox;


    public static class ViewHolder extends RecyclerView.ViewHolder{
        protected final TextView nameTextView;
        private final TextView emailTextView;
        private final TextView msgTextView;

        public ViewHolder(View itemView){
            super(itemView);

            /*v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Element " + getAdapterPosition() + " clicked.");
                }
            });*/

            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            emailTextView = (TextView) itemView.findViewById(R.id.emailTextView);
            msgTextView = (TextView) itemView.findViewById(R.id.msgTextView);


        }

        public TextView getNameTextView() { return nameTextView; }

        public TextView getEmailTextView() { return emailTextView; }

        public TextView getMsgTextView() { return msgTextView; }
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

        holder.getNameTextView().setText("HELP");
        holder.getEmailTextView().setText("HELP");
        holder.getMsgTextView().setText("HELP");



    }

    @Override
    public int getItemCount() {
        return mInbox.size();
    }

}
