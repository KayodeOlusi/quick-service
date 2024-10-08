package main.com.user.account;

import main.com.user.User;

import java.util.List;
import java.util.ArrayList;

public class Account implements AccountImpl
{
    private float balance;
    private final List<User> beneficiaries = new ArrayList<>();

    public void addBeneficiary(User user)
    {
        this.beneficiaries.add(user);
    }

    public List<User> getBeneficiaries()
    {
        return beneficiaries;
    }

    public float getBalance()
    {
        return balance;
    }

    public void setBalance(float amount)
    {
        this.balance = amount;
    }
}
