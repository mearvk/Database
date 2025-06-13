package database;

public class SQLInterpreter
{
    public BodhiDatabase database;
    public SQLInterpreter(BodhiDatabase database)
    {
        this.database = database;
    }

    public void interpret(String line)
    {

        if(line.strip().startsWith("ADD TABLE")) //e.g. ADD TABLE "//microsoft"
        {
            String command = "ADD TABLE";

            String tablename = line.replace(command, "").replace("'","").strip();

            this.database.tables.put(tablename, new Table(tablename));

            System.out.println("Added table '"+tablename+"' to database '"+this.database.name+"'.");
        }

        else if(line.strip().startsWith("ADD COLUMN")) //e.g. ADD COLUMN "//Social Security Number" INTO TABLE "//employees"
        {
            String command, columnname, tablename, next;

            int a, b;

            //

            command = "ADD COLUMN";

            next = line.replace(command, "").strip();

            a = next.indexOf("'");

            b = next.indexOf("'",a+1);

            columnname = next.substring(a+1,b).strip();

            //

            command = "INTO TABLE";

            next = next.replace(columnname,"");

            next = next.replaceAll("'","").strip();

            if(next.startsWith(command))
            {
                tablename = next.replace(command, "").strip();
            }
            else return;

            //

            Table table = this.database.tables.get(tablename);

            table.columns.put(new Column(columnname));

            System.out.println("Added column '"+columnname+"' to table '"+tablename+"'.");
        }

        else if(line.strip().startsWith("INSERT INTO COLUMN")) //e.g. INSERT INTO COLUMN "//Social Security Number" INTO TABLE "//employees"
        {

        }
    }
}
