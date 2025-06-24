import bodhi.BodhiDatabase;
import contexts.BodhiContext;
import database.*;
import bodhi.network.RemoteBodhiServer;
import database.interpreter.SQLInterpreter;

public class Main
{
    public static void main(String[] args)
    {
        BodhiContext context;

        BodhiDatabase bodhiDatabase = new BodhiDatabase(new Database("//microsoft"), context =new BodhiContext("//context"));

        RemoteBodhiServer bodhiServer = new RemoteBodhiServer(context);

        //
        
        Result result;

        //
        
        result = bodhiDatabase.insert("//microsoft", new Table("//employees"));
        
        result = bodhiDatabase.insert("//microsoft", new Table("//parking"));

        result = bodhiDatabase.insert("//microsoft", new Table("//resumes"));

        result = bodhiDatabase.insert("//microsoft", new Table("//security"));

        //

        result = bodhiDatabase.insert("//microsoft", "//employees", new Column("//first name"));

        result = bodhiDatabase.insert("//microsoft", "//employees", new Column("//last name"));

        result = bodhiDatabase.insert("//microsoft", "//employees", new Column("//phone number"));

        result = bodhiDatabase.insert("//microsoft", "//employees", new Column("//social security number"));

        result = bodhiDatabase.insert("//microsoft", "//employees", new Column("//salary"));

        //

        result = bodhiDatabase.insert("//microsoft", "//employees", "//first name", "Dave");

        result = bodhiDatabase.insert("//microsoft", "//employees", "//last name", "Plummer");

        result = bodhiDatabase.insert("//microsoft", "//employees", "//phone number", "123-456-7890");

        result = bodhiDatabase.insert("//microsoft", "//employees", "//social security number", "111-222-3333");

        result = bodhiDatabase.insert("//microsoft", "//employees", "//salary", "55.00 hourly");

        //

        result = bodhiDatabase.insert("//microsoft", "//employees", "//first name", "Max");

        result = bodhiDatabase.insert("//microsoft", "//employees", "//last name", "Rupplin");

        result = bodhiDatabase.insert("//microsoft", "//employees", "//phone number", "123-456-7890");

        result = bodhiDatabase.insert("//microsoft", "//employees", "//social security number", "111-222-3333");

        result = bodhiDatabase.insert("//microsoft", "//employees", "//salary", "55.00 hourly");

        //



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

