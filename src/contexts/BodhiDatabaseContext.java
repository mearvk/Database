package contexts;

import bodhi.BodhiDatabase;

public class BodhiDatabaseContext extends DatabaseContext
{
    public BodhiDatabase database;

    public String name;

    public BodhiDatabaseContext(String name)
    {
        this.name = name;
    }

    public BodhiDatabaseContext(String name, BodhiDatabase database)
    {
        this.name = name;

        this.database = database;
    }
}
