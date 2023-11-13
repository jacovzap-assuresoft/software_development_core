import java.util.*;
public class Logger{
    private static Logger instance;
    private TreeMap<String, String> logs;

    private Logger(){
        logs = new TreeMap<>();
    }

    public static Logger getInstance(){
        if(instance == null){
            instance = new Logger();
        }
        return instance;
    }

    public void addLog(String key, String log){
        this.logs.put(key, log);
    }

    public void printLogs(){
         for (Map.Entry<String, String> entry : logs.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
         }
    }

    public String getLog(String key){
        return this.logs.get(key);
    }
}