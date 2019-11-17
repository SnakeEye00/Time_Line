package recyclerview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.time_line.Detail_Info;
import com.example.time_line.R;
import java.util.List;
import entity.InFormationItem;

public class Index_RecyclerView_Adapter extends RecyclerView.Adapter<Index_RecyclerView_Adapter.IraHolder> {
    private Context mContext;
    private InFormationItem inFormationItem;
    private int position;
    private Index_RecyclerView_Adapter.IraHolder viewHolder;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    Bundle bundle=msg.getData();
                    int position=bundle.getInt("position");
                    notifyItemChanged(position,"aa");
                    break;
            }
        }
    };
    public Index_RecyclerView_Adapter(Context mContext, InFormationItem inFormationItem){
        this.mContext=mContext;
        this.inFormationItem=inFormationItem;
    }
    @NonNull
    @Override
    public Index_RecyclerView_Adapter.IraHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new IraHolder(LayoutInflater.from(mContext).inflate(R.layout.recyclerview_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final IraHolder holder, final int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
        if(payloads.isEmpty()){
            onBindViewHolder(viewHolder,position);
        }
        else {
            Glide.with(mContext).load(inFormationItem.getItem_img_url(position)).into(viewHolder.imageView);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext,Detail_Info.class);
                intent.putExtra("item_name",inFormationItem.getItemname(position));
                intent.putExtra("item_img_ulr",inFormationItem.getItem_img_url(position));
                intent.putExtra("item_index",String.valueOf(position));
                Log.d("intent_put",inFormationItem.getItemname(position));
                mContext.startActivity(intent);
            }
        });
    }
    @Override
    public void onBindViewHolder(@NonNull Index_RecyclerView_Adapter.IraHolder viewHolder, int i) {
        this.viewHolder=viewHolder;
        this.position=i;
        viewHolder.textView.setText(inFormationItem.getItemname(i));
        viewHolder.imageView.setImageResource(R.drawable.loading);
        Message message=new Message();
        Bundle bundle=new Bundle();
        bundle.putInt("position",i);
        message.setData(bundle);
        message.what=1;
        handler.sendMessage(message);
    }
    @Override
    public int getItemCount() {
        //Log.d("name",inFormationItem.getItemname(0));
        int length=inFormationItem.getItem_img_urls().length;
        Log.d("Length",String.valueOf(length));
        return length;
    }
    class IraHolder extends RecyclerView.ViewHolder{    //第一步
        private ImageView imageView;
        private TextView textView;
        public IraHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.item_img);
            textView=itemView.findViewById(R.id.item_name);
        }
    }
}
