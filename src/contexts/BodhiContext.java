package contexts;

import bodhi.BodhiDatabase;

import java.io.InputStream;
import java.io.OutputStream;

public class BodhiContext extends DatabaseContext
{
    public BodhiDatabase database;


    public BodhiContext(String name)
    {

    }

    public BodhiContext(String name, BodhiDatabase database)
    {
        this.database = database;
    }
}
