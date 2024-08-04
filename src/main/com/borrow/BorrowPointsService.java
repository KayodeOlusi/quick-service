package main.com.borrow;

import main.com.generic.SubServiceimpl;
import main.com.service.Service;

public class BorrowPointsService extends Service implements SubServiceimpl
{
    public BorrowPointsService(String name)
    {
        super(name);
    }

    public void init()
    {

    }
}
