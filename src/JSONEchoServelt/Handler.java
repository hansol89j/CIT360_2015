package JSONEchoServelt;

import java.util.HashMap;

public interface Handler {
    //Since all of the targets you create will implement this interface
    // they will each have a unique implementation of a handleIt method
    public void handleIt(HashMap<String, Object> data);
}
