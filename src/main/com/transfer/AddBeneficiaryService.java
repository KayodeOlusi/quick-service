package main.com.transfer;

import main.com.app.App;
import main.com.generic.SubServiceImpl;
import main.com.service.Service;
import main.com.user.User;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class AddBeneficiaryService extends Service implements SubServiceImpl
{
    private void showAddBeneficiaryPrompt()
    {
        System.out.println("• Input the name of the beneficiary");

        try
        {
            Scanner in = new Scanner(System.in);
            String name = in.nextLine();

            if (name.isEmpty())
                throw new IllegalStateException("Invalid name");

            createBeneficiary(name);
        } catch (NoSuchElementException | IllegalStateException e)
        {
            System.err.println("Add a valid name. " + e.getMessage());
            showAddBeneficiaryPrompt();
        }
    }

    private void createBeneficiary(String name)
    {
        User user = new User(name);
        App.getUser().addBeneficiary(user);

        System.out.println("\n" + "You have successfully added a new beneficiary.");
        goToPreviousMenu();
    }

    private void goToPreviousMenu()
    {
        var serviceList = App.getAppServices();
        serviceList.pop();

        Service prevService = serviceList.peek();

        if (prevService instanceof SubServiceImpl)
            ((SubServiceImpl) prevService).init();
    }

    public AddBeneficiaryService(String name)
    {
        super(name);
    }

    public void init()
    {
        showAddBeneficiaryPrompt();
    }
}
