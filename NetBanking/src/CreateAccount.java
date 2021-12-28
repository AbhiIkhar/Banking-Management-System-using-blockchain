public class CreateAccount  {



    // String name, String ifscCode, String branch, int acno, String email, String password
    public boolean userReg(String name, String ifscCode, String branch, int acno, long depositAmount, String email, String password){
        int i = TesterBankMangement.blocks.size();
        String prevHash = TesterBankMangement.blocks.get(i-1).getHash();
        //first check the blockchain if there is some tampering of data then proceed
        if(BlockValidator.blockverifier()) {

            TesterBankMangement.blocks.add(i, new Block(prevHash, name, ifscCode, branch,depositAmount,email,password, acno));
            System.out.println("Account Created , Your Hash is :" + TesterBankMangement.blocks.get(i).getHash());
            System.out.println("Previous Hash :"+TesterBankMangement.blocks.get(i).getPreviousHash());
            System.out.println("Caluclated hash :"+TesterBankMangement.blocks.get(i).calculateHash());
            return true;
        }
        else{
            return false;
        }



    }

}