package contexts;

import database.BodhiDatabase;
import database.Database;

public class BodhiContext
{
    public BodhiDatabase database;
    public BodhiContext(BodhiDatabase database)
    {
        this.database = database;
    }
}
