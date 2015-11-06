package systems.soapbox.ombuds.lib.field;

public class Message extends AbstractField {

    private String msg;

    public Message(String msg) {
        this.msg = msg;
    }

    @Override
    public String get() {
        return msg;
    }
}
