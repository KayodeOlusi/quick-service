package main.com.borrow;

import main.com.generic.SubServiceimpl;
import main.com.service.Service;

public class BorrowService extends Service implements SubServiceimpl
{
    public BorrowService(String name)
    {
        super(name);
    }

    public void init()
    {

    }
}
