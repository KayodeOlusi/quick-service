package main.com.user;

import main.com.account.Account;

public class User extends Account implements UserImpl
{
    private final String name;
    private final String password;

    public User (String name, String password)
    {
        super();
        this.name = name;
        this.password = password;
    }

    public String getName()
    {
        return name;
    }

    public static void main(String[] args)
    {

    }
}
