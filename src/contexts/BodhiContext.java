package contexts;

import bodhi.BodhiDatabase;

public class BodhiContext
{
    public BodhiDatabase database;
    public BodhiContext(BodhiDatabase database)
    {
        this.database = database;
    }
}
