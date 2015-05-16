package com.taakestan.testcases;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import org.junit.Assert;

import com.taakestan.video.VideoTransformer;

/**
 * @author Omid Pourhadi : omidpourhadi [AT] gmail [DOT] com unit test
 */
public class VideoTransfromTest
{

    /**
     * Rigourous Test :-)
     * 
     * @throws URISyntaxException
     */
    @org.junit.Test
    public void testTransfrom() throws URISyntaxException
    {
        URL resource = getClass().getResource("/test.mp4");
        Assert.assertNotNull(resource);
        File f = new File(resource.toURI());
        if (f.exists())
        {
            String targetfolder = f.getAbsolutePath().substring(0, f.getAbsolutePath().lastIndexOf("/"));
            System.out.println("Start Video Streaming");
            File file = VideoTransformer.transform(f.getAbsolutePath(), targetfolder);
            System.out.println("End Video Streaming");
        }
    }

}
