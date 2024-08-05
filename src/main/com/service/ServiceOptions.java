package main.com.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ServiceOptions
{
    private final List<String> options = new ArrayList<>();

    public ServiceOptions(String[] opts)
    {
        options.addAll(Arrays.asList(opts));
    }

    public void addOption(String opt)
    {
        options.add(opt);
    }

    public void clearOptions()
    {
        options.clear();
    }

    public List<String> getOptions()
    {
        return options;
    }
}
