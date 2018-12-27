package bjtu.embedded.assignments.gymclub.Model;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import bjtu.embedded.assignments.gymclub.InfoTrainerActivity;
import bjtu.embedded.assignments.gymclub.R;

public class MyViewHolder extends RecyclerView.ViewHolder{

    private TextView textViewView;
    private ImageView imageView;

    // itemView corresponds to 1 cell
    public MyViewHolder(final View itemView) {
        super(itemView);

        textViewView = (TextView) itemView.findViewById(R.id.text);
        imageView = (ImageView) itemView.findViewById(R.id.image);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(itemView.getContext(), InfoTrainerActivity.class);
                itemView.getContext().startActivity(intent);
            }
        });
    }


    public void bind(MyObject myObject){
        textViewView.setText(myObject.getText());
        Context context = imageView.getContext();
        int id = context.getResources().getIdentifier(myObject.getImage(), "drawable", context.getPackageName());
        imageView.setImageResource(id);
        Picasso.with(imageView.getContext());
    }
}
