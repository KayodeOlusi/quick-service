package main.com.user;

import main.com.account.Account;

public class User extends Account
{
    private final String name;
    private final int password;

    public User (String name, int password)
    {
        super();
        this.name = name;
        this.password = password;
    }

    public static void main(String[] args)
    {

    }
}
