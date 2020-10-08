import repository.Repository;
import util.DatabaseConnectionManager;

public class Main {

    public static void main(String[] args) {
        // write your code here
        DatabaseConnectionManager databaseConnectionManager = new DatabaseConnectionManager();
        Repository repository = new Repository();

        repository.createArrivalList();
        //repository.createDepartureList();
        // repository.createGateList();


    }
}
