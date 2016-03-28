package SpammerAgent;

import Common.Behaviours.ReceiveStartMsgBehaviour;
import Common.Interfaces.IAgentStartable;
import jade.core.Agent;

/**
 * Created by Adam on 2016-03-28.
 */
public class SpammerAgent extends Agent implements IAgentStartable
{
    private boolean isStarted = false;

    private ReceiveStartMsgBehaviour startMsgBehaviour;

    public SpammerAgent() {
        startMsgBehaviour = new ReceiveStartMsgBehaviour(this);
        addBehaviour(startMsgBehaviour);
    }
    @Override
    public void StartAgent() {
        isStarted = true;
        System.out.println(getLocalName() + ": started!");
        //add proper behaviour
        //removeBehaviour();
        removeBehaviour(startMsgBehaviour);
    }
}
