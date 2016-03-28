package Common;

import java.io.Serializable;

/**
 * Created by Adam on 2016-03-28.
 */
public class SAMessage implements Serializable
{
    public int M;
    public int N;

    public SAMessage(int m, int n) {
        M = m;
        N = n;
    }
}
