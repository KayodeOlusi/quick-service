package main.com.transfer;

import main.com.generic.GoBackService;
import main.com.generic.SubServiceImpl;
import main.com.service.Service;

import java.util.HashMap;

public class TransferService extends Service implements SubServiceImpl
{
    private HashMap<Integer, Service> baseServiceOpts()
    {
        var opts = new HashMap<Integer, Service>();

        opts.put(1, new TransferToBeneficiaryService("Transfer to beneficiary"));
        opts.put(2, new AddBeneficiaryService("Add a beneficiary"));
        opts.put(3, new ListBeneficiariesService("List all beneficiaries"));
        opts.put(4, new GoBackService("Back"));

        return opts;
    }

    private void prepareBaseMenu()
    {
        String[] opts = new String[]
            {
              "1. Transfer Points",
              "2. Add Beneficiary",
              "3. List Beneficiaries",
              "4. Back"
            };

        this.addOptions(opts);
        this.setAllowedOptions(baseServiceOpts());

        this.showServicePrompt("Pick an option");
    }

    public TransferService(String name)
    {
        super(name);
    }

    public void init()
    {
        prepareBaseMenu();
    }
}
