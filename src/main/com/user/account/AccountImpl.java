package main.com.user.account;

import main.com.user.User;

import java.util.List;

public interface AccountImpl
{
    void addBeneficiary(User user);

    void setBalance(float amount);

    List<User> getBeneficiaries();

    float getBalance();
}
