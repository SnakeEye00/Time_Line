package entity;

public class Get_detail_info {
    private int length;
    private String[] itemnames;
    private String[] item_img_urls;
    public Get_detail_info(int length){
        this.length=length;
        itemnames=new String[length];
        item_img_urls=new String[length];
    }

    public String[] getItemnames() {
        return itemnames;
    }

    public String[] getItem_img_urls() {
        return item_img_urls;
    }

    public int getLength() {
        return length;
    }

    public void setItemnames(String[] itemnames) {
        this.itemnames = itemnames;
    }

    public void setItem_img_urls(String[] item_img_urls) {
        this.item_img_urls = item_img_urls;
    }
    public String getname(int i){
        return itemnames[i];
    }
    public String geturl(int i){
        return item_img_urls[i];
    }
}
