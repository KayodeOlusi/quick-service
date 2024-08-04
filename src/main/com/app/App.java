package main.com.app;

import main.com.airtime.AirtimeService;
import main.com.borrow.BorrowService;
import main.com.data.DataService;
import main.com.logout.LogoutService;
import main.com.service.Service;
import main.com.transactions.TransactionsService;
import main.com.transfer.TransferService;
import main.com.user.User;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class App implements AppImpl
{
    private static User user;
    private static Service baseService;
    private static final List<Service> services = new ArrayList<>();

    private void prepareHomeScreenMenu()
    {
        Service home = new Service("Home");
        String[] opts = new String[]
            {
                "1. Transfer points to beneficiary",
                "2. Buy Airtime",
                "3. Buy Data",
                "4. Borrow points",
                "5. Check Transactions",
                "6. Log out"
            };

        home.addOptions(opts);
        home.setAllowedOptions(getBaseServicesOpts());

        baseService = home;
        promptUserToPickService();
    }

    private void promptUserToPickService()
    {
        baseService.showServicePrompt("What will you like to do today ?");
    }

    private HashMap<Integer, Service> getBaseServicesOpts()
    {
        var services = new HashMap<Integer, Service>();
        services.put(1, new TransferService("Transfer to beneficiary"));
        services.put(2, new AirtimeService("Buy Airtime"));
        services.put(3, new DataService("Buy Data"));
        services.put(4, new BorrowService("Borrow points"));
        services.put(5, new TransactionsService("Check Transactions"));
        services.put(6, new LogoutService("Logout"));

        return services;
    }

    public static User getUser()
    {
        return user;
    }

    public static List<Service> getAppServices()
    {
        return services;
    }

    public void initializeApp()
    {
        System.out.println("Welcome to Quick Service !!!");
        prepareUserAccount();
    }

    public void prepareUserAccount()
    {
        try
        {
            Scanner in = new Scanner(System.in);

            System.out.println("Tell us your name: ");
            String username = in.nextLine();

            System.out.println("Create a password: ");
            String pwd = in.nextLine();

            user = new User(username, pwd);
            user.setBalance(5000); // Default Balance

            System.out.println("You have been awarded 5000 points !!!");
            prepareHomeScreenMenu();
        } catch (NoSuchElementException | IllegalStateException e)
        {
            System.err.println("An error occurred while reading input: " + e.getMessage());
        }
    }
}
