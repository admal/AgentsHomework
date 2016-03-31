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

    private String buildMessage()
    {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < M; i++)
            builder.append('k');
        return builder.toString();
    }

    @Override
    public void action() {
        ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
        msg.setOntology("spam");
        msg.setContent(buildMessage());
        for (int i = 0; i < numOfMachines; i++)
        {
           // System.out.println(myAgent.getLocalName() + ": spam sent i = " + counter);
            msg.addReceiver(new AID("MCA"+i, AID.ISLOCALNAME));
        }
        myAgent.send(msg);
        counter++;

        if (counter >= N) {
            System.out.println(myAgent.getLocalName() +": destroyed");
            myAgent.removeBehaviour(this);
            return;
        }
    }
}
