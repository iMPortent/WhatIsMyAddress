package nyc.c4q.whatismyaddress;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by MarckemX on 11/23/17.
 */

public class EmailAddress {
    private String theAddress;
    private long createdAt;
    private String key;


    public EmailAddress(String theAddress, long createdAt){
        this.theAddress = theAddress;
        this.createdAt = createdAt;
        setKey();
    }

    public EmailAddress(String theAddress){
        this.theAddress = theAddress;

        Date currentTime = new Date(System.currentTimeMillis());
        createdAt = currentTime.getTime();

        setKey();
    }

    public String getTheAddress(){
        return theAddress;

    }

    public long getTimeCreated(){
        return createdAt;
    }

    public void setCreatedAt(long createdAt){
        this.createdAt = createdAt;
    }

    private boolean checkKey(){
        return (theAddress!=null && createdAt!=0);
    }

    private void setKey(){
        if(checkKey()){
            key = theAddress + ","  + createdAt;
        }
    }

    public String getKey(){
        return key;
    }

}
