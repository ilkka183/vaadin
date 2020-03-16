package com.profitsoftware;

import java.util.ArrayList;


public class Users extends ArrayList<User>
{
  public Users()
  {
    add(new User("ilkka", "huuhaa", "Ilkka", "Salmenius"));
    add(new User("antti", "huuhaa", "Antti", "Laurila"));
    add(new User("teppo", "huuhaa", "Teppo", "Testaaja"));
  }

  public User find(String username)
  {
    for (User user : this)
      if (user.getUsername().equals(username))
        return user;

    return null;
  }
}
