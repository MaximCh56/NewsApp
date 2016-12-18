package maxim.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolders> {
    private List<ItemObject> itemList;
    private Context context;
    public RecyclerViewAdapter(Context context, List<ItemObject> itemList) {
        this.itemList = itemList;
        this.context = context;
    }
    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, null);
        return new RecyclerViewHolders(layoutView,itemList);
    }
    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        holder.Title.setText(itemList.get(position).getTitle());
        holder.Author.setText(itemList.get(position).getAuthor());
        Picasso.with(context)
                .load(itemList.get(position).getUrlToImage())
                .resize(50, 50)
                .into(holder.imageViewMin);
    }
    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}