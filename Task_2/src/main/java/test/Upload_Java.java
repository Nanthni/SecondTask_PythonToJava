package test;

import java.io.IOException;
import java.util.Scanner;
import java.lang.*;

import static test.Upload_Base.*;

public class Upload_Java {

    public static void main(String[] arg) throws IOException {

        String url = getUrl ( "https://test01.orionic.com/harvester/api/jobs/" );
        String token = getToken ( "mmx-ZMd9yCSKVKrAR25rSVnw" );
        String path = getFilepath ( "C:/Users/IND029/eclipse-workspace/Project1/src/task4.java" );
        String connector = getConnector ( "Harvester_Upload" );
        int id = getId ( 1901 );

        //String command = "curl -gH \"Authorization: Token token=mmx-ZMd9yCSKVKrAR25rSVnw\" \"https://test01.orionic.com/harvester/api/jobs/1901/upload\" --form \"id=1901\" --form \"connection=Harvester_Upload\" -F \"file=@C:/Users/IND029/eclipse-workspace/Project1/src/task4.java\"";
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
