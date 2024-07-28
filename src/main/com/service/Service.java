package main.com.service;

import java.util.*;

public class Service
{
    private final String name;

    private final List<Integer> allowedOptions = new ArrayList<>();

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
            System.err.println("Please select a valid option" + e.getMessage());
            showServicePrompt(title);
        }
    }

    public void validateSelectedOption(int opt, String title) throws IllegalArgumentException
    {
        try
        {
            if (allowedOptions.contains(opt))
            {
                // TODO: Continue when user selects option
                System.out.println("🚀🚀🚀🚀🚀");
                System.exit(1);
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

    public void addOptions(String[] opts)
    {
        for (String opt: opts)
        {
            options.addOption(opt);
        }
    }

    public void setAllowedOptions(List<Integer> opts)
    {
        this.allowedOptions.addAll(opts);
    }
}
