package lt.codeacademy.json.example.Task;

import java.io.Serializable;

public class Payment implements Serializable {
    private Sender sender;
    private Receiver receiver;

    public Payment() {
    }

    public Payment(Sender sender, Receiver receiver) {
        this.sender = sender;
        this.receiver = receiver;
    }

    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "sender=" + sender +
                ", receiver=" + receiver +
                '}';
    }
}
