import bodhi.BodhiDatabase;
import contexts.BodhiDatabaseContext;
import bodhi.network.RemoteBodhiServer;
import database.sql.SQLColumn;
import database.sql.SQLDatabase;
import database.sql.SQLResult;
import database.sql.SQLTable;
import interpreter.SQLInterpreter;

public class Main
{
    public static void main(String[] args)
    {
        BodhiDatabaseContext bodhiDatabaseContext;

        BodhiDatabase bodhiDatabase = new BodhiDatabase(new SQLDatabase("//microsoft"), bodhiDatabaseContext = new BodhiDatabaseContext("//context"));

        //
        
        SQLResult result;

        //
        
        result = bodhiDatabase.insert("//microsoft", new SQLTable("//employees"));

        if(result.error!=null) { System.out.println(result.error); return; }
        
        result = bodhiDatabase.insert("//microsoft", new SQLTable("//parking"));

        if(result.error!=null) { System.out.println(result.error); return; }

        result = bodhiDatabase.insert("//microsoft", new SQLTable("//resumes"));

        if(result.error!=null) { System.out.println(result.error); return; }

        result = bodhiDatabase.insert("//microsoft", new SQLTable("//security"));

        if(result.error!=null) { System.out.println(result.error); return; }

        //

        result = bodhiDatabase.insert("//microsoft", "//employees", new SQLColumn("//first name"));

        if(result.error!=null) { System.out.println(result.error); return; }

        result = bodhiDatabase.insert("//microsoft", "//employees", new SQLColumn("//last name"));

        if(result.error!=null) { System.out.println(result.error); return; }

        result = bodhiDatabase.insert("//microsoft", "//employees", new SQLColumn("//phone number"));

        if(result.error!=null) { System.out.println(result.error); return; }

        result = bodhiDatabase.insert("//microsoft", "//employees", new SQLColumn("//social security number"));

        if(result.error!=null) { System.out.println(result.error); return; }

        result = bodhiDatabase.insert("//microsoft", "//employees", new SQLColumn("//salary"));

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

