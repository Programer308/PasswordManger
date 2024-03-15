import java.util.Scanner;

public class StoredAccounts {

    Account accounts[];                               
    public int numOfAccount;
    static final int MAX_CAPACITY = 9;

    CaesarCipher caesarCipher = new CaesarCipher();

    PasswordEncryption passwordEncryption;
    
    // Defualte constracter
    public StoredAccounts() {
        accounts = new Account[MAX_CAPACITY] ;      // maxmim 10 Account for each user.
        this.numOfAccount=0;
    }



    //add account
    public boolean addAccount(Account newAccount){
        if(numOfAccount==accounts.length){
        System.out.println("You have 10 Accounts. Cannot add new Account.");
        return false;}
        
        else{
        accounts[numOfAccount++] = new Account(newAccount);
        return true;}
    }



     //add account delete account
    public boolean deleteAccount(Account account){
        boolean foundAccount = searchAccount(account);  //Use the method search,to check if the "account" is exsist.                               
                                                    
        if(foundAccount){
            for(int i = 0; i < numOfAccount; i++){
           //     if(this.accounts[i] == foundAccount){                //Finding the "account" index in the Array.
                    this.accounts[i] = this.accounts[numOfAccount-1];
                    this.accounts[numOfAccount-1] = null;
                    numOfAccount--;
                    System.out.println("Account deleted successfully!");
                    return true;
                }
            }
            System.out.println("Error: Account not found or couldn't be deleted.");
            return false;
        }

        public void deleteAccountByServiceName(int accountIndex) {
            if (accountIndex >= 0 && accountIndex < numOfAccount) {
                // Shift all accounts down to remove the gap
                for (int j = accountIndex; j < numOfAccount - 1; j++) {
                    accounts[j] = accounts[j + 1];
                }
                // Nullify the last element after shifting
                accounts[numOfAccount - 1] = null;
                numOfAccount--;
                System.out.println("Account successfully deleted.");
            } else {
                System.out.println("Deletion process aborted or account not found.");
            }
        }
        
       
    

     // Check if the accounts array is full
    public boolean isAccountArrayFull() {

        if(numOfAccount==MAX_CAPACITY)
        	return true;
        else
        	return false;
    }

    public boolean isAccountArrayEmpty() {

        if(numOfAccount==0){
            System.out.println("Error: There is not accounts add yet.");
            return true;
        }
        
        else
        return false;
    }

    public void displayAccounts() {

        System.out.println("--------------[Stored Accounts]-------------");
        for (int i = 0; i < numOfAccount; i++) {
            // Check if the current account is not null before accessing its properties
            if (accounts[i] != null) {
                System.out.println("Service name: " + accounts[i].getServiceName());
                System.out.println("Username: " + accounts[i].getUsername());
                String encryptedPassword =  accounts[i].getPassword();
                String decryptedPassword = caesarCipher.decryptPassword(encryptedPassword);
                System.out.println("Password: " + decryptedPassword);                           //decrypting       
                System.out.println(ratePassword(encryptedPassword));
                System.out.println("----------------------------------------------");
            } 
            else {
                System.out.println("Error: Account at index " + i + " is null.");
            }
        }
       
    }
    
    

     // Original searchAccount method
     public Account searchAccount(String username) {
        for (int i=0; i < numOfAccount; i++) {
            if (accounts[i].getUsername().equalsIgnoreCase(username)) {
                return accounts[i];    // Rerurnt the index of the account if it's found.
            }
        }
        return null; // Account not found
    }

    // another searchAccount method
    public boolean searchAccount(Account accountToSearch) {
        for (int i = 0; i < this.accounts.length; i++) {
            // Check if the current element is not null before accessing its properties
            if (this.accounts[i] != null &&
                this.accounts[i].getServiceName() != null &&
                this.accounts[i].getServiceName().equalsIgnoreCase(accountToSearch.getServiceName()) &&
                this.accounts[i].getUsername() != null &&
                this.accounts[i].getUsername().equalsIgnoreCase(accountToSearch.getUsername()) &&
                this.accounts[i].getPassword() != null &&
                this.accounts[i].getPassword().equals(accountToSearch.getPassword())) {
                System.out.println("The Account is found!");
                return true;
            }
        }
        System.out.println("Error: The account is not found!");
        return false;
    }

// Search by ServiceName method
public boolean searchAccountByServiceName(String serviceName) {
    Scanner scanner = new Scanner(System.in); // Create a Scanner object for reading input

    for (int i = 0; i < numOfAccount; i++) {
        // Check if the current account is not null and the serviceName matches (ignore case)
        if (accounts[i] != null && accounts[i].getServiceName().equalsIgnoreCase(serviceName)) {
            System.out.println("Account found for service: " + serviceName);
            
            // Ask the user if they want to see the account details
            System.out.println("");
            System.out.print("Do you want to see the account details? [Yes | No]");
            String response = scanner.next(); // Read user response
            while (!response.equalsIgnoreCase("yes") && !response.equalsIgnoreCase("no")) {
             	System.out.println("Incrorrect value!");
                System.out.print("Do you want to see the account details? [Yes | No]");
                response = scanner.next();
            }
            
            if (response.equalsIgnoreCase("yes")) {
            	// See if we can use displayAccounts() method instead of the below code (Important)
            	// displayAccounts();
            	
                // Display account details
                System.out.println("");
                System.out.println("Service name: " + accounts[i].getServiceName());
                System.out.println("Username: " + accounts[i].getUsername());
                String encryptedPassword =  accounts[i].getPassword();
                String decryptedPassword = caesarCipher.decryptPassword(encryptedPassword);
                System.out.println("Password: " + decryptedPassword);                           //decrypting       
                System.out.println(ratePassword(encryptedPassword) + "\n");
                // Optionally, include other details you wish to show
            }
            
            return true; // Account found
        }
    }
    System.out.println("Account not found for service: " + serviceName);
    return false; // Account not found
}


    public boolean login(String username, String password) {
        for (int i = 0; i < numOfAccount; i++) {
            if (accounts[i].getUsername().equals(username) && accounts[i].getPassword().equals(password)) {
                System.out.println("Login successful!");
                return true;
            }
        }
    
        System.out.println("Login failed. Please check your username and password.");
        return false;
    }

            
    
    public String ratePassword(String password) {
        int strengthPoints = 0;

        // Criteria 1: Length (>= 8 characters)
        if (password.length() >= 8) strengthPoints++;

        // Criteria 2: Upper and Lower case
        if (password.matches(".*[a-z].*") && password.matches(".*[A-Z].*")) strengthPoints++;

        // Criteria 3: Includes number
        if (password.matches(".*[0-9].*")) strengthPoints++;

        // Criteria 4: Special character
        if (password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*")) strengthPoints++;

        // Additional length criteria for stronger passwords
        if (password.length() >= 12) strengthPoints += 2;
        if (password.length() >= 16) strengthPoints += 2;

        // Calculate the strength rating
        String strengthBar = "Password Strength: [";
        String rating;
        for (int i = 0; i < 8; i++) {
            if (i < strengthPoints) strengthBar += "■";
            else strengthBar += " ";
        }
        strengthBar += "]";

        // Assigning a textual rating based on strengthPoints
        if (strengthPoints <= 2) rating = "Very Weak";
        else if (strengthPoints <= 4) rating = "Weak";
        else if (strengthPoints <= 6) rating = "Good";
        else if (strengthPoints == 7) rating = "Strong";
        else rating = "Excellent";

        return strengthBar + " (" + rating + ")";
    }


    

}
    