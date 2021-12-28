
public class BlockValidator{

    //This will keep checking of any of the block is hacked in the chain

    //we have to check if hash of i-1th block is equal to the hash
    //call this method when each new bloc is created
    public static boolean blockverifier(){
        Block currentBlock;
        Block previousBlock;


        for(int i=1;i<TesterBankMangement.blocks.size();i++){
            currentBlock = TesterBankMangement.blocks.get(i);
            previousBlock = TesterBankMangement.blocks.get(i-1);
            if(currentBlock.getPreviousHash().equals(previousBlock.getHash()) && currentBlock.calculateHash().equals(currentBlock.getHash()) ){
                continue;

            }
            else {
                return false;
            }

        }
        return true;


    }
}
