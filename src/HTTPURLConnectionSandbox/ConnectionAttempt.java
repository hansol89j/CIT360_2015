package HTTPURLConnectionSandbox;

/**
 * Created by rome on 12/3/2015.
 */

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.quickconnectfamily.json.JSONOutputStream;

public class ConnectionAttempt {
    public static void main(String[] args){
        ConnectionAttempt connectNow = new ConnectionAttempt();
        connectNow.go();
    }


    private void go() {
        // Infinite Loop!!
        while(true){
            try {
                // Instance of Scanner
                Scanner systemInScanner = new Scanner(System.in);
                // Print out the message to be sent
                System.out.printf("Enter message.\n");
                // Put it into a string
                String messageForServer = systemInScanner.nextLine();

                // URL Normal Server
                // ERROR: none, possibly repeats itself
                URL urlOne = new URL("http://localhost:8080/json");
                HttpURLConnection connectionOne = (HttpURLConnection) urlOne.openConnection();
                connectionOne.setDoOutput(true);//allows POST
                // Go out and interact with the URL given, this line is CRITICAL to make it talk to the outside world
                JSONOutputStream outToServerOne = new JSONOutputStream(connectionOne.getOutputStream());


                // URL Empty String
                // ERROR: java.net.MalformedURLException: no protocol:
                URL urlTwo = new URL("");
                HttpURLConnection connectionTwo = (HttpURLConnection) urlTwo.openConnection();
                connectionTwo.setDoOutput(true);//allows POST
                // Go out and interact with the URL given, this line is CRITICAL to make it talk to the outside world
                JSONOutputStream outToServerTwo = new JSONOutputStream(connectionTwo.getOutputStream());


                // URL null
                // ERROR: java.net.MalformedURLException: no protocol:
                URL urlThree = new URL("");
                HttpURLConnection connectionThree = (HttpURLConnection) urlThree.openConnection();
                connectionThree.setDoOutput(true);//allows POST
                // Go out and interact with the URL given, this line is CRITICAL to make it talk to the outside world
                JSONOutputStream outToServerThree = new JSONOutputStream(connectionThree.getOutputStream());


                // URL FTP type
                // ERROR: java.lang.ClassCastException: sun.net.www.protocol.ftp.FtpURLConnection cannot be cast to java.net.HttpURLConnection
                URL urlFour = new URL("ftp://ftp.funet.fi/pub/standards/RFC/rfc959.txt");
                HttpURLConnection connectionFour = (HttpURLConnection) urlFour.openConnection();
                connectionFour.setDoOutput(true);//allows POST
                // Go out and interact with the URL given, this line is CRITICAL to make it talk to the outside world
                JSONOutputStream outToServerFour = new JSONOutputStream(connectionFour.getOutputStream());



                // URL Busy Server
                // ERROR: java.net.ConnectException: Connection timed out: connect
                URL urlFive = new URL("http://www.google.com:81");
                HttpURLConnection connectionFive = (HttpURLConnection) urlFive.openConnection();
                connectionFive.setDoOutput(true);//allows POST
                // Go out and interact with the URL given, this line is CRITICAL to make it talk to the outside world
                JSONOutputStream outToServerFive = new JSONOutputStream(connectionFive.getOutputStream());


                // URL Non Existent
                // ERROR: IOException - if an error occurred connecting to the server.
                URL urlSix = new URL("http://localhost:7070/json");
                HttpURLConnection connectionSix = (HttpURLConnection) urlSix.openConnection();
                connectionSix.setDoOutput(true);//allows POST
                // Go out and interact with the URL given, this line is CRITICAL to make it talk to the outside world
                JSONOutputStream outToServerSix = new JSONOutputStream(connectionSix.getOutputStream());



                // URL Called Twice
                // ERROR: IllegalStateException - if URLConnection is already connected or if a different streaming mode is already enabled.
                URL urlSeven = new URL("http://localhost:7070/json");
                    urlSeven = new URL("http://localhost:7070/json");
                HttpURLConnection connectionSeven = (HttpURLConnection) urlSeven.openConnection();
                connectionSeven.setDoOutput(true);//allows POST
                // Go out and interact with the URL given, this line is CRITICAL to make it talk to the outside world
                JSONOutputStream outToServerSeven = new JSONOutputStream(connectionSeven.getOutputStream());

            }
            catch (Exception e){
                e.printStackTrace();

            }
        }

    }
}
