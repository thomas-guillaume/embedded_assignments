package bjtu.embedded.assignments.gymclub;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import bjtu.embedded.assignments.gymclub.Model.Video;

public class ListVideosActivity extends AppCompatActivity {

    private ArrayList<Video> videoList = new ArrayList<>();
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_videos);

        layout = (LinearLayout)findViewById(R.id.layout);

        // Create instances of video
        Video video = new Video("vid", "Calisthenics, the power of physical exercise", "https://static.videezy.com/system/resources/previews/000/005/825/original/Images_de_recurs_documentaci%C3%B3.mp4");
        Video video1 = new Video("vid", "A girl exercising on a stationary bike in a gym", "https://static.videezy.com/system/resources/previews/000/020/133/original/cardio2.mp4");
        Video video2 = new Video("vid", "Male Running On A Sidewalk Through A Neighborhood", "https://static.videezy.com/system/resources/previews/000/002/818/original/RunningMale.mp4");
        Video video3 = new Video("vid", "Abs workout", "https://static.videezy.com/system/resources/previews/000/005/840/original/5.mp4");
        Video video4 = new Video("vid", "Female athlete doing biceps curl", "https://static.videezy.com/system/resources/previews/000/007/005/original/MR8_8168.mp4");
        Video video5 = new Video("vid", "Street workout - push ups combo", "https://static.videezy.com/system/resources/previews/000/005/824/original/MVI_5012.mp4");
        Video video6 = new Video("vid", "Athlete runs and pauses for breath", "https://static.videezy.com/system/resources/previews/000/006/999/original/MR8_8198.mp4");
        Video video7 = new Video("vid", "Athlete warming up with jumping jack", "https://static.videezy.com/system/resources/previews/000/005/846/original/01.mp4");

        // Add videos to the list
        videoList.add(video);
        videoList.add(video1);
        videoList.add(video2);
        videoList.add(video3);
        videoList.add(video4);
        videoList.add(video5);
        videoList.add(video6);
        videoList.add(video7);

        for(int i=0; i<videoList.size(); i++) {

            // afiche la video dans la list view et redirection vers video view
            Video vid = videoList.get(i);
            display(vid);
        }
    }

    private void display(final Video video) {

        LinearLayout linearLayout = new LinearLayout(this);
        LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lparams.setMargins(5,5,5,5);
        linearLayout.setLayoutParams(lparams);
        linearLayout.setBackgroundColor(getResources().getColor(R.color.white));


        ImageButton imageButton = new ImageButton(this);
        Bitmap bmThumbnail;
        MediaMetadataRetriever m_mediaMetadataRetriever = null;
        try
        {
            // Get the thumbnail from the video
            m_mediaMetadataRetriever = new MediaMetadataRetriever();
            m_mediaMetadataRetriever.setDataSource(video.getUrl());
            bmThumbnail = m_mediaMetadataRetriever.getFrameAtTime(0);
            imageButton.setImageBitmap(bmThumbnail);
        }
        catch (Exception m_e)
        {
            // Put a default thumbnail
            int id = getBaseContext().getResources().getIdentifier(video.getImage(), "drawable", getBaseContext().getPackageName());
            imageButton.setBackgroundResource(id);
        }
        LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams(0, 250);
        imageParams.weight = 1;
        imageButton.setLayoutParams(imageParams);
        imageButton.setScaleType(ImageView.ScaleType.CENTER_CROP);
        linearLayout.addView(imageButton);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListVideosActivity.this, VideoActivity.class);
                intent.putExtra("url", video.getUrl());
                startActivity(intent);
            }
        });


        TextView textView = new TextView(this);
        textView.setText(video.getDescription());
        textView.setTextSize(20);
        LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT);
        textParams.weight = 2;
        textParams.setMargins(5,5,5,5);
        textParams.gravity = Gravity.CENTER_VERTICAL;
        textView.setLayoutParams(textParams);
        linearLayout.addView(textView);

        layout.addView(linearLayout);
    }
}
