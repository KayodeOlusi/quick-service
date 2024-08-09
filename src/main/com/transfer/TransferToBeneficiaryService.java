package main.com.transfer;

import main.com.generic.SubServiceImpl;
import main.com.service.Service;

public class TransferToBeneficiaryService extends Service implements SubServiceImpl
{
    public TransferToBeneficiaryService(String name)
    {
        super(name);
    }

    public void init()
    {

    }
}
