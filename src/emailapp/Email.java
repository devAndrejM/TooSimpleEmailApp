package emailapp;

import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private int defaultPasswordLength = 10;
    private String department;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private String email;
    private String companySuffix = "company.com";

    //Constructor to receive the first name and last name
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("EMAIL CREATED: " + this.lastName +" " + this.firstName);

        //Call a method asking for the department - return the department
        this.department = setDepartment();


        //Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: "+ this.password);

        //Combine and generate email
        email = firstName.toLowerCase()+ "." + lastName.toLowerCase() + "@" + department + "-" + companySuffix;


    }

    //Ask for department
    private String setDepartment(){
        System.out.println("New worker: " + firstName + ". DEPARTMENT CODES:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if(depChoice==1){
            return "sales";
        }
        else if(depChoice==2){
            return "development";
        }
        else if(depChoice==3){
            return "accounting";
        }
        else{
            return "";
        }

    }

    //Generate random password
    private String randomPassword(int length){
        String passwordSet= "ABCDEFGHIJKLMNOPQRSTUWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for(int i=0;i<length;i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i]= passwordSet.charAt(rand);
        }
        return new String(password);
    }

    //Set mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    //Set alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail=altEmail;
    }

    //Change password
    public void changePassword(String password){
        this.password = password;
    }

    public int getMailboxCapacity() {return mailboxCapacity;}
    public String getAlternateEmail() {return alternateEmail;}
    public String getPassword(){return password;}

    public String showInfo(){
        return "DISPLAY NAME: " + firstName + " " + lastName + "\nCOMPANY EMAIL: " +email + "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}
