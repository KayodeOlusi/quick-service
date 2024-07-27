package main.com.account;

import main.com.user.User;

import java.util.List;

public interface AccountImpl
{
    void addBeneficiary(User user);

    void setBalance(int amount);

    List<User> getBeneficiaries();

    int getBalance();
}
