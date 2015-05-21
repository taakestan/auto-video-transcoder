package com.taakestan.video;

/**
 * @author Omid Pourhadi : omidpourhadi [AT] gmail [DOT] com
 *
 */
public interface VideoOptions
{

    
    public static final String[] MP4 = {"-i","${FILEPATH}","-vcodec","libx264","-crf","20","-strict","-2"};
    
    public static final String[] WEBM = {""};
    
}
