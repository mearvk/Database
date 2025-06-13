package database;

import java.util.HashMap;

public class Table
{
    public String name;

    public Column column;

    public List columns = new List();

    public Table(String name)
    {
        this.name = name;
    }

    public static class List
    {
        public HashMap<String, Column> items = new HashMap<>();

        public Column get(String name)
        {
            return items.get(name);
        }

        public void put(Column column)
        {
            this.items.put(column.name,column);
        }
    }
}
