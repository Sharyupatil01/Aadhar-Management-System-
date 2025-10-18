

import java.util.HashMap;
public class AadharManager implements AadharService {
    private HashMap<String , AadharHolder> database=new HashMap<>();

    @Override
    public void addAadharHolder(AadharHolder aadharHolder) {
        database.put(aadharHolder.getAdharNumber(),aadharHolder);

    }

    @Override 
    public AadharHolder viewAadhar(String aadharNumber) {
        return database.get(aadharNumber);
    }

    @Override
    public boolean deleteAadhar(String aadharNumber) {
        return database.remove(aadharNumber)!=null;
    }

    @Override
    public boolean updateAadhar(String aadharNumber,String newAddress, String newPhone) {
        AadharHolder holder=database.get(aadharNumber);

        if(holder!=null)
        {
            holder.setAddress(newAddress);
            holder.setPhone(newPhone);
            return true;
        }
        return false;


    }

    public HashMap<String , AadharHolder> getDatabase() {
        return database;
    }


    
}
