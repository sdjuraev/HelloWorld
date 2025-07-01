public class User {
    private int userID;
    private String name;
    private String email;
    private String password;
    User(int userID, String name, String email, String password){
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public void printUser(){
        System.out.println(this.userID+" "+ this.name);
    }


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
