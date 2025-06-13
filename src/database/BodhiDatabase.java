package database;

import java.util.HashMap;

public class BodhiDatabase
{
    public String name;
    public BodhiDatabase(String name)
    {
        this.name = name;
    }

    public HashMap<String, Table> tables = new HashMap<>();

    public Result insert(String database, String table, String column, Object object)
    {
        Table _table;

        _table = this.tables.get(table);

        if(_table==null)
        {
            Result result = new Result();

            result.error = "No such table: ( "+table+" ).";

            return result;
        }

        //

        Column _column;

        _column = _table.columns.get(column);

        _column.items.add(object);

        //

        Result result = new Result();

        result.table = _table;

        result.table.column = _column;

        result.table.column.object = object;

        //

        return result;
    }

    public Result insert(String database, Table table)
    {
        this.tables.put(table.name, table);

        Result result = new Result();

        result.table = table;

        return result;
    }

    public Result insert(String database, String table, Column column)
    {
        Table _table = this.tables.get(table);

        if(_table==null)
        {
            Result result = new Result();

            result.error = "No such table: ( "+table+" ).";

            return result;
        }

        _table.columns.put(column);

        //

        Result result = new Result();

        result.database = this;

        result.table = _table;

        result.table.column = column;

        return result;
    }
}
