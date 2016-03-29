package MessageConsumingAgent;

import Common.Behaviours.ReceiveStartMsgBehaviour;
import Common.Interfaces.IAgentStartable;
import Common.Messages.MCAMessage;
import MessageConsumingAgent.Behaviours.ReceiveSpamBehaviour;
import jade.core.Agent;

import java.io.Serializable;

/**
 * Created by Adam on 2016-03-28.
 */
public class MessageConsumingAgent extends Agent implements IAgentStartable
{
    private boolean isStarted = false;

    private int N = 0;
    private int numOfMachines;

    private ReceiveStartMsgBehaviour startMsgBehaviour;
    public MessageConsumingAgent() {
        startMsgBehaviour = new ReceiveStartMsgBehaviour(this);
        addBehaviour(startMsgBehaviour);
    }

    @Override
    public void StartAgent(Serializable data) {
        isStarted = true;
        System.out.println(getLocalName() + ": started!");
        MCAMessage msg = (MCAMessage)data;
        N += msg.N;
        numOfMachines = msg.numOfMachines;
        System.out.println(getLocalName() + ": N = " + N );
        //add proper behaviour
        removeBehaviour(startMsgBehaviour);

        addBehaviour(new ReceiveSpamBehaviour(this,N,numOfMachines));
    }
}
