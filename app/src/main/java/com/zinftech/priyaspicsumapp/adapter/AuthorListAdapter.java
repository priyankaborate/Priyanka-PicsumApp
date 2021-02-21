package com.zinftech.priyaspicsumapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.zinftech.priyaspicsumapp.R;
import com.zinftech.priyaspicsumapp.model.AuthorModel;
import com.zinftech.priyaspicsumapp.viewmodel.AuthorListViewModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class AuthorListAdapter extends RecyclerView.Adapter<AuthorListAdapter.MyViewHolder> {

    private Context context;
    private List<AuthorModel> authorList;

   public AuthorListAdapter(Context context,List<AuthorModel> authorList)
   {
        this.context = context;
        this.authorList = authorList;
   }

   public void setAuthorList(List<AuthorModel> authorList)
   {
        this.authorList = authorList;
        notifyDataSetChanged();
   }

    @NonNull
    @Override
    public AuthorListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AuthorListAdapter.MyViewHolder holder, int position) {
        holder.authorTitle.setText(                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         this.authorList.get(position).getAuthor());

        Glide.with(context).load("https://picsum.photos/300/300?image="+this.authorList.get(position)
                .getId())
                .apply(RequestOptions.centerCropTransform())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
       if(this.authorList != null)
       {
           return this.authorList.size();
       }
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView authorTitle;
        ImageView imageView;

        public MyViewHolder(View itemView)
        {
            super(itemView);
            authorTitle = (TextView) itemView.findViewById(R.id.titleView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }

}
