package JSONEchoServelt;

import org.quickconnectfamily.json.JSONOutputStream;

import java.util.HashMap;

/**
 * Created by hansoljeong on 2015. 12. 1..
 */
public class NastyHandler implements Handler{
    @Override
    public void handleIt(HashMap<String, Object> dataMap) {
        try{
            //remove() was used so dataMap could be written out to the client.
            System.out.println("Nasty path is working.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
