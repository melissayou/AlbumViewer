package compsci290.edu.duke.albumviewer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class RatingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        Intent receivedIntent = this.getIntent();
        String songName = receivedIntent.getStringExtra("song_name_key");
        TextView displaySong = findViewById(R.id.rating_song_name_textView);
        displaySong.setText(songName);


    }
}
