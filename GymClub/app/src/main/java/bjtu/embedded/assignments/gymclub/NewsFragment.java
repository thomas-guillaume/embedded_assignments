package bjtu.embedded.assignments.gymclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class NewsFragment extends Fragment {

    private ImageButton trainers;
    private ImageButton videos;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle saveInstanceState){
        View v = inflater.inflate(R.layout.fragment_news, container, false);

        trainers = (ImageButton) v.findViewById(R.id.list_trainers);
        videos = (ImageButton) v.findViewById(R.id.list_videos);

        trainers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ListTrainersActivity.class);
                startActivity(intent);
            }
        });

        videos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ListVideosActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }
}
