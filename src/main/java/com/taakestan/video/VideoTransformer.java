package com.taakestan.video;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteWatchdog;
import org.apache.commons.exec.OS;
import org.apache.commons.exec.PumpStreamHandler;

/**
 * @author Omid Pourhadi : omidpourhadi [AT] gmail [DOT] com
 *
 */
public class VideoTransformer
{

    private static final Logger log = Logger.getLogger(VideoTransformer.class.getName());

    
    /**
     * @param filePath : full file path in filesystem
     * @param outputDirectory : 
     * @return : null or outputdirectory + fileName_web.mp4 file
     */
    public static File transform(String filePath, String outputDirectory)
    {
       
        try
        {
            File file = new File(filePath);
            if (file.exists() == false)
            {
                throw new IllegalAccessException("File not found");
            }
            CommandLine cmdLine = new CommandLine("ffmpeg");
            cmdLine.addArgument("-i");
            cmdLine.addArgument(file.getAbsolutePath());
            cmdLine.addArgument("-vcodec");
            cmdLine.addArgument("libx264");
            cmdLine.addArgument("-crf");
            cmdLine.addArgument("20");
            // experimentaloption but what can you do
            cmdLine.addArgument("-strict");
            cmdLine.addArgument("-2");
            //
            String fileName = file.getName();
            if (fileName.indexOf(".") > 0)
            {
                fileName = fileName.substring(0, fileName.lastIndexOf("."));
            }
            File outputFile = new File(outputDirectory + "/" + String.format("%s_web.mp4", fileName));
            cmdLine.addArgument(outputFile.getAbsolutePath());
            DefaultExecutor executor = new DefaultExecutor();
            ExecuteWatchdog watchdog = new ExecuteWatchdog(2 * 1000);
            VideoResultHandler resultHandler = new VideoResultHandler(watchdog, outputFile);
            LogOutputStreamCollector out = new LogOutputStreamCollector();
            // create input and pass to pump
            PumpStreamHandler psh = new PumpStreamHandler(out, System.err);
            executor.setStreamHandler(psh);

            out.close();
            out = null;
            executor.execute(cmdLine, resultHandler);
            resultHandler.waitFor();
            if (resultHandler.hasResult())
            {
                return resultHandler.getFile();
            }

            log.log(Level.FINE, "outputfile is {0}", fileName);
        }
        catch (IOException e)
        {
            log.log(Level.FINE, "I/O Exception :-( {0}", e.getMessage());
        }
        catch (InterruptedException e)
        {
            log.log(Level.FINE, "InterruptedException :-( {0}", e.getMessage());
        }
        catch (Exception e)
        {
            log.log(Level.FINE, "something bad happened :-(");
        }
        return null;
    }

}
