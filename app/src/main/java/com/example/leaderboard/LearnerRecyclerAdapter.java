package com.example.leaderboard;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class LearnerRecyclerAdapter extends RecyclerView.Adapter<LearnerRecyclerAdapter.ViewHolder> {

    private List<RetroLeader> mData;
    private LayoutInflater mInflater;
    private Context mContext;
    private static final String TAG = "LearnerRecyclerAdapter";

    LearnerRecyclerAdapter(Context context, List<RetroLeader> data){
        this.mContext = context;
        //this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.leaders_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RetroLeader mleader = mData.get(position);
        Log.d(TAG, "onBindViewHolder: ");
        holder.username.setText(mleader.getName());
        String userDesc = Integer.toString(mleader.getHours()).concat(" ").concat(" learning hours, ")
                    .concat(mleader.getCountry());
        holder.user_desc.setText(userDesc);

        Picasso.Builder builder = new Picasso.Builder(mContext);
        builder.downloader(new OkHttp3Downloader(mContext));
        builder.build().load(mleader.getBadgeUrl())
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .into(holder.mImageView);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public final View mView;

        public TextView username, user_desc;
        public ImageView mImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mView = itemView;
            username = mView.findViewById(R.id.tv_name);
            user_desc = mView.findViewById(R.id.tv_user_desc);
            mImageView = mView.findViewById(R.id.imageView);
        }


    }

}
