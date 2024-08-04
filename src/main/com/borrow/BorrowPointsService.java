package main.com.borrow;

import main.com.app.App;
import main.com.generic.SubServiceimpl;
import main.com.service.Service;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class BorrowPointsService extends Service implements SubServiceimpl
{
    private void validateUserPassword(int amount)
    {
        try
        {
            System.out.println("• Input your password");

            Scanner in = new Scanner(System.in);
            String password = in.nextLine();

            if (!App.getUser().verifyPassword(password))
                throw new IllegalStateException("Please input your correct password");

            int userBalance = App.getUser().getBalance();
            App.getUser().setBalance(userBalance + amount);

            /*
               TODO:
                - Create Transaction with LOAN status
                - Go back to homepage
            * */
        } catch (IllegalStateException | NoSuchElementException e)
        {
            System.err.println("Incorrect Password. " + e.getMessage());
            validateUserPassword(amount);
        }
    }

    private void recordBorrowAmount()
    {
        try
        {
            System.out.println("\n" + "• " + getName());
            System.out.println("- Input the amount you will like to borrow");

            Scanner in = new Scanner(System.in);
            int amount = in.nextInt();

            if (amount < 100)
                throw new IllegalStateException("You cannot borrow less than 100 points");

            validateUserPassword(amount);
        } catch (IllegalStateException | NoSuchElementException e)
        {
            System.err.println("Please input a valid amount. " + e.getMessage());
            recordBorrowAmount();
        }
    }

    public BorrowPointsService(String name)
    {
        super(name);
    }

    public void init()
    {
        recordBorrowAmount();
    }
}
