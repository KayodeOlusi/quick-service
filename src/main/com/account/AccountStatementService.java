package main.com.account;

import main.com.app.App;
import main.com.generic.GoBackService;
import main.com.service.Service;
import main.com.generic.SubServiceImpl;
import main.com.transactions.Transaction;

import java.util.HashMap;

public class AccountStatementService extends Service implements SubServiceImpl
{
    private void logUserAccountDetails()
    {
        System.out.println("\n" + "• Account Statement");

        var user = App.getUser();
        System.out.println("Name: " + user.getName());
        System.out.println("Balance: " + user.getBalance() + "\n");

        showBackOption();
    }

    private HashMap<Integer, Service> baseServiceOpts()
    {
        var opts = new HashMap<Integer, Service>();
        opts.put(1, new GoBackService("Borrow Points"));

        return opts;
    }

    private void showBackOption()
    {
        String[] options = new String[] { "1. Back" };

        this.addOptions(options);
        this.setAllowedOptions(baseServiceOpts());

        this.showServicePrompt("Account Statement");
    }

    public AccountStatementService(String name)
    {
        super(name);
    }

    public void init()
    {
        logUserAccountDetails();
    }
}
