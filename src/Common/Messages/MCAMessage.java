package Common.Messages;

import java.io.Serializable;

/**
 * Created by Adam on 2016-03-28.
 */
public class MCAMessage implements Serializable
{
    public MCAMessage(int n) {
        N = n;
    }

    public int N;
}
