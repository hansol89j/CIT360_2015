package sandBoxServlet;

import org.quickconnectfamily.json.JSONException;
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
 * Created by hansoljeong on 2015. 11. 22..
 */
@WebServlet(name = "NastyServlet")
public class NastyServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        try{
            JSONInputStream inFromClient = new JSONInputStream(request.getInputStream());
            JSONOutputStream outToClient = new JSONOutputStream(response.getOutputStream());

            Thread.currentThread().sleep(10000);
            //pauses the current thread in a given time. In this case, the server will be shut down in 10 seconds.

            HashMap<String, Object> dataMap = (HashMap) inFromClient.readObject();

            dataMap.put("toClient", outToClient);

            String aCommand = (String) dataMap.get("command");//put or get??



        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    }

}
