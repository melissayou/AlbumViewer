package compsci290.edu.duke.albumviewer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d (TAG, "Rating song "  + 1);
        String[] albums = this.getResources().getStringArray(R.array.album_names);
        String[] artists = this.getResources().getStringArray(R.array.artist_names);
        //String[][] songs = this.getResources().getStringArray(R.array.songlist);
        RecyclerView rv = findViewById(R.id.activity_main_recycler_view);
        rv.setAdapter(new AlbumAdapter(this, albums, artists));
        rv.setLayoutManager(new LinearLayoutManager(this));
    }
}
