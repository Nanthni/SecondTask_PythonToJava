package test;

import java.lang.*;
import java.io.*;
import java.util.*;

import static test.Upload_Base.*;

public class Upload_Pentaho {

    public static void main(String[] arg) throws IOException {

        String url = getUrl ( "https://test01.orionic.com/harvester/api/jobs/" );
        String token = getToken ( "mmx-ZMd9yCSKVKrAR25rSVnw" );
        String path = getFilepath ( "C:/Users/IND029/Desktop/Transformations.zip" );
        String connector = getConnector ( "Harvester_Upload_Pentaho" );
        int id = getId ( 1902 );

        //String command = "curl -gH \"Authorization: Token token=mmx-ZMd9yCSKVKrAR25rSVnw\" \"https://test01.orionic.com/harvester/api/jobs/1902/upload\" --form \"id=1902\" --form \"connection=Harvester_Upload_Pentaho\" -F \"file=@C:/Users/IND029/Desktop/Transformations.zip\"";
        String command = "curl -gH \"Authorization: Token token=" + token + "\" \"" + url + id + "/upload\" --form \"id=" + id + "\" --form \"connection=" + connector + "\" -F \"file=@" + path + "\"";

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

