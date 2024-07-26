package main.com.app;

import main.com.user.User;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class App implements AppImpl
{
    private User user;

    public App() {}

    public void initializeApp()
    {
        System.out.println("Welcome to Quick Service !!!");
        this.prepareUserAccount();
    }

    public void prepareUserAccount()
    {
        try
        {
            Scanner in = new Scanner(System.in);

            System.out.println("Tell us your name: ");
            String username = in.nextLine();

            System.out.println("Create a password");
            String pwd = in.nextLine();

            user = new User(username, pwd);
            System.out.println(user.getName());
        } catch (NoSuchElementException | IllegalStateException e)
        {
            System.err.println("An error occurred while reading input: " + e.getMessage());
        }
    }
}
