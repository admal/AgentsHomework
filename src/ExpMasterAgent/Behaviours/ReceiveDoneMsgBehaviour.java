package ExpMasterAgent.Behaviours;

import ExpMasterAgent.ExpMasterAgent;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

/**
 * Created by Adam on 2016-03-31.
 */
public class ReceiveDoneMsgBehaviour extends CyclicBehaviour
{
    private int numOfMachines;
    public ReceiveDoneMsgBehaviour(Agent a, int numOfMachines) {
        super(a);
        this.numOfMachines = numOfMachines;
    }
    private int counter = 0;

    @Override
    public void action() {
        ACLMessage msg = myAgent.receive();
        if(msg != null)
        {
            if(msg.getContent().equals("done"))
            {
                counter++;
                System.out.println(myAgent.getLocalName() + ": done received");
            }
        }
        if(counter >= numOfMachines)
        {
            ExpMasterAgent agent = (ExpMasterAgent)myAgent;
            agent.EndReceiving();
        }
        block();
    }
}
