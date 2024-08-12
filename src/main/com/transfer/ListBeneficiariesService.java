package main.com.transfer;

import main.com.app.App;
import main.com.service.Service;
import main.com.generic.SubServiceImpl;
import main.com.user.User;

public class ListBeneficiariesService extends Service implements SubServiceImpl
{
    private void checkIfUserHasBeneficiaries()
    {
        var beneficiaries = App.getUser().getBeneficiaries();

        if (beneficiaries.isEmpty())
        {
            System.err.println("\n" + "You have not added any beneficiary");
            goToPreviousMenu();
        } else
        {
            listAllBeneficiaries();
        }
    }

    private void listAllBeneficiaries()
    {
        var beneficiaries = App.getUser().getBeneficiaries();

        System.out.println("\n" + "• Your beneficiaries");
        for (int i = 0; i < beneficiaries.size(); i++)
        {
            System.out.println(i + 1 + " " +beneficiaries.get(i).getName());
        }
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

    public ListBeneficiariesService(String name)
    {
        super(name);
    }

    public void init()
    {
        checkIfUserHasBeneficiaries();
    }
}
