package recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.time_line.R;

import java.util.List;

import entity.RecyclerViewItem;

public class ItemAdapter_unused extends RecyclerView.Adapter<ItemAdapter_unused.ItemViewHolder>{
    private Context mContext;
    private List<RecyclerViewItem> recyclerViewItems;
    public ItemAdapter_unused(Context context, List<RecyclerViewItem> recyclerViewItems){
        mContext=context;
        this.recyclerViewItems=recyclerViewItems;
    }
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.recyclerview_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int i) {
        RecyclerViewItem recyclerViewItem=recyclerViewItems.get(i);
        itemViewHolder.imageView.setImageBitmap(recyclerViewItem.getImg());
        itemViewHolder.textView.setText(recyclerViewItem.getName());
    }

    @Override
    public int getItemCount() {
        return recyclerViewItems.size();
    }
    class ItemViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.item_img);
            textView=itemView.findViewById(R.id.item_name);
        }
    }
}
