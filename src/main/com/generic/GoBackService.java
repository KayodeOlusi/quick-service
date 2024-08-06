package main.com.generic;

import main.com.app.App;
import main.com.service.Service;

public class GoBackService extends Service implements SubServiceimpl
{
    private void goToPreviousMenu()
    {
        var services = App.getAppServices();
        for (int i = 0; i < 2; i++)
            services.pop();

        if (services.isEmpty())
        {
            App.prepareHomeScreenMenu();
        } else
        {
            Service prevService = services.peek();
            if (prevService instanceof SubServiceimpl)
                ((SubServiceimpl) prevService).init();
        }
    }

    public GoBackService(String name)
    {
        super(name);
    }

    public void init()
    {
        goToPreviousMenu();
    }
}
