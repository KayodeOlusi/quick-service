package main.com.account;

import main.com.user.User;

import java.util.List;
import java.util.ArrayList;

public class Account implements IAccount
{
    private int balance;
    private final List<User> beneficiaries = new ArrayList<User>();

    public Account() {}

    public Account(int balance)
    {
        this.balance = balance;
    }

    public void addUser(User user)
    {
        this.beneficiaries.add(user);
    }

    public void setBalance(int amount)
    {
        this.balance = amount;
    }
}
