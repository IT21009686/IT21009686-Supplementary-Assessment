package com.mad.it21009686supplementaryassessment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{

    private Context context;
    Activity activity;
    private ArrayList bookID, bookTitle, bookAuthor, bookPages;



//    CustomAdapter(Activity activity, Context context, ArrayList bookID, ArrayList bookTitle, ArrayList bookAuthor,ArrayList bookPages){
//        this.activity = activity;
//        this.context = context;
//        this.bookID = bookID;
//        this.bookTitle = bookTitle;
//        this.bookAuthor = bookAuthor;
//        this.bookPages = bookPages;
//    }

    public CustomAdapter(Activity activity, Context context,ArrayList<String> bookID, ArrayList<String> bookAuthor, ArrayList<String> bookTitle, ArrayList<String> bookPages) {
        this.activity = activity;
        this.context = context;
        this.bookID = bookID;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookPages = bookPages;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, final int position) {
        holder.bookID.setText(String.valueOf(bookID.get(position)));
        holder.bookTitle.setText(String.valueOf(bookTitle.get(position)));
        holder.bookAuthor.setText(String.valueOf(bookAuthor.get(position)));
        holder.bookPages.setText(String.valueOf(bookPages.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context,updateActivity.class);
                i.putExtra("id",String.valueOf(bookID.get(position)));
                i.putExtra("title",String.valueOf(bookTitle.get(position)));
                i.putExtra("author",String.valueOf(bookAuthor.get(position)));
                i.putExtra("pages",String.valueOf(bookPages.get(position)));

                activity.startActivityForResult(i,1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return bookID.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView bookID, bookTitle, bookAuthor, bookPages;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            bookID = itemView.findViewById(R.id.bookIDtxt);
            bookTitle = itemView.findViewById(R.id.bookTitletxt);
            bookAuthor = itemView.findViewById(R.id.bookAuthortxt);
            bookPages = itemView.findViewById(R.id.bookPagestxt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
