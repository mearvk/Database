package database.interpreter;

import bodhi.BodhiDatabase;
import database.Database;

public class SQLInterpreter
{
    public BodhiDatabase bodhidatabase;

    public InterpreterResult result;

    public SQLInterpreter(BodhiDatabase bodhidatabase)
    {
        this.bodhidatabase = bodhidatabase;
    }

    public InterpreterResult interpret(String line)
    {
        if(line.strip().startsWith("ADD DATABASE")) //e.g. ADD DATABASE '//citizens'
        {
            return null;
        }
        else if(line.strip().startsWith("ALTER DATABASE") && line.strip().contains("ADD TABLE")) //e.g. ALTER DATABASE '//citizens' ADD TABLE '//ages'
        {
            return null;
        }
        else if(line.strip().startsWith("ALTER DATABASE") && line.strip().contains("ADD COLUMN")) //e.g. ALTER DATABASE '//citizens' ADD COLUMN '//social security number' WHERE TABLE EQUALS '//employees'
        {
            return null;
        }
        else if(line.strip().startsWith("INSERT INTO TABLE")) //e.g. INSERT INTO DATABASE '//microsoft' WHERE TABLE EQUALS '//employees' WHERE COLUMN EQUALS '//social security number' VALUE '123-456-7890'
        {
            return null;
        }

        return null;
    }
}
