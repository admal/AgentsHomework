package ExpMasterAgent;

import ExpMasterAgent.Behaviours.StartBehaviour;
import jade.core.Agent;

/**
 * Created by Adam on 2016-03-28.
 */
public class ExpMasterAgent extends Agent
{
    private int messsageSize = 20;
    private int numOfMessages = 4;

    private int numOfMachines = 1;

    public ExpMasterAgent() {
        addBehaviour(new StartBehaviour(this, numOfMessages, messsageSize, numOfMachines));
    }
}
