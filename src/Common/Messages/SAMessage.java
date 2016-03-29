package Common.Messages;


/**
 * Created by Adam on 2016-03-28.
 */
public class SAMessage extends Message
{
    public int M;
    public int N;

    public SAMessage(int m, int n, int machines) {
        super(machines);
        M = m;
        N = n;
    }
}
