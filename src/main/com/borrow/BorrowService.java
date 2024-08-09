package main.com.borrow;

import main.com.generic.GoBackService;
import main.com.generic.SubServiceImpl;
import main.com.service.Service;

import java.util.HashMap;

public class BorrowService extends Service implements SubServiceImpl
{
    private HashMap<Integer, Service> baseServiceOpts()
    {
        var opts = new HashMap<Integer, Service>();

        opts.put(1, new BorrowPointsService("Borrow Points"));
        opts.put(2, new RepayBorrowedPointsService("Repay Borrowed Points"));
        opts.put(3, new GoBackService("Back"));

        return opts;
    }

    private void prepareBaseMenu()
    {
        String[] opts = new String[]
            {
                "1. Borrow Points",
                "2. Repay Borrowed Points",
                "3. Back"
            };

        this.addOptions(opts);
        this.setAllowedOptions(baseServiceOpts());

        this.showServicePrompt("Pick an option");
    }

    public BorrowService(String name)
    {
        super(name);
    }

    public void init()
    {
        prepareBaseMenu();
    }
}
