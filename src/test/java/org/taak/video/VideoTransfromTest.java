package org.taak.video;

import java.io.File;


/**
 * @author Omid Pourhadi : omidpourhadi [AT] gmail [DOT] com
 * unit test
 */
public class VideoTransfromTest
{

    /**
     * Rigourous Test :-)
     */
    @org.junit.Test
    public void testTransfrom()
    {
        File f = new File("/home/omidp/taak/jpa.mp4");
        if (f.exists())
        {
            System.out.println("Start Video Streaming");
            File file = VideoTransformer.transform(f.getAbsolutePath(), "/home/omidp/taak/");
            System.out.println("End Video Streaming" );
        }
    }
    

}
