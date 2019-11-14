package entity;

public class Check_username {
    private String username;
    private String petname;
    private String userpassword;
    private String checked;
    public Check_username(String username, String petname, String password){
        this.username=username;
        this.petname=petname;
        this.userpassword=password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPetname(String petname) {
        this.petname = petname;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

    public String getUsername() {
        return username;
    }

    public String getPetname() {
        return petname;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public String getChecked() {
        return checked;
    }
}
