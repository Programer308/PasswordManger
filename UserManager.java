import java.util.Scanner;

public class UserManager {

    private User users[];
    private int numOfUsers;
    private static final int MAX_CAPACITY = 3;


    // (Defulte constracter) assinign the user[] array 
    public UserManager() {
        this.users = new User[MAX_CAPACITY];       // maxmim 3 user in the program.
        this.numOfUsers = 0;
    }

    // add user method
    public boolean addUser(User newUser) {
        if (numOfUsers == users.length) {
            System.out.println("You have 3 Users. Cannot add more users.");
            return false;
        }
        users[numOfUsers++] = new User(newUser);  //for compostion relation
        return true;
    }

    //retrun the num of obj in the array "users[]"
    public User[] getUsersArray() {
        return users;                   
    }

    public boolean isUsersArrayFull() {
        return numOfUsers == users.length;
    }

     // delete user method 
    public void deleteUser(User userToDelete) {
        for (int i = 0; i < numOfUsers; i++) {
            if (users[i].equals(userToDelete)) {
                this.users[i] = this.users[numOfUsers-1];
                this.users[numOfUsers-1] = null;
                numOfUsers--;
                System.out.println("User deleted successfully!");
                return;
            }
        }
        System.out.println("User not found. Cannot delete user.");
    }


    public void displayUsers(){
        for(int i=0;i<numOfUsers;i++){
            
            System.out.println(users[i].getUsername());
            System.out.println(users[i].getNickName());
            System.out.println(users[i].getPassword());
            
        }

        
    }


    // user login , gives the user 3 attempt to login to his account.

   public boolean uselogin() {
        Scanner scanner = new Scanner(System.in);
        
        int attempts = 0;
        while(attempts < 3) {
            System.out.print("Enter username: ");
            String username = scanner.next();
            
            System.out.print("Enter password: ");
            String password = scanner.next();

            for(int i = 0; i < numOfUsers; i++) {
                if(username.equalsIgnoreCase(users[i].getUsername()) && password.equals(users[i].getPassword())) {
                    System.out.println("");
                    System.out.println("User found! , Login..");
                    return true;
                } else {
                	System.out.println("Error: User not found. Attempt " + (attempts+1) + " of 3.");
                    attempts++;
                }
            }
        }
        System.out.println("");
        System.out.println("----------------------------------");
        System.out.println("You have reached maximuim attemps!");
        System.out.println("----------------------------------");
        return false;
   }

	public boolean userExsist(User user) {      //check if the user has been
	    for(int i = 0; i < numOfUsers; i++) {   //added to the users[] array.
	        if(users[i].equals(user)) {
	            return true;
	        }
	    }
	    return false;
	}

}