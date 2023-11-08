package AndrewWebServices;

/**
 * AndrewWebServices contains the main functionality in our AndrewWS.
 * 
 * DO NOT MODIFY this class.
 */
public class AndrewWebServices {
    Database database;
    RecSys recommender;
    PromoService promoService;

    public AndrewWebServices(Database database, RecSys recommender, PromoService promoService) {
        this.database = database;
        this.recommender = recommender;
        this.promoService = promoService;
    }

    /*
     * Accesses the database to verify the passed account name and password.
     * 
     * Note that the database has a large latency which we don't want to interact with during testing.
     * 
     * TODO: use a fake to test this method
     */
    public boolean logIn(String accountName, int password) {
        long startTime = System.currentTimeMillis();
        if (this.database.getPassword(accountName) == password) {
            long endTime = System.currentTimeMillis();
            System.out.println("Login success! Took " + (endTime - startTime) / 1000 + " seconds");
            return true;
        }
        System.out.println("Login failed.");
        return false;
    }

    /*
     * Returns a movie as recommendation to the passed user.
     * 
     * Note that the recommender uses an ultra fancy machine learning algorithm
     * and may take very long to return results.
     * 
     * TODO: use stubs to test this method.
     */
    public String getRecommendation(String accountName) {
        long startTime = System.currentTimeMillis();
        String movie = recommender.getRecommendation(accountName);
        long endTime = System.currentTimeMillis();
        System.out.println("Recommend " + movie + ". Took " + (endTime - startTime) / 1000 + " seconds.");
        return movie;
    }

    /*
     * Sends a promotional email to the given email address using the promoService.
     * 
     * Note that the function has no return value. We want to avoid
     * actually sending emails during testing.
     * 
     * TODO: use mocks to test this method
     */
    public void sendPromoEmail(String email) {
        promoService.mailTo(email);
    }
}
