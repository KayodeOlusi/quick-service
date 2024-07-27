package main.com.app;

import main.com.service.Service;
import main.com.user.User;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class App implements AppImpl
{
    private User user;
    private final LinkedList<Service> services = new LinkedList<>();

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
        services.add(home);
        promptUserToPickService();
    }

    private void promptUserToPickService()
    {
        for (Service curr : this.services)
        {
            curr.showServicePrompt("What will you like to do today ?");
        }
    }

    public LinkedList<Service> getServices()
    {
        return this.services;
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
            user.setBalance(5000);

            System.out.println("You have been awarded 5000 points !!!");
            prepareHomeScreenMenu();
        } catch (NoSuchElementException | IllegalStateException e)
        {
            System.err.println("An error occurred while reading input: " + e.getMessage());
        }
    }
}
