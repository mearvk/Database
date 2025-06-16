package database.interpreter;

public class InterpreterResult
{
    public String stdout;

    public String stderr;

    public InterpreterResult()
    {

    }

    public InterpreterResult(String stdout, String stderr)
    {
        this.stdout = stdout;

        this.stderr = stderr;
    }
}
