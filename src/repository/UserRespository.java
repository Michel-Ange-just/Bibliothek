package repository;
import exception.UserException;
import model.User;

import java.util.HashSet;

public class UserRespository {

    HashSet<User> users;

    public UserRespository(){
        users = new HashSet<>();
    }

    public boolean addUser(User user) throws UserException {
        if(users.contains(user)){
            throw new UserException("User already exists");
        }
        else{

            users.add(user);
            System.out.println("new user added");
            return true;
        }
    }

    public void addUser(String userName) throws UserException {
        boolean exists = isUserExists(userName);
        if(exists){
            throw new UserException("User already exists");
        }
        users.add(new User(userName));
        System.out.println("new user added");
    }

    public boolean removeUser(User user) throws UserException {
        if(users.contains(user)){
            users.remove(user);
            System.out.println("user removed");
            return true;
        }
        throw new UserException("The user don't exitst");

    }

    public boolean isUserExists(User user) throws UserException {
        return users.contains(user);
    }

    public boolean isUserExists(String userName) throws UserException {
        User user1 = users.stream().filter(user -> user.getName().equals(userName)).findFirst().orElse(null);
        if(user1 == null){
            throw new UserException("The user doesn't exist");
        }
        return true;
    }

    public User findUserByName(String userName) throws UserException {
        User user1 = users.stream().filter(user -> user.getName().equals(userName)).findFirst().orElse(null);
        if(user1 == null){
            throw new UserException("User not found");
        }
        return user1;
    }
}
