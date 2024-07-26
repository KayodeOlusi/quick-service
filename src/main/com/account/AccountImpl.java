package main.com.account;

import main.com.user.User;

public interface AccountImpl
{
    void addBeneficiary(User user);

    void setBalance(int amount);
}
