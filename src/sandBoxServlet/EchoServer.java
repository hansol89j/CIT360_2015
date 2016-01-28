package sandBoxServlet;

import JSONEchoServelt.ApplicationController;
import JSONEchoServelt.SpeakHandler;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by hansoljeong on 2015. 11. 14..
 * Life cycle of Servlet: initialized by init() method --> calls service() method to process a client's request
 * --> terminated by calling the destroy() method --> a garbage collected by the garbage collector of the JVM.
 *
 */

//Annotation to declare the configuration of servlet. It is using to define servlet instead of using XML in the web
//deployment descriptor. I can simplify maintenance and deployments because it keeps the servlet definition inline with
//the servlet's actual code.

//web.xml is deployment descriptor which is the very center of web application. It contains all preferences of web apps.
//
@WebServlet(name = "JSONEchoService", urlPatterns = {"/json"})

//HttpServlet inherits the abstract class of GenericServlet. Has to override doGet() and doPost()
public class EchoServer extends HttpServlet{
    private ApplicationController theAppController = new ApplicationController();

    //Initialize Servlet
    public void init(){
        theAppController.mapCommand("Speak", new SpeakHandler());
        theAppController.mapCommand("정한솔", new SpeakHandler());
    }
    //handles the POST request. It is invoked by the web container. Request results from an HTML form that specifically
    //lists POST as the method.
    // transfers the data to the Client's Web browser.
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            //Data is pulled into the app.
            JSONInputStream inFromClient = new JSONInputStream(request.getInputStream());
            //Sends the data out through the port.
            JSONOutputStream outToClient = new JSONOutputStream(response.getOutputStream());

            Thread.sleep(10000);
            //Casts JSON input into a HashMap because JSON is in a form of a HashMap.
            //Reads the HashMap object from the Client.
            HashMap<String, Object> dataMap = (HashMap) inFromClient.readObject();

            //Sends out data to the client. Adds the key to client with the Value of message that is going to be outputed.
            dataMap.put("toClient", outToClient);

            String aCommand = (String) dataMap.get("command");
            //Stores the HashMap with a key of a string.
            theAppController.handleRequest(aCommand, dataMap);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Handles the GET request. It is invoked by the web container. equest results from a normal request for a URL
    // or from an HTML form that has no METHOD specified
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
