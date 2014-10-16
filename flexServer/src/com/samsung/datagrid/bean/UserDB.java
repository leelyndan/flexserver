package com.samsung.datagrid.bean;

import java.util.HashSet;
import java.util.Set;

public class UserDB
{
    private static Set<User> userCollection = new HashSet<User>();
    
    static
    {
        initDataSource();
    }
    
    public static Set<User> getUserCollection()
    {
        
        return userCollection;
    }
    
    public static void setUserCollection(Set<User> userCollection)
    {
        
        UserDB.userCollection = userCollection;
    }
    
    public static void initDataSource()
    {
        User user = new User();
        user.setUserId("Lucy");
        user.setSex("Female");
        user.setAge(22);
        user.setPassword("111111");
        userCollection.add(user);
        User user2 = new User();
        user2.setUserId("Lily");
        user2.setPassword("111111");
        user2.setSex("Female");
        user2.setAge(23);
        userCollection.add(user2);
    }
}
