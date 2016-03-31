package ExpMasterAgent;

import ExpMasterAgent.Behaviours.ReceiveDoneMsgBehaviour;
import ExpMasterAgent.Behaviours.StartBehaviour;
import jade.core.Agent;

/**
 * Created by Adam on 2016-03-28.
 */
public class ExpMasterAgent extends Agent
{
    private int messsageSize = 20;
    private int numOfMessages = 4;

    private int numOfMachines = 2;

    public ExpMasterAgent() {
        addBehaviour(new StartBehaviour(this, numOfMessages, messsageSize, numOfMachines));
        addBehaviour(new ReceiveDoneMsgBehaviour(this, numOfMachines));
    }
    public void EndReceiving()
    {

        //do sth with stopwatch
        System.out.println("All msg done");

    }
}
