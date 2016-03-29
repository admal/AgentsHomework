package Common.Messages;

import java.io.Serializable;

/**
 * Created by Adam on 2016-03-29.
 */
public class Message implements Serializable
{
    public int numOfMachines;

    public Message(int numOfMachines) {
        this.numOfMachines = numOfMachines;
    }

}
