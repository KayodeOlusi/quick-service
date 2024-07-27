package main.com.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ServiceOptions
{
    private final List<String> options = new ArrayList<>();

    public ServiceOptions(String[] opts)
    {
        this.options.addAll(Arrays.asList(opts));
    }

    public void addOption(String opt)
    {
        this.options.add(opt);
    }

    public List<String> getOptions()
    {
        return this.options;
    }
}
