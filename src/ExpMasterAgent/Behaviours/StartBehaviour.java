package ExpMasterAgent.Behaviours;

import Common.Messages.MCAMessage;
import Common.Messages.SAMessage;
import Common.Timer;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

import java.io.IOException;

/**
 * Created by Adam on 2016-03-28.
 */
public class StartBehaviour extends OneShotBehaviour {
    /**
     * number of messages
     */
    private int N;
    /**
     * size of each message (in bits)
     */
    private int M;


    private int numOfMachines;

    public StartBehaviour(Agent a, int n, int m, int machines) {
        super(a);
        N = n;
        M = m;
        numOfMachines = machines;
        System.out.print("startBehaviour");
    }

    /**
     * Send message to spammer agents
     */
    private void sendMessageToSA() throws IOException
    {
        ACLMessage message = new ACLMessage(ACLMessage.INFORM);
       // message.setContent("start"); //???
        message.setOntology("starting message ontology"); //????
        message.setContentObject(new SAMessage(M,N, numOfMachines));

        for (int i = 0; i < numOfMachines; i++)
        {
            message.addReceiver(new AID("SA"+i,AID.ISLOCALNAME));
        }
        myAgent.send(message);
    }

    /**
     * Send message to message consuming agents
     */
    private void sendMessageToMCA() throws IOException
    {
        ACLMessage message = new ACLMessage(ACLMessage.INFORM);
        //message.setContent("start"); //???
        message.setOntology("starting message ontology"); //????
        message.setContentObject(new MCAMessage(N, numOfMachines));

        for (int i = 0; i < numOfMachines; i++)
        {
            message.addReceiver(new AID("MCA"+i,AID.ISLOCALNAME));
        }
        myAgent.send(message);
    }

    @Override
    public void action() {
        try {
            Timer timer = Timer.getInstance();
            timer.start();
            sendMessageToMCA();
            sendMessageToSA();

            System.out.println("start message sent");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
