package SpammerAgent.Behaviours;

import Common.Globals;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

/**
 * Created by Adam on 2016-03-28.
 */
public class SpamBehaviour extends CyclicBehaviour
{
    /**
     * Message size
     */
    private int M;
    /**
     * Number of messages
     */
    private int N;
    private int counter = 0;

    private int numOfMachines;

    public SpamBehaviour(Agent a, int m, int n, int machines) {
        super(a);
        M = m;
        N = n;
        numOfMachines = machines;
    }

    @Override
    public void action() {
        ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
        msg.setOntology("spam");
        msg.setContent("spam msg");
        for (int i = 0; i < numOfMachines; i++)
        {
            System.out.println(myAgent.getLocalName() + ": spam sent");
            msg.addReceiver(new AID("MCA"+i, AID.ISLOCALNAME));
        }
        myAgent.send(msg);
        counter++;

        if (counter >= N) {
            myAgent.removeBehaviour(this);
            return;
        }
    }
}
