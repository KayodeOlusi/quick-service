package main.com.transfer;

import main.com.app.App;
import main.com.generic.SubServiceImpl;
import main.com.service.Service;
import main.com.transactions.Transaction;
import main.com.user.User;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TransferToBeneficiaryService extends Service implements SubServiceImpl
{
    private final HashMap<Integer, User> validBeneficiaries = new HashMap<>();

    private void goToPreviousMenu()
    {
        var serviceList = App.getAppServices();
        serviceList.pop();

        Service prevService = serviceList.peek();

        if (prevService instanceof SubServiceImpl)
            ((SubServiceImpl) prevService).init();
    }

    private void listAllBeneficiariesToSendTo()
    {
        System.out.println("\n" + "• Pick a beneficiary");

        var beneficiaries = App.getUser().getBeneficiaries();

        for (int i = 0; i < beneficiaries.size(); i++)
        {
            validBeneficiaries.put(i + 1, beneficiaries.get(i));
            System.out.println(i + 1 + " " + beneficiaries.get(i).getName());
        }

        promptUserToSelectAUser(validBeneficiaries);
    }

    private void creditBeneficiary(int option, float amount)
    {
        var selectedBeneficiary = validBeneficiaries.get(option);
        var ben = App.getUser().getBeneficiaries().get(option - 1);
        float balance = ben.getBalance();

        if (selectedBeneficiary.getName().equals(ben.getName()))
        {
            ben.setBalance(amount + balance);
            createTransferTransaction(amount, ben);

            System.out.println("\n" +"You have successfully sent " + amount + " points to " + ben.getName());
            goToPreviousMenu();
        } else
        {
            System.err.println("An error occurred. Please try again");
            listAllBeneficiariesToSendTo();
        }
    }

    private void createTransferTransaction(float amount, User receiver)
    {
        var transaction = new Transaction("Transfer points to " + receiver.getName(), amount, "TRANSFER_POINTS");
        App.getUser().addTransaction(transaction);
    }

    private void promptUserToSelectAUser(HashMap<Integer, User> users)
    {
        try
        {
            Scanner in = new Scanner(System.in);
            int option = in.nextInt();

            if (option > users.size())
                throw new IllegalStateException("Please select from the list of users");

            System.out.println("\n" + "Input the amount you will like to send");
            float amount = in.nextFloat();
            float userBalance = App.getUser().getBalance();

            if (amount > userBalance || amount <= 0)
                throw new IllegalStateException("Please input an amount between 1 and " + userBalance);

            if (userBalance == 0)
                throw new IllegalStateException("Insufficient Balance");

            creditBeneficiary(option, amount);
        } catch (IllegalStateException | NoSuchElementException e)
        {
            System.err.println("Invalid option. " + e.getMessage());
            listAllBeneficiariesToSendTo();
        }
    }

    public TransferToBeneficiaryService(String name)
    {
        super(name);
    }

    public void init()
    {
        listAllBeneficiariesToSendTo();
    }
}
