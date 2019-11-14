package entity;

import android.graphics.Bitmap;

public class RecyclerViewItem {
    private Bitmap img;
    private String name;
    public RecyclerViewItem(Bitmap img,String name){
        this.img=img;
        this.name=name;
    }
    public void setImg(Bitmap img){
        this.img=img;
    }
    public void setName(String name){
        this.name=name;
    }
    public Bitmap getImg(){
        return img;
    }
    public String getName() {
        return name;
    }
}
