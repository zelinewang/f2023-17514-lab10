package AndrewWebServices;

import java.util.concurrent.TimeUnit;

/*
 * Database is an implementation of AndrewWS database. 
 * 
 * DO NOT MODIFY this class. 
 */
public class Database {
    public int getPassword(String accountName) {
        try {
            TimeUnit.SECONDS.sleep(10);
            if (accountName == "Scotty") {
                return 17214;
            } else {
                return 0;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return -1;
    }
}