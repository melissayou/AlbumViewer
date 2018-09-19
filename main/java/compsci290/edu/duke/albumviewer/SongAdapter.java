package compsci290.edu.duke.albumviewer;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import static android.content.ContentValues.TAG;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder>  {
    String[] mSongList;
    Context mContext;

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView mSongList;
        public ViewHolder(View itemView) {
            super(itemView);
//            this.mLinearLayout = itemView.findViewById(R.id.song_holder_linear_layout);
//            this.mImageView = itemView.findViewById(R.id.album1_artwork_image_view);
//            this.mAlbumName = itemView.findViewById(R.id.album1_name_text_view);
//            this.mArtist = itemView.findViewById(R.id.artist1_name_text_view);
              this.mSongList = itemView.findViewById(R.id.song_list_text_view);
        }
    }
    public SongAdapter(final Context context, String[] songlist) {
        this.mContext = context;
        this.mSongList = songlist;
    }

    public int getItemCount(){
        return mSongList.length;
    }

    public SongAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        LayoutInflater mInflator = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = mInflator.inflate(R.layout.songs_holder, parent, false);
        final SongAdapter.ViewHolder songHolder = new SongAdapter.ViewHolder(row);
        songHolder.mSongList.setOnClickListener((new View.OnClickListener() {
            public void onClick(View view) {
                rateSong(mSongList[songHolder.getAdapterPosition()]);
            }
        }));
        return songHolder;
    }


    private void rateSong(String song) {
        //Log.d (TAG, "Rating song "  + song);
        Intent intent = new Intent(mContext, RatingActivity.class);
        intent.putExtra("song_name_key" , song);
        mContext.startActivity(intent);
    }

    public void onBindViewHolder(SongAdapter.ViewHolder holder,int position) {
          holder.mSongList.setText(mSongList[position]);

    }

}
