package com.ualr.recyclerviewassignment.model;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ualr.recyclerviewassignment.Utils.DataGenerator;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.ualr.recyclerviewassignment.R;
import com.ualr.recyclerviewassignment.Utils.DataGenerator;

import org.w3c.dom.Text;

import java.util.List;

//new adapter class for to-do 5
public class InboxAdapter extends RecyclerView.Adapter<InboxAdapter.ViewHolder> {

    //declare list of inbox messages
    private List<Inbox> mInbox;

    public class ViewHolder extends RecyclerView.ViewHolder{
        protected final TextView nameTextView;
        private final TextView emailTextView;
        private final TextView msgTextView;
        private final TextView dateTextView;
        private final TextView circleTextView;
        private final CardView itemCard;

        public boolean isClicked = false;

        public ViewHolder(View itemView){
            super(itemView);
            //detects click events on the items and updates the layout
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mInbox.get(getLayoutPosition()).toggleSelection();
                    notifyDataSetChanged();
                }
            });


            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            emailTextView = (TextView) itemView.findViewById(R.id.emailTextView);
            msgTextView = (TextView) itemView.findViewById(R.id.msgTextView);
            dateTextView = (TextView) itemView.findViewById(R.id.dateTextView);
            circleTextView = (TextView) itemView.findViewById(R.id.circleTextView);
            itemCard = (CardView) itemView.findViewById(R.id.itemCard);

            //deletes items if they are selected and the button is clicked
            circleTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        if(mInbox.get(getLayoutPosition()).isSelected()){

                            mInbox.remove(getLayoutPosition());

                            notifyDataSetChanged();


                    }
                }
            });


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


    @SuppressLint("ResourceAsColor") //it crashed if i did what it told me to
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.getNameTextView().setText((mInbox.get(position)).getFrom());
        holder.getEmailTextView().setText((mInbox.get(position)).getEmail());
        holder.getMsgTextView().setText((mInbox.get(position)).getMessage());
        holder.getDateTextView().setText((mInbox.get(position)).getDate());
        holder.getCircleTextView().setText( ((mInbox.get(position)).getFrom()).substring(0,1) );

        //Set item to X if selected and change the background color of the card to notify is selected
        if(mInbox.get(position).isSelected()){
            holder.getCircleTextView().setText("X");
            holder.itemCard.setCardBackgroundColor(R.color.grey_3);

        }




    }


    @Override
    public int getItemCount() {
        return mInbox.size();
    }



}
