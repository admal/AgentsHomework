package MessageConsumingAgent.Behaviours;

import Common.Globals;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

/**
 * Created by Adam on 2016-03-29.
 */
public class ReceiveSpamBehaviour extends CyclicBehaviour
{
    private int N;
    private int numOfMachines;

    private int counter;
    public ReceiveSpamBehaviour(Agent a, int n, int numOfMachines) {
        super(a);
        N = n;
        this.numOfMachines = numOfMachines;

        counter = 0;
    }

    @Override
    public void action() {
        ACLMessage msg = myAgent.receive();
        if(msg != null)
        {
            if(msg.getOntology().equals("spam"))
            {
                counter++;
                System.out.println(myAgent.getLocalName() + ": spam received");
            }
        }
        if(counter >= N)
        {
            ACLMessage doneMsg = new ACLMessage(ACLMessage.INFORM);
            doneMsg.setContent("done");
            doneMsg.addReceiver(new AID(Globals.MASTER_NAME, AID.ISLOCALNAME));
            myAgent.send(doneMsg);
            System.out.println(myAgent.getLocalName() + ": done msg sent");
            myAgent.removeBehaviour(this);
        }
    }
}
