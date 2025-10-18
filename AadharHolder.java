public class AadharHolder extends Person {

    private String aadharNumber;
    private String issueDate;
    public AadharHolder(String name,int age, String gender , String address, String phone , String aadharNumber, String issueDate) {
        super(name,age,gender,address,phone);
        this.aadharNumber=aadharNumber;
        this.issueDate=issueDate;
    }
   public String getAdharNumber()
   {
    return aadharNumber;

   }
   public String getIssueDate()
   {
    return issueDate;
   }


   @Override  // method overriding from object class 
   public String toString()
   {
      return "<html><b>Aadhar :</b> " + aadharNumber +
             "<br><b>Issue Date :</b> " + issueDate +
             "<br><b>Name :</b> " + getName() +
             "<br><b>Age :</b> " + getAge() +
             "<br><b>Gender :</b> " + getGender() +
             "<br><b>Address :</b> " + getAddress() +
             "<br><b>Phone :</b> " + getPhone() + "</html>";

   }


    
}
