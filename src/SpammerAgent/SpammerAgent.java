package SpammerAgent;

import Common.Behaviours.ReceiveStartMsgBehaviour;
import Common.Interfaces.IAgentStartable;
import Common.Messages.SAMessage;
import jade.core.Agent;

import java.io.Serializable;

/**
 * Created by Adam on 2016-03-28.
 */
public class SpammerAgent extends Agent implements IAgentStartable
{
    private boolean isStarted = false;
    private int N;
    private int M;

    private ReceiveStartMsgBehaviour startMsgBehaviour;

    public SpammerAgent() {
        startMsgBehaviour = new ReceiveStartMsgBehaviour(this);
        addBehaviour(startMsgBehaviour);
    }
    @Override
    public void StartAgent(Serializable data) {
        isStarted = true;
        System.out.println(getLocalName() + ": started!");

        SAMessage msg = (SAMessage)data;
        N = msg.N;
        M = msg.M;
        System.out.println(getLocalName() + ": N = " + N );
        System.out.println(getLocalName() + ": M = " + M );
        //add proper behaviour
        removeBehaviour(startMsgBehaviour);
    }
}
