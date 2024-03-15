import java.util.*;
public class User {
    

    private String username;
    private String nickName;
    private String password;

Scanner scanner = new Scanner(System.in);
    

    
    // copy constracter (compositon realtoin with User)
    public User(User user) {
        this.username = user.getUsername();
        this.nickName = user.getNickName();
        this.password = user.getPassword();  
    }

    
    
    // defalte constracter
   public User() {
   this.username = null; 
   this.nickName = null; 
   this.password = null; 
   }




// Create a new User object
   public static User createUser(String username, String nickName, String password) {
    User newUser = new User(); 
    newUser.username = username;
    newUser.nickName = nickName;
    newUser.password = password;

    return newUser;
}

   
    // Setters & getters

    
    public String getUsername() {
        return username;
    }




    public void setUsername(String username) {
        this.username = username;
    }







    public String getNickName() {
        return nickName;
    }




    public void setNickName(String nickName) {
        this.nickName = nickName;
    }




    public String getPassword() {
        return password;
    }




    public void setPassword(String password) {
        this.password = password;
    }

    





    


    
    
}