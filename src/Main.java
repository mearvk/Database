import contexts.BodhiContext;
import database.*;
import network.BodhiServer;

public class Main
{
    public static void main(String[] args)
    {
        BodhiDatabase database = new BodhiDatabase(new Database("//microsoft"));

        Result result;

        result = database.insert("//microsoft", new Table("//employees"));

        //

        result = database.insert("//microsoft", "//employees", new Column("//first name"));

        result = database.insert("//microsoft", "//employees", new Column("//last name"));

        result = database.insert("//microsoft", "//employees", new Column("//phone number"));

        result = database.insert("//microsoft", "//employees", new Column("//social security number"));

        result = database.insert("//microsoft", "//employees", new Column("//salary"));

        //

        result = database.insert("//microsoft", "//employees", "//first name", "Dave");

        result = database.insert("//microsoft", "//employees", "//last name", "Plummer");

        result = database.insert("//microsoft", "//employees", "//phone number", "123-456-7890");

        result = database.insert("//microsoft", "//employees", "//social security number", "111-222-3333");

        result = database.insert("//microsoft", "//employees", "//salary", "55.00 hourly");

        //

        result = database.insert("//microsoft", "//employees", "//first name", "Max");

        result = database.insert("//microsoft", "//employees", "//last name", "Rupplin");

        result = database.insert("//microsoft", "//employees", "//phone number", "123-456-7890");

        result = database.insert("//microsoft", "//employees", "//social security number", "111-222-3333");

        result = database.insert("//microsoft", "//employees", "//salary", "55.00 hourly");

        //

        BodhiServer server = new BodhiServer(new BodhiContext(database));

        //

        SQLInterpreter interpreter = new SQLInterpreter(database);

        interpreter.interpret("ADD TABLE '//employees'");

        interpreter.interpret("ADD COLUMN '//social security number' INTO TABLE '//employees'");

        interpreter.interpret("INSERT INTO TABLE '//employees' AT COLUMN '//social security number' VALUE '123-456-7890'");
    }
}

