package bjtu.embedded.assignments.gymclub;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

public class NewsFragment extends Fragment {

    private ListView news_layout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle saveInstanceState){
        View v = inflater.inflate(R.layout.fragment_news, container, false);

        news_layout = (ListView)v.findViewById(R.id.news_layout);

        return v;
    }
}
