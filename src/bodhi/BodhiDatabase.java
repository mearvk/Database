package bodhi;

import contexts.BodhiDatabaseContext;
import database.Column;
import database.SQLDatabase;
import database.Result;
import database.Table;

import java.util.HashMap;

public class BodhiDatabase
{
    public HashMap<String, SQLDatabase> databases = new HashMap<>();

    public BodhiDatabaseContext context;

    public BodhiDatabase()
    {

    }

    public BodhiDatabase(SQLDatabase database, BodhiDatabaseContext context)
    {
        this.databases.put(database.name, database);

        this.context = context;
    }

    public SQLDatabase getDatabase(String name)
    {
        return this.databases.get(name);
    }

    public void addDatabase(SQLDatabase database)
    {
        this.databases.put(database.name, database);
    }

    public Result insert(String databasename, String tablename, String columnname, Object object)
    {
        Result result = new Result();

        //

        SQLDatabase database = this.databases.get(databasename);

        if(database==null)
        {
            result.error = "No such database.";

            return result;
        }

        //

        Table table = database.tables.get(tablename);

        if(table==null)
        {
            result.error = "No such table name.";

            return result;
        }

        //

        Column column = table.columns.get(columnname);

        if(column==null)
        {
            result.error = "No such column name.";

            return result;
        }

        result = database.insert(table, column, object);

        return result;
    }

    public Result insert(String databasename, Table table)
    {
        Result result = new Result();

        //

        SQLDatabase database = this.databases.get(databasename);

        if(database==null)
        {
            result.error = "Database not found.";

            return result;
        }

        //

        result = database.insert(table);

        return result;
    }

    public Result insert(String databasename, String tablename, Column column)
    {
        Result result = new Result();

        //

        SQLDatabase database = this.databases.get(databasename);

        if(database==null)
        {
            result.error = "";

            return result;
        }

        //

        Table table = database.tables.get(tablename);

        if(table==null)
        {
            result.error = "";

            return result;
        }

        //

        result = database.insert(table, column);

        //

        result.database = database;

        result.table = table;

        result.column = column;

        return result;
    }
}
