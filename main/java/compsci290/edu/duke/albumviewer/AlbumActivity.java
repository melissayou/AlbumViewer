package compsci290.edu.duke.albumviewer;

import android.content.Intent;
import android.content.res.TypedArray;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AlbumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
       //bind the RecyclerView
        String[] albums = this.getResources().getStringArray(R.array.album_names);
        String[] artists = this.getResources().getStringArray(R.array.artist_names);
        Intent receivedIntent = this.getIntent();
        String albumName = receivedIntent.getStringExtra("album_name_key");
        String artistName = receivedIntent.getStringExtra("artist_name_key");


        //correct artistName and albumName and set the correct album
        int drawableId = this.getResources().getIdentifier(albumName, "drawable", this.getPackageName());
        ImageView correctImage = findViewById(R.id.album1_artwork_image_view);
        correctImage.setImageDrawable(this.getDrawable(drawableId));
        TextView correctAlbumName = findViewById(R.id.album1_name_text_view);
        correctAlbumName.setText(albumName);
        TextView correctArtistName = findViewById(R.id.artist1_name_text_view);
        correctArtistName.setText(artistName);


        //how to get the correct song list
        int songListID = this.getResources().getIdentifier(albumName, "array", this.getPackageName());
        String[] songs = this.getResources().getStringArray(songListID);
        RecyclerView rv = findViewById(R.id.activity_album_recycler_view);
        rv.setAdapter(new SongAdapter(this, songs));
        //how to pass in an array to get the correct position

        rv.setLayoutManager(new LinearLayoutManager(this));

    }
}
