
import java.util.Scanner;
public class ConsoleUI {

 private Scanner scanner = new Scanner(System.in);
    private PasswordManager passwordManager;
    private StoredAccounts storedAccounts;
    private User user;

    //constracter
    public ConsoleUI(PasswordManager passwordManager) {
        this.passwordManager = passwordManager;
    }  
    // Defulte constracter
    public ConsoleUI() {
        
    }


    public String firstInterFace() {  
        System.out.println("");    
        System.out.println("================[Main Menu]==============");
        System.out.println(""); 
        System.out.println("Welcome to Simple Password Manager!");     // First interface Method
        System.out.println("1. Create User");
        System.out.println("2. Login");
        System.out.println("Q. Quit Program (NOTES: every thing will be deleted!)");

        String choice = getUserChoice1();

        return choice.toUpperCase();
      
    }

    public String secondInterFace(){
        System.out.println("");    
        System.out.println("================[Program Menu]==============");
        System.out.println(""); 
        //System.out.println("Welcome "+user.getNickName()+" to Simple Password Manager!");
        System.out.println("");
        System.out.println("How can i help you today? ");     // Second interface Method
        System.out.println("1. Show stored Accounts.");
        System.out.println("2. Add new Account.");
        System.out.println("3. Search for Account.");
        System.err.println("4. Delete Account.");
        System.out.println("5. Logout(Retrun to Main Menu).");

        String choice = getUserChoice2();

        return choice;

        
    }
    private String getUserChoice1() {
        System.out.print("Please Enter your choice (1,2 or Q): ");
        String choice = scanner.next().toUpperCase();
        while (!(choice.equals("1")||choice.equals("2")||choice.equals("Q")||choice.length() == 0)) {
            System.out.print("Invalid choice. Please enter 1,2 or Q: ");
            choice = scanner.next();
        }
        if(choice.equals("1") || choice.equals("2")){
        	System.out.println("Great!");
        } else if (choice.equalsIgnoreCase("q")) {
        	System.out.println("Are you sure you want to quit the program? [Yes | No]");
        	choice = scanner.next();
        	while (!choice.equalsIgnoreCase("yes") && !choice.equalsIgnoreCase("no")) {
            	System.out.println("Incrorrect value!");
            	System.out.println("Are you sure you want to quit the program? [Yes | No]");
                choice = scanner.next();
            }
            if(choice.equalsIgnoreCase("yes")){
            	choice = "q";
            }
        }
        return choice;
    }

    private String getUserChoice2() {
        System.out.print("Please Enter your choice (1,2,3,4 or 5): ");
        String choice = scanner.next().toUpperCase();
        while (!(choice.equals("1")||choice.equals("2")||choice.equals("3")||choice.equals("4")||choice.equals("5"))) {
            System.out.print("Invalid choice. Please enter 1,2,3,4 or 5: ");
            choice = scanner.next();
        }
        if(choice.equals("1") || choice.equals("2")||choice.equals("3")|choice.equals("4")){
        	System.out.println("Great!");
        }
        return choice;
    }

        // Method to display account details and ask for deletion confirmation
        public int deleteAccount(StoredAccounts accounts) {
            System.out.print("Enter the Service name of the account you want to delete: ");
            String serviceName = scanner.next();
    
            for (int i = 0; i < accounts.numOfAccount; i++) {
                if (accounts.accounts[i] != null && accounts.accounts[i].getServiceName().equalsIgnoreCase(serviceName)) {
                    // Account found, show details
                    System.out.println("Account found with ServiceName: " + serviceName);
                    System.out.println("Username: " + accounts.accounts[i].getUsername());
                    System.out.println("Password: " + accounts.accounts[i].getPassword());
    
                    // Ask if the user is sure they want to delete this account
                    System.out.println("Are you sure you want to delete this account? [Yes | No]");
                    String confirmation = scanner.next();
                    while (!confirmation.equalsIgnoreCase("yes") && !confirmation.equalsIgnoreCase("no")) {
                    	System.out.println("Incrorrect value!");
                    	System.out.println("Are you sure you want to delete this account? [Yes | No]");
                    	confirmation = scanner.next();
                    }
    
                    if (confirmation.equalsIgnoreCase("yes")) {
                        return i; // Return index of account to delete
                    } else {
                        System.out.println("Account deletion canceled.");
                        return -1; // Deletion canceled
                    }
                } else {
                	System.out.println("No account found with the specified ServiceName.");
                    return -1; // Account not found
                }
            }
            System.out.println("There is no accounts!");
            return -1; // Account not found
        }



}