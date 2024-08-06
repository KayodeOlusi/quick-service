package main.com.borrow;

import main.com.app.App;
import main.com.generic.SubServiceimpl;
import main.com.service.Service;
import main.com.transactions.Transaction;

import java.util.Scanner;

public class RepayBorrowedPointsService extends Service implements SubServiceimpl
{
    private float getUserBalance()
    {
        return App.getUser().getBalance();
    }

    private float calculateBorrowedPoints()
    {
        float total = 0;
        var transactions = App.getUser().getTransactions();

        for (Transaction t : transactions)
        {
            if (t.type().equals("BORROW"))
                total += t.amount();

            if (t.type().equals("REPAY_BORROWED_POINTS"))
                total -= t.amount();
        }

            return total;
    }

    private void createRepayBorrowPointsTransaction(float amount)
    {
        var transaction = new Transaction("Repay Borrowed Points", amount, "REPAY_BORROWED_POINTS");
        App.getUser().addTransaction(transaction);
        System.out.println("\n" + "You have successfully refunded " + amount + " points");

        goToPreviousMenu();
    }

    private void repayBorrowedPoints(float amount)
    {
        float newBalance = getUserBalance() - amount;
        App.getUser().setBalance(newBalance);

        createRepayBorrowPointsTransaction(amount);
    }

    private void startRepayOperation()
    {
        System.out.println("\n" + "• " + getName());
        System.out.println("You have borrowed " + calculateBorrowedPoints() + " points");
        System.out.println("- Input the amount you will like to refund");

        Scanner in = new Scanner(System.in);
        float amount = in.nextFloat();

        var userBalance = getUserBalance();
        if (userBalance < amount)
        {
            System.err.println("You do not have enough points in your account");
            goToPreviousMenu();
        } else if (amount > calculateBorrowedPoints())
        {
            System.err.println("You cannot refund more than you have borrowed");
            startRepayOperation();
        } else
        {
            repayBorrowedPoints(amount);
        }
    }

    private void checkForBorrowedPoints()
    {
        float totalBorrowedPoints = calculateBorrowedPoints();
        if (totalBorrowedPoints == 0)
        {
            System.err.println("You have not borrowed any points");
            goToPreviousMenu();
        } else
        {
            startRepayOperation();
        }
    }

    private void goToPreviousMenu()
    {
        var serviceList = App.getAppServices();
        serviceList.pop();

        Service prevService = serviceList.peek();

        if (prevService instanceof SubServiceimpl)
            ((SubServiceimpl) prevService).init();
    }

    public RepayBorrowedPointsService(String name)
    {
        super(name);
    }

    public void init()
    {
        checkForBorrowedPoints();
    }
}
