package AndrewWebServices;

import java.util.concurrent.TimeUnit;

/*
 * RecSys is an implementation of the AndrewWS recommendation system which uses super advanced machine learning to given movie recommendations. 
 * 
 * DO NOT MODIFY this class.
 */
public class RecSys {
    public String getRecommendation(String accountName) {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Animal House";
    }
}
