package database;

import java.util.HashMap;

public class Database
{
    public String name;

    public HashMap<String, Table> tables = new HashMap<>();
    public Database(String name)
    {
        this.name = name;
    }

    public Result insert(Table table, Column column, Object object)
    {
        if(table==null)
        {
            Result result;

            result = new Result();

            result.error = "Table is NULL";

            return result;
        }

        //

        if(column==null)
        {
            Result result;

            result = new Result();

            result.error = "Column is NULL";

            return result;
        }

        //

        column.items.add(object);

        //

        Result result = new Result();

        result.database = this;

        result.table = table;

        result.table.column = column;

        result.table.column.object = object;

        //

        return result;
    }

    public Result insert(Table table)
    {
        this.tables.put(table.name, table);

        Result result = new Result();

        result.database = this;

        result.table = table;

        return result;
    }

    public Result insert(Table table, Column column)
    {
        table.columns.put(column);

        Result result = new Result();

        result.database = this;

        result.table = table;

        result.column = column;

        return result;
    }
}
