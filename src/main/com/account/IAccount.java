package main.com.account;

import main.com.user.User;

public interface IAccount
{
    void addUser(User user);
    void setBalance(int amount);
}
