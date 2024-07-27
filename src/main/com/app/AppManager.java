package main.com.app;

public class AppManager
{
    App app;

    public AppManager()
    {
        app = new App();
    }

    public void bootstrap()
    {
        app.initializeApp();
    }
}
