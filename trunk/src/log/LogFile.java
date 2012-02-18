package log;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class LogFile {
	private static LogFile _log;
	private static FileWriter fstream;
	private static BufferedWriter out;
	
	public static synchronized LogFile getInstance(){
		
		if( null == _log )
		{
			_log = new LogFile();
			try{
				fstream = new FileWriter("Log");
				out = new BufferedWriter(fstream);
			}
			catch (Exception e)
			{
				System.err.println("Error: " + e.getMessage());
			}
			
		}
		return _log;
	}
	
	public synchronized void writeToFile(String entry)
	{
		try{
			out.write(entry);
			out.newLine();
			out.flush();
		}
		catch (Exception e)
		{
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	public void closeFile()
	{
		try{
			out.close();
		}
		catch( Exception e)
		{
			System.err.println("Error: " + e.getMessage());
		}
	}
}
