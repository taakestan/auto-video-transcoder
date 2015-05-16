package org.taak.video;

import java.util.logging.Logger;

import org.apache.commons.exec.LogOutputStream;

/**
 * @author Omid Pourhadi : omidpourhadi [AT] gmail [DOT] com
 *
 */
public class LogOutputStreamCollector extends LogOutputStream
{

    private static final Logger log = Logger.getLogger(LogOutputStreamCollector.class.getName());
    
    @Override
    protected void processLine(String line, int logLevel)
    {
        log.finest(line);
    }

}
