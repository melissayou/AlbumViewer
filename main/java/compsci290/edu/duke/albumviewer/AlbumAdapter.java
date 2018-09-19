package compsci290.edu.duke.albumviewer;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.content.ContentValues.TAG;

/**
 * Created by Melissa on 1/18/18.
 */

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {
    private Context mContext;
    private String[] mAlbums;
    private String[] mArtists;

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout mLinearLayout;
        ImageView mImageView;
        TextView mAlbumName;
        TextView mArtist;
        public ViewHolder(View itemView) {
            super(itemView);
            this.mLinearLayout = itemView.findViewById(R.id.album_holder_linear_layout);
            this.mImageView = itemView.findViewById(R.id.album_artwork_image_view);
            this.mAlbumName = itemView.findViewById(R.id.album_name_text_view);
            this.mArtist = itemView.findViewById(R.id.artist_name_text_view);
        }
    }

    public AlbumAdapter(final Context context, String[] albums, String[] artists){
        this.mContext = context;
        this.mAlbums = albums;
        this.mArtists = artists;
    }

    public int getItemCount(){
        return mAlbums.length;
    }

    public AlbumAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        LayoutInflater mInflator = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = mInflator.inflate(R.layout.album_holder, parent, false);
        final ViewHolder albumHolder = new ViewHolder(row);
        albumHolder.mLinearLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                openAlbum(mAlbums[albumHolder.getAdapterPosition()],mArtists[albumHolder.getAdapterPosition()]);
            }
        });
        return albumHolder;
    }
    private void openAlbum(String albumName, String artistName) {
        Log.d (TAG, "Opening album "  + albumName);
        Intent intent = new Intent(mContext, AlbumActivity.class );
        intent.putExtra("album_name_key" , albumName);
        intent.putExtra("artist_name_key", artistName);
        mContext.startActivity(intent);
    }

    public void onBindViewHolder(AlbumAdapter.ViewHolder holder,int position) {
        String albumName = mAlbums[position];
        albumName.toLowerCase().replaceAll("\\W+","");
        int drawableId = mContext.getResources().getIdentifier(albumName, "drawable", mContext.getPackageName());
        Drawable albumArtwork = mContext.getDrawable(drawableId);
        holder.mImageView.setImageDrawable(albumArtwork);
        holder.mAlbumName.setText(mAlbums[position]);
        holder.mArtist.setText(mArtists[position]);
    }
}
