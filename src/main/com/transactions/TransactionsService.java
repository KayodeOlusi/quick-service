package main.com.transactions;

import main.com.generic.SubServiceimpl;
import main.com.service.Service;

public class TransactionsService extends Service implements SubServiceimpl
{
    public TransactionsService(String name)
    {
        super(name);
    }

    public void init()
    {

    }
}
