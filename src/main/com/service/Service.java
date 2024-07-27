package main.com.service;

import java.util.Scanner;

public class Service
{
    private final String name;

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
        System.out.println(getName() + "\n");
        System.out.println(title);

        var opts = options.getOptions();
        for (String opt: opts)
        {
            System.out.println(opt);
        }

        Scanner in = new Scanner(System.in);
        String pick = in.nextLine();

        System.out.println(pick);
        System.exit(1);
    }

    public void addOptions(String[] opts)
    {
        for (String opt: opts)
        {
            options.addOption(opt);
        }
    }
}
