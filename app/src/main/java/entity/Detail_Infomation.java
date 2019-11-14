package entity;

public class Detail_Infomation {
    private String item_name;
    private String item_img_url;
    private int index;
    public Detail_Infomation(String item_name,String item_img_url,int index){   //跳转到当前Activity时获取到的数据，为高达剧集的名字，剧集图片的url，在information中的位置，
        this.item_name=item_name;
        this.item_img_url=item_img_url;
        this.index=index;
    }
    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }
    public void setItem_img_url(String item_img_url) {
        this.item_img_url = item_img_url;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public String getItem_name() {
        return item_name;
    }
    public String getItem_img_url() {
        return item_img_url;
    }
    public int getIndex() {
        return index;
    }
}
