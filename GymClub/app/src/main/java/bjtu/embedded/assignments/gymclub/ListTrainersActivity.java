package bjtu.embedded.assignments.gymclub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import bjtu.embedded.assignments.gymclub.Model.MyAdapter;
import bjtu.embedded.assignments.gymclub.Model.MyObject;

public class ListTrainersActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<MyObject> cards = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_trainers);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        cards.add(new MyObject("John","john"));
        cards.add(new MyObject("Kelly", "kelly"));
        cards.add(new MyObject("Chuck", "chuck"));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(new MyAdapter(cards));
    }
}
