package JSONEchoServelt;

import java.util.HashMap;

//

public class ApplicationController {
    //Key String and value Handler?
    private HashMap<String,Handler> handlerMap = new HashMap();


    public void handleRequest(String command, HashMap<String,Object> data){
        Handler aCommandHandler = handlerMap.get(command);
        //If the variable is not null, then...
        if (aCommandHandler != null){
            //Get handleIt from SpeakHandler class.
            aCommandHandler.handleIt(data);
        }
    }

    public void mapCommand(String aCommand, Handler acHandler){
        //Adds the aCommand as the key and object of Handler becomes value
        handlerMap.put(aCommand,acHandler);
    }
}
