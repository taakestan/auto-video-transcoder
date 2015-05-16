package org.taak.video;

import java.io.File;
import java.util.logging.Logger;

import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.ExecuteWatchdog;

/**
 * @author Omid Pourhadi : omidpourhadi [AT] gmail [DOT] com
 *
 */
public class VideoResultHandler extends DefaultExecuteResultHandler
{

    
    private static final Logger log = Logger.getLogger(VideoResultHandler.class.getName());
    
    private ExecuteWatchdog watchdog;
    private File file;

    public VideoResultHandler(ExecuteWatchdog watchdog, File file)
    {
        this.watchdog = watchdog;
        this.file = file;
    }

    public void onProcessComplete(int exitValue)
    {
        super.onProcessComplete(exitValue);
        log.fine("The compress process completed");
    }

    public File getFile()
    {
        return file;
    }

    public void onProcessFailed(ExecuteException e)
    {
        super.onProcessFailed(e);
        if (watchdog != null && watchdog.killedProcess())
        {
            log.fine("The compress process timed out");
        }
        else
        {
            log.fine("The compress process failed to do : " + e.getMessage());
        }
    }
    
}
