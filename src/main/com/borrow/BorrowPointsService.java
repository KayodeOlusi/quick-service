package main.com.borrow;

import main.com.app.App;
import main.com.generic.SubServiceImpl;
import main.com.service.Service;
import main.com.transactions.Transaction;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class BorrowPointsService extends Service implements SubServiceImpl
{
    private void validateUserPassword(float amount)
    {
        try
        {
            System.out.println("• Input your password");

            Scanner in = new Scanner(System.in);
            String password = in.nextLine();

            if (!App.getUser().verifyPassword(password))
                throw new IllegalStateException("Please input your correct password");

            createNewBorrowTransaction(amount);
            goToPreviousMenu();
        } catch (IllegalStateException | NoSuchElementException e)
        {
            System.err.println("Incorrect Password. " + e.getMessage());
            validateUserPassword(amount);
        }
    }

    private boolean hasUserBorrowedThreePointsInTotal()
    {
        int borrowCount = 0;
        var userTransactions = App.getUser().getTransactions();

        for (Transaction t : userTransactions)
        {
            if (t.type().equals("BORROW"))
                borrowCount += 1;
        }

        return borrowCount == 3;
    }

    private void goToPreviousMenu()
    {
        var serviceList = App.getAppServices();
        serviceList.pop();

        Service prevService = serviceList.peek();

        if (prevService instanceof SubServiceImpl)
            ((SubServiceImpl) prevService).init();
    }

    private void checkForEligibility()
    {
        boolean isNotEligibleToBorrow = hasUserBorrowedThreePointsInTotal();
        if (isNotEligibleToBorrow)
        {
            System.err.println("You have passed your borrow limit. Repay all your outstanding debt to proceed");
            goToPreviousMenu();
        } else
        {
            initializeBorrowPointsAction();
        }
    }

    private void createNewBorrowTransaction(float amount)
    {
        float userBalance = App.getUser().getBalance();
        App.getUser().setBalance(userBalance + amount);

        var transaction = new Transaction("Borrowed Points", amount, "BORROW");
        App.getUser().addTransaction(transaction);

        System.out.println("You have successfully borrowed " + amount + " points" + "\n");
    }

    private void initializeBorrowPointsAction()
    {
        try
        {
            System.out.println("\n" + "• " + getName());
            System.out.println("- Input the amount you will like to borrow");

            Scanner in = new Scanner(System.in);
            float amount = in.nextFloat();

            if (amount < 100)
                throw new IllegalStateException("You cannot borrow less than 100 points");

            validateUserPassword(amount);
        } catch (IllegalStateException | NoSuchElementException e)
        {
            System.err.println("Please input a valid amount. " + e.getMessage());
            initializeBorrowPointsAction();
        }
    }

    public BorrowPointsService(String name)
    {
        super(name);
    }

    public void init()
    {
        checkForEligibility();
    }
}
