package database.interpreter;

import bodhi.BodhiDatabase;
import database.Column;
import database.Database;
import database.Table;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        line = line.strip();

        //

        if(line.startsWith("ADD DATABASE")) //e.g. ADD DATABASE '//citizens'
        {
            InterpreterResult result = new InterpreterResult();

            //

            Pattern pattern = Pattern.compile(".*'([^']*)'.*");

            Matcher matcher = pattern.matcher(line);

            if(matcher.matches())
            {
                String databasename = matcher.group(1);

                this.bodhidatabase.databases.put(databasename, new Database(databasename));
            }

            //

            return result;
        }
        else if(line.startsWith("ALTER DATABASE") && line.contains("ADD TABLE")) //e.g. ALTER DATABASE '//citizens' ADD TABLE '//ages'
        {
            InterpreterResult result = new InterpreterResult();

            //

            Pattern pattern = Pattern.compile(".*'([^']*)'.*");

            Matcher matcher = pattern.matcher(line);

            if(matcher.matches())
            {
                String databasename = matcher.group(1);

                if(databasename != null)
                {
                    Database database = this.bodhidatabase.databases.get(databasename);

                    if(database != null)
                    {
                        String tablename = matcher.group(2);

                        if(tablename != null)
                        {
                            database.tables.put(tablename, new Table(tablename));
                        }
                        else return new InterpreterResult("No table name found.","No errors.");
                    }
                    else return new InterpreterResult("Database reference unexpectedly null.","No errors.");
                }
                else return new InterpreterResult();
            }

            //

            return result;
        }
        else if(line.startsWith("ALTER DATABASE") && line.contains("ADD TABLE") && line.contains("ADD COLUMN")) //e.g. ALTER DATABASE '//citizens' ALTER TABLE '//employees' ADD COLUMN '//social security number'
        {
            InterpreterResult result = new InterpreterResult();

            //

            Pattern pattern = Pattern.compile(".*'([^']*)'.*");

            Matcher matcher = pattern.matcher(line);

            if(matcher.matches())
            {
                String databasename = matcher.group(1);

                Database database = this.bodhidatabase.databases.get(databasename);

                if(database != null)
                {
                    String tablename = matcher.group(2);

                    if(tablename != null)
                    {
                        Table table = database.tables.get(tablename);

                        if(table != null)
                        {
                            String columnname = matcher.group(3);

                            if(columnname != null)
                            {
                                table.columns.put(new Column(columnname));
                            }
                            else return new InterpreterResult("No column name found.","No errors.");
                        }
                        else return new InterpreterResult("Table reference unexpectedly null.","No errors.");
                    }
                    else return new InterpreterResult("No table name found.","No errors.");
                }
                else return new InterpreterResult("Database reference unexpectedly null.","No errors.");
            }

            //

            return result;
        }
        else if(line.startsWith("INSERT INTO TABLE")) //e.g. INSERT INTO DATABASE '//microsoft' WHERE TABLE EQUALS '//employees' WHERE COLUMN EQUALS '//social security number' VALUE '123-456-7890'
        {
            InterpreterResult result = new InterpreterResult();

            //

            //

            return result;
        }

        return new InterpreterResult("No matches.","No errors.");
    }
}
