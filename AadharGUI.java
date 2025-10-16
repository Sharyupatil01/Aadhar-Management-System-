import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.text.*;
import java.util.UUID;
import java.util.HashMap;

public class AadharGUI extends JFrame{
    private JTextField nameField;
    private JTextField ageField;
    private JTextField genderField;
    private JTextField addressField;
    private JTextField phoneField;
    private JTextField searchField;

    private JTextArea outputArea;

    private HashMap<String,String> aadharMap = new HashMap<>();
   
   //constructor 
   public AadharGUI()
   {
    setTitle("Aadhar Management System");
    setSize(600,600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());

    //=============== TOP PANEL  ================
    JPanel inputPanel=new JPanel(new GridLayout(6,2,5,5));
    inputPanel.setBorder(BorderFactory.createTitledBorder("Aadhar Details"));

    inputPanel.add(new JLabel("Name:"));
    nameField=new JTextField();
    inputPanel.add(nameField);

    inputPanel.add(new JLabel("Age:"));
    ageField=new JTextField();
    inputPanel.add(ageField);

    inputPanel.add(new JLabel("Gender:"));
    genderField=new JTextField();
    inputPanel.add(genderField);

    inputPanel.add(new JLabel("Address:"));
    addressField=new JTextField();
    inputPanel.add(addressField);

    inputPanel.add(new JLabel("Phone:"));
    phoneField=new JTextField();
    inputPanel.add(phoneField);

    JButton registerBTN=new JButton("Register Aadhar");
    inputPanel.add(registerBTN);

    add(inputPanel,BorderLayout.NORTH);

    //=============== CENTER PANEL  ================
    outputArea=new JTextArea();
    outputArea.setEditable(false);
    JScrollPane scrollPane=new JScrollPane(outputArea);
    add(scrollPane,BorderLayout.CENTER);


    //=============== BOTTOM PANEL  ================
   
    JPanel bottomPanel=new JPanel(new FlowLayout());

    searchField=new JTextField(10);
    JButton viewBTN=new JButton("View");
    JButton updateBTN=new JButton("Update");
    JButton deleteBTN=new JButton("Delete");
    JButton listBTN=new JButton("List All");
    bottomPanel.add(new JLabel("Search Aadhar:"));

    bottomPanel.add(searchField);
    bottomPanel.add(viewBTN);
    bottomPanel.add(updateBTN);
    bottomPanel.add(deleteBTN);
    bottomPanel.add(listBTN);
    add(bottomPanel,BorderLayout.SOUTH);


    // Action Listeners 

    registerBTN.addActionListener(e-> registerAadhar());
    viewBTN.addActionListener(e-> viewAadhar());
    updateBTN.addActionListener(e-> updateAadhar());
    deleteBTN.addActionListener(e-> deleteAadhar());
    listBTN.addActionListener(e-> listAllAadhar());

    setVisible(true);

   }
   private void registerAadhar()
   {
       String name=nameField.getText();
       String age=ageField.getText();
       String gender=genderField.getText();
       String address=addressField.getText();
       String phone=phoneField.getText();

       if(name.isEmpty() || age.isEmpty() || gender.isEmpty() || address.isEmpty() || phone.isEmpty())
       {
         outputArea.setText("Please fill all the fields");
         return;
       }

       String aadharNo=UUID.randomUUID().toString().substring(0, 12);
       String aadharDetails="Aadhar No: "+aadharNo+"\nName: "+name+"\nAge: "+age+"\nGender: "+gender+"\nAddress: "+address+"\nPhone: "+phone;
       aadharMap.put(aadharNo,aadharDetails);
       outputArea.setText("Aadhar Registered Successfully");

       nameField.setText("");
       ageField.setText("");
       genderField.setText("");
       addressField.setText("");
       phoneField.setText("");

   }

   private void updateAadhar()
   {
    String aadharNo=searchField.getText();
    if(!aadharMap.containsKey(aadharNo))
    {
      outputArea.setText("Aadhar Not Found");
      return;
    }
    
    String newAddress=JOptionPane.showInputDialog(this,"Enter new Addresss");
    if(newAddress!=null)
    {
      aadharMap.put(aadharNo,"Address: "+newAddress);
      outputArea.setText("Aadhar Updated Successfully");
    }
    String newPhone=JOptionPane.showInputDialog(this,"Enter new Phone");
    if(newPhone!=null)
    {
      aadharMap.put(aadharNo,"Phone: "+newPhone);
      outputArea.setText("Aadhar Updated Successfully");
    }
    String oldRecord=aadharMap.get(aadharNo);
    aadharMap.put(aadharNo,oldRecord);
    outputArea.setText("Aadhar Updated Successfully");
   }
      
     


   private void listAllAadhar()
   {
     if(aadharMap.isEmpty())
     {
       outputArea.setText("No Aadhar Found");
       return;
     }
     StringBuilder sb=new StringBuilder();
     for(Map.Entry<String,String> entry:aadharMap.entrySet())
     {
       sb.append(entry.getKey()).append("\n");
     }
     outputArea.setText(sb.toString());


   }

   private void deleteAadhar()
   {
    String aadharNo=searchField.getText();
    if(aadharMap.remove(aadharNo)!=null)
    {
      outputArea.setText("Aadhar Deleted Successfully");
    }
    else
    {
      outputArea.setText("Aadhar Not Found");
    }
   }
   
   private void viewAadhar()
   {
    String aadharNo=searchField.getText();
    if(aadharMap.containsKey(aadharNo))
    {
      outputArea.setText(aadharMap.get(aadharNo));
    }
    else
    {
      outputArea.setText("Aadhar Not Found");
    }

   }
   public static void main(String args[])
   {
    new AadharGUI();
   }

   
}
