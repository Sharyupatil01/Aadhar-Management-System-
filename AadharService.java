public interface AadharService {
    //eka aadhar madhye kay kay asla pahije 
    //only standard with abstract methods are imposed here 
    void addAadharHolder(AadharHolder aadharHolder);

    AadharHolder viewAadhar(String aadharNumber);

    boolean updateAadhar(String aadharNumber,String newAddress, String newPhone);

    boolean deleteAadhar(String aadharNumber);

}
