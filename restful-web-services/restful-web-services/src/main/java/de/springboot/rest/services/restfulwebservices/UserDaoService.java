package de.springboot.rest.services.restfulwebservices;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> userList=new ArrayList<>();

    static {
        userList.add(new User(1,"dimi",new Date()));
        userList.add(new User(2,"dimi2",new Date()));
        userList.add(new User(3,"dimi3",new Date()));
    }

    public List<User> findALl(){
        return userList;
    }

    public User save(User user){
        userList.add(user);
        return  user;
    }

    public User findOne(int id){
        for(User user : userList){
            if(user.getId().equals(id)){
                return user;
            }
        }
        return null;
    }

    public User deleteById(int id){
        for(User user : userList){
            if(user.getId().equals(id)){
                userList.remove(user);
                return user;
            }
        }
        return null;
    }
}
