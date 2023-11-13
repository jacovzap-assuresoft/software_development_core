public class Main
{
    public static void main(String[] args)
    {
        Logger logger = Logger.getInstance();
        logger.addLog("1", "Log 1");
        logger.addLog("2", "Log 2");
        logger.printLogs();

        Logger logger2 = Logger.getInstance();
        logger2.printLogs();
    }
}