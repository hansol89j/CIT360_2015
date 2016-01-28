package JSONEchoServelt;

import org.quickconnectfamily.json.JSONOutputStream;

import java.util.HashMap;


public class SpeakHandler implements Handler {
    @Override
    public void handleIt(HashMap<String, Object> dataMap) {
        try{
            //remove() was used so dataMap could be written out to the client.
            JSONOutputStream outToClient = (JSONOutputStream)dataMap.remove("toClient");
            //JSONOutPutStream require that anything being written out implement Serialization.
            //But it is not serialization so toClient has to be removed so dataMap could be back.

            System.out.println("Just got:" + dataMap + " from client");
            dataMap.put("command", "Done");
            outToClient.writeObject(dataMap);
            System.out.println("just sent "+dataMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
