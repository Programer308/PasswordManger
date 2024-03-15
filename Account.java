import java.util.*;
public class Account {

    private String username;
    private String password;
    private String serviceName;
   // private String email;
    private boolean socialAccount;
    private boolean emailAccount;
    private User user;
    
    
    Scanner scanner = new Scanner(System.in);

    // Copy constracter
    public Account(Account account) {
        this.serviceName = account.getServiceName();
        this.username = account.getUsername();
        this.password = account.getPassword();
        this.socialAccount = account.isSocialAccount();
        this.emailAccount = account.isEmailAccount();
    }


    // Defulte constracter

    public Account() {
        this.serviceName = null;
        this.username = null;
        this.password = null;
        this.socialAccount = false;
        this.emailAccount = false;
    }
    

    // Create a new Account object
    public Account createAccount(String serviceName, String username, String passsword , boolean socialAccount, boolean emailAccount){

        Account newAccount = new Account();
        
        newAccount.serviceName = serviceName;
        newAccount.username = username;
        newAccount.password = passsword;
        newAccount.socialAccount = socialAccount;
        newAccount.emailAccount = emailAccount;

        return newAccount;

    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public String getServiceName() {
        return serviceName;
    }


    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }


    public boolean isSocialAccount() {
        return socialAccount;
    }


    public void setSocialAccount(boolean socialAccount) {
        this.socialAccount = socialAccount;
    }


    public boolean isEmailAccount() {
        return emailAccount;
    }


    public void setEmailAccount(boolean emailAccount) {
        this.emailAccount = emailAccount;
    }


    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }


    public Scanner getScanner() {
        return scanner;
    }


    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }













    //Setters & Getters


    
    

}