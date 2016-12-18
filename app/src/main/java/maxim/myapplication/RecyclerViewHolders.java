package maxim.myapplication;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class RecyclerViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener{
    private final String TAG = "MainLOG";
    public TextView Title;
    public TextView Author;
    public ImageView imageViewMin;
    private List<ItemObject> posts;
    public RecyclerViewHolders(View itemView,List<ItemObject> posts) {
        super(itemView);
        this.posts=posts;
        itemView.setOnClickListener(this);
        Title = (TextView)itemView.findViewById(R.id.title);
        Author = (TextView)itemView.findViewById(R.id.author);
        imageViewMin=(ImageView)itemView.findViewById(R.id.imageViewMin);
    }
    @Override
    public void onClick(View view) {
        int x=getAdapterPosition();
        Log.d(TAG, "Response " + x);
        Intent intent = new Intent(itemView.getContext(), NewsActivity.class);
        intent.putExtra("test",posts.get(x));
        itemView.getContext().startActivity(intent);
    }
}