public class SocialMediaAccount extends StoredAccounts{
   
   
   
    private SocialMediaAccount account[];
    private int numOfAccounts;


    public SocialMediaAccount() {
        account = new SocialMediaAccount[MAX_CAPACITY];
        this.numOfAccounts =0;
    }
    

    public boolean addSocialMediaAccount(SocialMediaAccount SocialMediaAccount) {
        if (numOfAccounts >= this.account.length)
            return false;

        this.account[numOfAccounts] = SocialMediaAccount;
        numOfAccounts++;
        return true;
    }
}