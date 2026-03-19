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
        for(User user : users){
            if(user.getName().equals(userName)){
                throw new UserException("User exists already");
            }
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
        for(User user : users){
            if(user.getName().equals(userName)){
                return true;
            }
        }
        return false;
    }

    public User findUserByName(String userName) throws UserException {
        for(User user : users){
            if(user.getName().equals(userName)){
                return user;
            }
        }

        throw new UserException("The user does not exist");
    }
}
