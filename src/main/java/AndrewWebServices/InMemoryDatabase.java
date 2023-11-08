package AndrewWebServices;

/*
 * InMemoryDatabase is a fake for the AndrewWS database which is used to improve test efficiency.
 * Remember, fakes are fully functional classes with simplified implementation.
 * What is the simplest core functionality that we need for a functional database?
 * 
 * Hint: there are two methods you need to implement
 */
public class InMemoryDatabase extends Database/* should there be something here? */ {
    // Implement your fake database here
    @Override
    public int getPassword(String accountName) {
        // What should this method return?
        if (accountName == "Scotty") {
            return 17214;
        }
        return 0;
    }
}