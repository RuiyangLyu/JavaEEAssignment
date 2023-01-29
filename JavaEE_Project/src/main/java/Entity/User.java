package Entity;

public class User {

    String Username;
    int ID;
    String Password;
    int RoleLevel;//管理员-0 普通用户-1
    boolean Status; //true-正常 false-停用


    public User(String username,int ID,String Password,int RoleLevel,boolean Status) {

    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getRoleLevel() {
        return RoleLevel;
    }

    public void setRoleLevel(int roleLevel) {
        RoleLevel = roleLevel;
    }

    public boolean getStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }


}
