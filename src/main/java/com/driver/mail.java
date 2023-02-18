package com.driver;

import java.util.Date;

public class mail {
    String sender;
    Date date;
    String message;
    public mail(Date date,String sender,String message){
        this.sender=sender;
        this.date=date;
        this.message=message;
    }
}
