package main.com.service;

import main.com.app.App;

import java.util.*;

public class Service
{
    private final String name;

    private final HashMap<Integer, Service> allowedOptions = new HashMap<>();

    private final LinkedList<Service> serviceList = new LinkedList<>();

    private final ServiceOptions options = new ServiceOptions(new String[]{ });

    public Service(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void showServicePrompt(String title)
    {
        System.out.println("\n" + getName() + "\n");
        System.out.println(title);

        var opts = options.getOptions();
        for (String opt: opts)
        {
            System.out.println(opt);
        }

        try
        {
            Scanner in = new Scanner(System.in);
            int feedback = in.nextInt();

            validateSelectedOption(feedback, title);
        } catch (IllegalStateException | NoSuchElementException e)
        {
            System.err.println("Please select a valid option " + e.getMessage());
            showServicePrompt(title);
        }
    }

    public void validateSelectedOption(int opt, String title) throws IllegalArgumentException
    {
        try
        {
            if (allowedOptions.containsKey(opt))
            {
                moveToNextService(opt);
            } else
            {
                throw new IllegalArgumentException("Select a valid option from the list of options");
            }
        } catch (IllegalArgumentException e)
        {
            System.err.println(e.getMessage());
            showServicePrompt(title);
        }
    }

    public void moveToNextService(int opt)
    {
        var nextService = allowedOptions.get(opt);
        synchronized (App.getAppServices())
        {
            App.getAppServices().add(nextService);
        }
    }

    public void addOptions(String[] opts)
    {
        for (String opt: opts)
        {
            options.addOption(opt);
        }
    }

    public void setAllowedOptions(HashMap<Integer, Service> opts)
    {
        allowedOptions.putAll(opts);
    }
}
