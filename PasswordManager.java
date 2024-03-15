import java.util.Scanner;

// Version 3.6

public class PasswordManager {
    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in); //Scanner

    // objs from each class
    ConsoleUI consoleUI = new ConsoleUI();            
    UserManager userManager = new UserManager();
    User user = new User();
    StoredAccounts storedAccount = new StoredAccounts();
    Account account = new Account();
    CaesarCipher caesarCipher = new CaesarCipher();
    
    
    
       
     // here we start
     String fChoice = consoleUI.firstInterFace().toUpperCase();

     if (fChoice.equalsIgnoreCase("no"))
    	 fChoice = consoleUI.firstInterFace().toUpperCase();

        while (!(fChoice.equalsIgnoreCase("Q"))) {
            
  //----------------------------------------------------------------------------------      

            switch (fChoice.toUpperCase()) {                       //Process the choice First Interface 
               
               case "F":                                           // Back to First interface
               fChoice = consoleUI.firstInterFace().toUpperCase();
               break;
               
  //----------------------------------------------------------------------------------                   
                case "1":
                
                
                System.out.println("--------------[Signing up]-------------");
                System.out.println("Do you want to go back to the main menu? [Yes | No]");
                String choice = scanner.next();
                while (!choice.equalsIgnoreCase("yes") && !choice.equalsIgnoreCase("no")) {
                	System.out.println("Incrorrect value!");
                	System.out.println("Do you want to go back to the main menu? [Yes | No]");
                    choice = scanner.next();
                }
                if(choice.equalsIgnoreCase("yes")){
	                fChoice = "F";
	                break;
                }

                boolean isUsersFull = userManager.isUsersArrayFull();
                if(isUsersFull){
                    System.out.println("You have 3 User. Cannot add new User.");
                    fChoice = "F";
                    break;
                }

                System.out.print("Enter your username: ");
                String username = scanner.next();
                System.out.print("Enter your nickName: ");
                String nickName = scanner.next();
                System.out.print("Enter your password: ");
                String password = scanner.next(); 

                user = user.createUser(username,nickName,password); // Create user   
                String userUsername = user.getUsername(); // see line 41
               
                 
                boolean isAdded = userManager.addUser(user);  //checks if the user added to the array  
                    if(!(isAdded)) { 
                        System.out.println("The User is not created, there is a problem.");                                       
                        break;
                    } else {
	                    System.out.println("");
	                    System.out.println(userUsername + " User has created Successfully!"); // go to case 2
	                    System.out.println("");
                    }
                    
                  
//----------------------------------------------------------------------------------
                case "2":  
                System.out.println("--------------[Login in]-------------");
                System.out.println("Do you want to go back to the main menu? [Yes | No]");
                choice = scanner.next();
                while (!choice.equalsIgnoreCase("yes") && !choice.equalsIgnoreCase("no")) {
                	System.out.println("Incrorrect value!");
                	System.out.println("Do you want to go back to the main menu? [Yes | No]");
                    choice = scanner.next();
                }
                if(choice.equalsIgnoreCase("yes")){
	                fChoice = "F";
	                break;
                }

                boolean userExsist = userManager.uselogin();   //Login method (Check user exsist?)
                if(userExsist){

                //System.err.println("Login..");
                fChoice = "F";
                String sChoice = "S"; // for the second interface
                int secondLoopisOn = 1;
          //========================================================================
                    
                while ( secondLoopisOn==1 && (fChoice.equals("F") || sChoice.equals("S"))) {    //Second Interface loop
                switch (sChoice.toUpperCase()) {  


                   case "S":
                                               
                   sChoice = consoleUI.secondInterFace().toUpperCase();
                   //if(sChoice.equalsIgnoreCase("3")){
                   //sChoice = "3";
                   //break;}

                    break;
                    //---------------------------------------
                   // Show stored Accounts.
                    case "1":
                    
                    //System.out.println(storedAccount.numOfAccount);
                    if(storedAccount.isAccountArrayEmpty()){
                        sChoice ="S";
                        break;
                    }
                    else {
	                    storedAccount.displayAccounts();
	                    sChoice ="S";
                        break;
                    }
                 //---------------------------------------
                 // Add new Account.
                    case "2":
                    boolean isSocialAccount = false;
                    boolean isEmailAccount = false;

                    System.out.println("--------------[Add new Account]-------------");
                    System.out.println("Do you want to go back to the program menu? [Yes | No]");
                    choice = scanner.next();
                    while (!choice.equalsIgnoreCase("yes") && !choice.equalsIgnoreCase("no")) {
                    	System.out.println("Incrorrect value!");
                    	System.out.println("Do you want to go back to the main menu? [Yes | No]");
                        choice = scanner.next();
                    }
                    if(choice.equalsIgnoreCase("yes")){
    	                sChoice = "S";
    	                break;
                    }
                    
                        
                    boolean isAccountsFull = storedAccount.isAccountArrayFull();
                    if(isAccountsFull){
	                    System.out.println("You have 10 Accounts. Cannot add new Account.");
	                    sChoice = "S";
	                    break;
                    }
                    else {
	                    System.out.print("Enter The service name: ");
	                    String serviceName = scanner.next();
	                    System.out.print("Enter your username: ");
	                    String accountName = scanner.next();
	                    System.out.print("Enter your password: ");
	                    String accountPassword = scanner.next(); 
	
	                    // -------- [ Social Account ] -------- //
	                    System.out.print("Is it Soical Account? [Yes | No]");
	                    String isSoical = scanner.next();
	                    while (!isSoical.equalsIgnoreCase("yes") && !isSoical.equalsIgnoreCase("no")) {
	                    	System.out.println("Incrorrect value!");
	                    	System.out.print("Is it Soical Account? [Yes | No]");
	                    	isSoical = scanner.next();
	                    }
	                    if(isSoical.equalsIgnoreCase("yes")){
	                    	isSocialAccount = true;
	                    }
	                    
	                    // -------- [ Email Account ] -------- //
	                    System.out.print("Is it Email Account? [Yes | No]");
	                    String isEmail = scanner.next();
	                    while (!isEmail.equalsIgnoreCase("yes") && !isEmail.equalsIgnoreCase("no")) {
	                    	System.out.println("Incrorrect value!");
	                    	System.out.print("Is it Email Account? [Yes | No]");
	                    	isEmail = scanner.next();
	                    }
	                    if(isEmail.equalsIgnoreCase("yes")){
	                    	isEmailAccount = true;
	                    }
	                    
	                    accountPassword = caesarCipher.encryptPassword(accountPassword); //enrypt password
	                    account = account.createAccount(serviceName, accountName, accountPassword, isSocialAccount, isEmailAccount);  //crate account 
	                    
	                    //System.out.println("is it here?");
	                   // System.out.println(storedAccount.accounts[0].getServiceName());
	                   //System.out.println("is it here?");
	                   // storedAccount.addAccount(account);
	                    
	                    boolean accountIsAdded = storedAccount.addAccount(account);  //checks if the user added to the array  
	                    if(!(accountIsAdded)) {
	                        System.out.println("The account is not added, there is a problem.");                    
	                        break;
	                    }
	                    else {
		                    System.out.println("");
		                    System.out.println("The Account has added!");
		                    sChoice = "S";
	                    }
                    }

                    break;
                 //---------------------------------------  
                 // Search for Account
                 case "3":
                 System.out.println("--------------[Search for Account]-------------");
                 System.out.println("Do you want to go back to the program menu? [Yes | No]");
                 choice = scanner.next();
                 while (!choice.equalsIgnoreCase("yes") && !choice.equalsIgnoreCase("no")) {
                 	System.out.println("Incrorrect value!");
                 	System.out.println("Do you want to go back to the main menu? [Yes | No]");
                     choice = scanner.next();
                 }
                 if(choice.equalsIgnoreCase("yes")){
 	                sChoice = "S";
 	                break;
                 }
                System.out.print("Please Enter the ServiceName: ");
                String ServiceName = scanner.next();
                storedAccount.searchAccountByServiceName(ServiceName);


                  break;
                   //---------------------------------------  
                   // Delete account


                   case "4":
                   System.out.println("--------------[Delete Account]-------------");
                   System.out.println("Do you want to go back to the program menu? [Yes | No]");
                   choice = scanner.next();
                   while (!choice.equalsIgnoreCase("yes") && !choice.equalsIgnoreCase("no")) {
                   	System.out.println("Incrorrect value!");
                   	System.out.println("Do you want to go back to the program menu? [Yes | No]");
                       choice = scanner.next();
                   }
                   if(choice.equalsIgnoreCase("yes")){
	   	                sChoice = "S";
	   	                break;
                   }
                   int accountIndexToDelete = consoleUI.deleteAccount(storedAccount);
                  
                   if (accountIndexToDelete >= 0) {
                    storedAccount.deleteAccountByServiceName(accountIndexToDelete);
                    
                   }
                  
                   break;
                   //---------------------------------------  
                  // Logout(Retrun to Main Menu)
                  case "5":
                  secondLoopisOn = 0;   // to turn off second loop
                  fChoice = "F";
                  sChoice = null; 
                  
                  System.out.println("");
                  System.out.println("Going the main page..");
                  System.out.println("");
                  break;
                //---------------------------------------
                    default:
                    secondLoopisOn=0;    // to turn off second loop
                    fChoice = "F";     
                        break;
                } //end of switch
                                                                   
                } //end of second while
                 //=====================================================================
            }  // end of if


                else{
                fChoice = "F";   // go to First Interface
                break;
                }

                
//----------------------------------------------------------------------------------
                case "Q":  
                
                
                break;

                default:
                

                    break;

           
                }

        }  // end while loop (First interface)
        


        if(fChoice.equalsIgnoreCase("q")) {
        	System.out.println("");
        	System.out.println("=============");
        	System.out.println("See you soon.");
        	System.out.println("=============");
        	System.out.println("");
        }



            }

        

    }
    
