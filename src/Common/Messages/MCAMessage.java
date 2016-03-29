package Common.Messages;

import java.io.Serializable;

/**
 * Created by Adam on 2016-03-28.
 */
public class MCAMessage extends Message
{
    public MCAMessage(int n, int machines) {
        super(machines);
        N = n;
    }

    public int N;
}
