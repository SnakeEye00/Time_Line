package entity;

public class InFormationItem {
    private int length = 0;
    private String[] itemnames;
    private String[] item_img_urls;
    private int[] images;
    public InFormationItem(){ }
    public void setLength(int number) {
        this.length = number;
        images=new int[length];
    }
    public void setImages(int[] images) {
        this.images = images;
    }
    public int[] getImages() {
        return images;
    }
    public int getImage(int i){
        return images[i];
    }
    public void setItemnames(String[] itemnames){
        this.itemnames=itemnames;
    }
    public void setItem_img_urls(String[] item_img_url){
        this.item_img_urls=item_img_url;
    }
    public int getLenght(){
        return length;
    }
    public String[] getItemnames(){
        return itemnames;
    }
    public String[] getItem_img_urls(){
        return item_img_urls;
    }
    public String getItem_img_url(int i){
        return item_img_urls[i];
    }
    public String getItemname(int i){
        return itemnames[i];
    }
}
