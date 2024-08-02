package main.com.transfer;

import main.com.generic.SubServiceimpl;
import main.com.service.Service;

public class TransferService extends Service implements SubServiceimpl
{
    public TransferService(String name)
    {
        super(name);
    }

    public void init()
    {

    }
}
