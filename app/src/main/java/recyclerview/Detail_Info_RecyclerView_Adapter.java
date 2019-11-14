package recyclerview;

import android.content.Context;
import android.content.Intent;
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

import com.bumptech.glide.Glide;
import com.example.time_line.Detail_Info;
import com.example.time_line.R;

import java.util.List;

import entity.Get_detail_info;
import entity.InFormationItem;

public class Detail_Info_RecyclerView_Adapter extends RecyclerView.Adapter<Detail_Info_RecyclerView_Adapter.IraHolder> {
    private Context mContext;
    private Get_detail_info inFormationItem;
    private int position;
    private Detail_Info_RecyclerView_Adapter.IraHolder viewHolder;
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

    public Detail_Info_RecyclerView_Adapter(Context mContext, Get_detail_info inFormationItem){
        this.mContext=mContext;
        this.inFormationItem=inFormationItem;
    }
    @NonNull
    @Override
    public Detail_Info_RecyclerView_Adapter.IraHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new IraHolder(LayoutInflater.from(mContext).inflate(R.layout.recyclerview_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final IraHolder holder, final int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
        if(payloads.isEmpty()){
            onBindViewHolder(viewHolder,position);
        }
        else {
            Glide.with(mContext).load(inFormationItem.geturl(position)).into(viewHolder.imageView);
        }
        /*viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext,Detail_Info.class);
                Bundle bundle=new Bundle();
                bundle.putString("item_name",inFormationItem.getItemname(viewHolder.getAdapterPosition()));
                bundle.putString("item_img_ulr",inFormationItem.getItem_img_url(viewHolder.getAdapterPosition()));
                bundle.putInt("item_index",viewHolder.getAdapterPosition());
                intent.putExtra("value",bundle);
                mContext.startActivity(intent);
            }
        });*/
    }
    @Override
    public void onBindViewHolder(@NonNull Detail_Info_RecyclerView_Adapter.IraHolder viewHolder, int i) {
        this.viewHolder=viewHolder;
        this.position=i;
        viewHolder.textView.setText(inFormationItem.getname(i));
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
        //Log.d("name",inFormationItem.getname(0));
        int length=inFormationItem.getLength();
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
