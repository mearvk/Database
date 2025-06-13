package network;

import database.BodhiDatabase;
import database.SQLInterpreter;
import database.Table;

import java.io.*;
import java.util.ArrayList;

public class BodhiServer extends BaseServer
{
    public OutputThread outputthread;

    public InputThread inputthread;

    public BodhiDatabase database;
    public BodhiServer(BodhiDatabase database)
    {
        super(39001);

        this.database = database;

        this.outputthread = new OutputThread(this);

        this.inputthread = new InputThread(this);

        this.outputthread.start();

        this.inputthread.start();
    }

    public static class OutputThread extends Thread
    {
        public BodhiServer server;

        public ArrayList<String> outputbuffer = new ArrayList<>(10);
        public OutputThread(BodhiServer server)
        {
            this.server = server;
        }

        @Override
        public void run()
        {
            while(true)
            {
                if(this.outputbuffer.size()==0)
                {
                    try
                    {
                        Thread.sleep(25);
                    }
                    catch (Exception e)
                    {
                        return;
                    }
                }
                else
                {
                    String line = this.outputbuffer.remove(0);

                    try
                    {
                        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(this.server.socket.getOutputStream()));

                        writer.write(line);

                        writer.flush();
                    }
                    catch (IOException e)
                    {
                        return;
                    }
                }
            }
        }
    }

    public static class InputThread extends Thread
    {
        public BodhiServer server;

        public ArrayList<String> inputbuffer = new ArrayList<>();

        public InputInterpreter interpreter = new InputInterpreter(this);
        public InputThread(BodhiServer server)
        {
            this.server = server;
        }

        @Override
        public void run()
        {
            while(true)
            {
                try
                {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(server.socket.getInputStream()));

                    String line = null;

                    while((line=reader.readLine())!=null)
                    {
                        this.inputbuffer.add(line);
                    }

                    this.interpreter.copyBuffer(this.inputbuffer);

                    Thread.sleep(20);
                }
                catch (Exception e)
                {
                    return;
                }
            }
        }
    }

    public static class InputInterpreter extends Thread
    {
        public BodhiServer server;

        public BodhiDatabase database;

        public InputThread inputthread;

        public ArrayList<String> buffer = new ArrayList<>();

        public SQLInterpreter interpreter;

        public void copyBuffer(ArrayList<String> buffer)
        {
            this.buffer.addAll(buffer);
        }

        public InputInterpreter(InputThread inputthread)
        {
            this.inputthread = inputthread;

            this.server = inputthread.server;

            this.interpreter = new SQLInterpreter(this.database);
        }

        @Override
        public void run()
        {
            while(true)
            {
                if(this.buffer.isEmpty())
                {
                    try
                    {
                        Thread.sleep(20);
                    }
                    catch (Exception e)
                    {
                        return;
                    }
                }
                else
                {
                    String line = this.buffer.remove(0).strip();

                    this.interpreter.interpret(line);
                }
            }
        }
    }
}
