package Common.Behaviours;

import Common.Globals;
import Common.Interfaces.IAgentStartable;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;

/**
 * Created by Adam on 2016-03-28.
 */
public class ReceiveStartMsgBehaviour extends CyclicBehaviour {
    public ReceiveStartMsgBehaviour(Agent a) {
        super(a);
    }

    @Override
    public void action() {
        ACLMessage msg = myAgent.receive();
        if(msg != null)
        {
            if(msg.getSender().getLocalName().equals(Globals.MASTER_NAME))
            {
                try {
                IAgentStartable agent = (IAgentStartable)myAgent;

                    agent.StartAgent(msg.getContentObject());
                } catch (UnreadableException e) {
                    e.printStackTrace();
                }
            }
        }
        block();
    }
}
