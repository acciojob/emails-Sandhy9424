package com.driver;

public class Email {

    private String emailId;
    private String password;


    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        if(oldPassword==password&&meetconditions(newPassword)){
            password=newPassword;
        }
    }
    boolean meetconditions(String s){
        if(s.length()<8){
            return false;
        }
       boolean a=false;
        boolean b=false;
        boolean c=false;
        boolean d=false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)<='Z'&&s.charAt(i)>='A'){
                a=true;
            }
            else if(s.charAt(i)<='z'&&s.charAt(i)>='a'){
                b=true;
            }
            else if(s.charAt(i)<='9'&&s.charAt(i)>='0'){
                c=true;
            }
            else if(s.charAt(i)<=96&&s.charAt(i)>=46){
                d=true;
            }
        }
        if(a==false||b==false||c==false||d==false){
            return false;
        }
        return true;
    }
}
