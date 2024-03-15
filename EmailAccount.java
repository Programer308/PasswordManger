public class EmailAccount extends StoredAccounts {

    private EmailAccount emailAccount[];
    private int numOfAccounts;


    public EmailAccount() {
        //super(MAX_CAPACITY);                    // I dont know if we need it 
        emailAccount = new EmailAccount[MAX_CAPACITY];
        this.numOfAccounts =0;
    }
    

    public boolean addEmailAccount(EmailAccount emailAccount) {
        if (numOfAccounts >= this.emailAccount.length)
            return false;

        this.emailAccount[numOfAccounts] = emailAccount;
        numOfAccounts++;
        return true;
    }
    
}
