package main.com.transactions;

import main.com.app.App;
import main.com.generic.GoBackService;
import main.com.generic.SubServiceImpl;
import main.com.service.Service;

import java.util.HashMap;
import java.util.List;

public class TransactionsService extends Service implements SubServiceImpl
{
    private List<Transaction> getAllTransactions()
    {
        return App.getUser().getTransactions();
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

        this.showServicePrompt("All Transactions");
    }

    private void showTransactions()
    {
        var transactions = getAllTransactions();
        if (transactions.isEmpty())
        {
            System.err.println("You have no list of transaction");
        } else
        {
            for (Transaction t : transactions)
            {
                System.out.println(t.toString());
            }
        }

        showBackOption();
    }

    public TransactionsService(String name)
    {
        super(name);
    }

    public void init()
    {
        showTransactions();
    }
}
