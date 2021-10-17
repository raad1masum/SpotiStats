package com.example.sping_portfolio.controllers.AsciiLab;
import java.awt.Color;

import org.codehaus.groovy.runtime.powerassert.SourceText;

public class ASCIIArt {
    // The lookup table for all of the chars that can be used
    public static final String GRAYSCALE_CHARS  = "@#BW8gMN6&9RQqE0d$DbpmOa5AH2GZeKPS3X4U%kwohFVyzIsCu{xfn}tJTi17c=jYL?l[]v<>+|)r(/\\*_!;^~\":,-'.`";
    // The lookup table of the brightness of each char, from 0 to 1
    public static final double[] GRAYSCALE_VALUES = {0, 0.07863, 0.08205, 0.1316, 0.1453, 0.147, 0.1504, 0.1641, 0.1761, 0.1761, 0.1778, 0.2017, 0.2154, 0.2274, 0.2274, 0.2291, 0.2427, 0.2598, 0.2615, 0.2684, 0.2752, 0.2769, 0.2889, 0.2923, 0.294, 0.2974, 0.3026, 0.3077, 0.3077, 0.3094, 0.3162, 0.3197, 0.3333, 0.3333, 0.3385, 0.3538, 0.3607, 0.3795, 0.3846, 0.4017, 0.4034, 0.4068, 0.4291, 0.4325, 0.4444, 0.4598, 0.4632, 0.4667, 0.4752, 0.4855, 0.5077, 0.5128, 0.5128, 0.5128, 0.5179, 0.5214, 0.5231, 0.535, 0.535, 0.5368, 0.5385, 0.5436, 0.5624, 0.5624, 0.5624, 0.5641, 0.5778, 0.5829, 0.5846, 0.5863, 0.5863, 0.5915, 0.6017, 0.6068, 0.641, 0.6581, 0.6889, 0.694, 0.6974, 0.7333, 0.7333, 0.7402, 0.7675, 0.7744, 0.7863, 0.8068, 0.8342, 0.8427, 0.8598, 0.894, 0.947, 0.959, 0.9675, 1};

    /**
     * Convert a java.awt.Color object to a grayscale float
     * @param c A java.awt.Color object
     * @return A value between 0 and 1 representing grayscale
     */
    public static double getBrightness(Color c) {
        return 0.3*(c.getRed()/255.0) + 0.59*(c.getGreen()/255.0) + 0.11*(c.getBlue()/255.0);
    }

    /**
     * Convert a picture object to a 2D array of grayscale floats
     * @param picture A picture object
     * @return A 2D array of grayscale values between 0 and 1
     */
    public static double[][] getGrayscaleArray(Picture picture) {
        int rows = picture.height();
        int cols = picture.width();
        double[][] image = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                image[i][j] = getBrightness(picture.get(j, i));
            }
        }
        return image;
    }

    public static int getIndex(double val){

        double diff = 1000.0;
        int index=0;
        for(int i=0; i<GRAYSCALE_VALUES.length; i++){
            if(Math.abs(val-GRAYSCALE_VALUES[i]) <= diff){
                diff=val-GRAYSCALE_VALUES[i];
                index=i;
            }
            else {
                // System.out.println("DIFF " + diff);
                // System.out.println("INDEX " + index);
                // System.out.println("NEW DIFF THAT WAS REJECTED " + Math.abs(val-GRAYSCALE_VALUES[i]));
                // System.out.println("ANSWER " + GRAYSCALE_VALUES[index]);
                break;
            }
        }
        
        return index;
    }

    public static char[][] create() {
        Picture picture = new Picture("./static/images/ursinus.png");
        double[][] image = getGrayscaleArray(picture);

        int rowFactor=4, colFactor=2;
        int nHeight=image.length/rowFactor, nWidth=image[0].length/colFactor;
        
        // ret is sent to AsciiController.java. It is a 2D array of ASCII characters
        char[][] ret = new char[nHeight][nWidth];

        /* 
            normalizedImage is created by average "blocks" of the image in order to maintain the same aspect ratio and 
            reduce the size of high resolution images
        */
        double [][] normalizedImage = new double [nHeight][nWidth];
    
        System.out.println("BOUNDS " + image.length + " x " + image[0].length);
        System.out.println("NEW BOUNDS " + nHeight + " x " + nWidth);

        // Normalization happens here. Blocks are iterated over and averaged.
        // Though there are 4 nested loops, it runs faster than an iteration of the entire array due to iteration factor
        for(int i=0; i<image.length; i+=rowFactor){
            for(int j=0; j<image[0].length; j+=colFactor){
                double current=0;
                for(int r=0; r<rowFactor; r++){
                    for(int c=0; c<colFactor; c++){
                        current += image[i+r][j+c];
                    }
                }
                normalizedImage[i/rowFactor][j/colFactor] = (double)current/(rowFactor*colFactor);
            }
        }

        // Takes normalized values, finds the index with closest value, and assigns it that asci character
        // see getIndex() function for info on how this works
        for(int i=0; i<normalizedImage.length; i++)
            for(int j=0; j<normalizedImage[0].length; j++)
                ret[i][j] = GRAYSCALE_CHARS.charAt(getIndex(normalizedImage[i][j]));
            
        // TODO: Make ASCII art.  You should define at least one method
        // that takes in the image array, as well as the number of
        // rows and columns in each block
        return ret;
    }   
}