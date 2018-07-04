package test;

import java.lang.*;
import java.io.*;
import java.util.*;

import static test.Upload_Base.*;

public class Upload_Jar {

    public static void main(String[] arg) throws IOException {

        String url = getUrl ( " test01.orionic.com " );
        String token = getToken ( " ZMd9yCSKVKrAR25rSVnw " );
        String path = getFilepath ( " C:/Users/IND029/Desktop/TestFolders/OrHarvesterUtil-0.0.1-jar-with-dependencies.jar " );
        int id = getId ( 21 );

        // String command ="java -jar C:/Users/IND029/Desktop/TestFolders/OrHarvesterUtil-0.0.1-jar-with-dependencies.jar  connection=PDIHKEX  " + " -runthisjob test01.orionic.com ZMd9yCSKVKrAR25rSVnw 21";
        String command = " java -jar " + path + " -runthisjob " + url + token + id;

        Process process = Runtime.getRuntime ().exec ( command );
        Scanner reader = new Scanner ( process.getInputStream () );

        while (reader.hasNext ()) {
            System.out.println ( reader.nextLine () );
            System.out.println ();
        }
        reader = new Scanner ( process.getErrorStream () );
        while (reader.hasNext ()) {
            System.out.println ( reader.nextLine () );
        }
    }
}

