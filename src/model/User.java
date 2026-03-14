package model;
import util.IdGeneretor;

public class User {
    private final String name;
    private final String id;
    private static int numberOfUser = 0;

    public User(String name){
        this.name = name;
        this.id = IdGeneretor.generate("User-", 1);
        numberOfUser++;
    }

    public static int getNumberOfUser() {
        return numberOfUser;
    }

    public String getName(){return this.name;}

    public String getId(){return this.id;}


}
