import bodhi.BodhiDatabase;
import contexts.BodhiDatabaseContext;
import database.*;
import bodhi.network.RemoteBodhiServer;
import database.interpreter.SQLInterpreter;

public class Main
{
    public static void main(String[] args)
    {
        BodhiDatabaseContext bodhiDatabaseContext;

        BodhiDatabase bodhiDatabase = new BodhiDatabase(new SQLDatabase("//microsoft"), bodhiDatabaseContext = new BodhiDatabaseContext("//context"));

        //
        
        Result result;

        //
        
        result = bodhiDatabase.insert("//microsoft", new Table("//employees"));

        if(result.error!=null) { System.out.println(result.error); return; }
        
        result = bodhiDatabase.insert("//microsoft", new Table("//parking"));

        if(result.error!=null) { System.out.println(result.error); return; }

        result = bodhiDatabase.insert("//microsoft", new Table("//resumes"));

        if(result.error!=null) { System.out.println(result.error); return; }

        result = bodhiDatabase.insert("//microsoft", new Table("//security"));

        if(result.error!=null) { System.out.println(result.error); return; }

        //

        result = bodhiDatabase.insert("//microsoft", "//employees", new Column("//first name"));

        if(result.error!=null) { System.out.println(result.error); return; }

        result = bodhiDatabase.insert("//microsoft", "//employees", new Column("//last name"));

        if(result.error!=null) { System.out.println(result.error); return; }

        result = bodhiDatabase.insert("//microsoft", "//employees", new Column("//phone number"));

        if(result.error!=null) { System.out.println(result.error); return; }

        result = bodhiDatabase.insert("//microsoft", "//employees", new Column("//social security number"));

        if(result.error!=null) { System.out.println(result.error); return; }

        result = bodhiDatabase.insert("//microsoft", "//employees", new Column("//salary"));

        if(result.error!=null) { System.out.println(result.error); return; }

        //

        result = bodhiDatabase.insert("//microsoft", "//employees", "//first name", "Dave");

        if(result.error!=null) { System.out.println(result.error); return; }

        result = bodhiDatabase.insert("//microsoft", "//employees", "//last name", "Plummer");

        if(result.error!=null) { System.out.println(result.error); return; }

        result = bodhiDatabase.insert("//microsoft", "//employees", "//phone number", "123-456-7890");

        if(result.error!=null) { System.out.println(result.error); return; }

        result = bodhiDatabase.insert("//microsoft", "//employees", "//social security number", "111-222-3333");

        if(result.error!=null) { System.out.println(result.error); return; }

        result = bodhiDatabase.insert("//microsoft", "//employees", "//salary", "55.00 hourly");

        if(result.error!=null) { System.out.println(result.error); return; }

        //

        result = bodhiDatabase.insert("//microsoft", "//employees", "//first name", "Max");

        if(result.error!=null) { System.out.println(result.error); return; }

        result = bodhiDatabase.insert("//microsoft", "//employees", "//last name", "Rupplin");

        if(result.error!=null) { System.out.println(result.error); return; }

        result = bodhiDatabase.insert("//microsoft", "//employees", "//phone number", "123-456-7890");

        if(result.error!=null) { System.out.println(result.error); return; }

        result = bodhiDatabase.insert("//microsoft", "//employees", "//social security number", "111-222-3333");

        if(result.error!=null) { System.out.println(result.error); return; }

        result = bodhiDatabase.insert("//microsoft", "//employees", "//salary", "55.00 hourly");

        if(result.error!=null) { System.out.println(result.error); return; }

        //

        RemoteBodhiServer bodhiServer = new RemoteBodhiServer(bodhiDatabaseContext);

        //

        SQLInterpreter interpreter = new SQLInterpreter(bodhiDatabase);

        interpreter.result = interpreter.interpret("ADD DATABASE '//citizens'");

        interpreter.result = interpreter.interpret("ALTER DATABASE '//citizens' ADD TABLE '//ages'");

        interpreter.result = interpreter.interpret("ALTER DATABASE '//citizens' ALTER TABLE '//employees' ADD COLUMN '//social security number'");

        //

        interpreter.result = interpreter.interpret("DROP DATABASE '//citizens'");

        interpreter.result = interpreter.interpret("ALTER DATABASE '//citizens' DROP TABLE '//ages'");

        interpreter.result = interpreter.interpret("ALTER DATABASE '//citizens' TABLE '//employees' DROP COLUMN '//social security number'");

        //

        interpreter.result = interpreter.interpret("ALTER DATABASE '//citizens' CHANGE TO '//citizen ID'");

        interpreter.result = interpreter.interpret("ALTER DATABASE '//citizens' ALTER TABLE '//ages' CHANGE TO '//age'");

        interpreter.result = interpreter.interpret("ALTER DATABASE '//citizens' TABLE '//employees' ALTER COLUMN '//social security number' CHANGE TO '//SSN'");

        //

        interpreter.result =  interpreter.interpret("INSERT INTO DATABASE '//microsoft' WHERE TABLE EQUALS '//employees' WHERE COLUMN EQUALS '//social security number' SET VALUE '123-456-7890'");

        interpreter.result =  interpreter.interpret("UPDATE DATABASE '//microsoft' WHERE TABLE EQUALS '//employees' WHERE COLUMN EQUALS '//social security number' SET VALUE '123-456-7890'");

    }
}

