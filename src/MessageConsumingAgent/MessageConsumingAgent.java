package MessageConsumingAgent;

import Common.Behaviours.ReceiveStartMsgBehaviour;
import Common.Interfaces.IAgentStartable;
import jade.core.Agent;

/**
 * Created by Adam on 2016-03-28.
 */
public class MessageConsumingAgent extends Agent implements IAgentStartable
{
    private boolean isStarted = false;


    private ReceiveStartMsgBehaviour startMsgBehaviour;
    public MessageConsumingAgent() {
        startMsgBehaviour = new ReceiveStartMsgBehaviour(this);
        addBehaviour(startMsgBehaviour);
    }

    @Override
    public void StartAgent() {
        isStarted = true;
        System.out.println(getLocalName() + ": started!");
        //add proper behaviour
        removeBehaviour(startMsgBehaviour);
    }
}
