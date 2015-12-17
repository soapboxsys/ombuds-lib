package systems.soapbox.ombuds.lib.encode;

public class RecordEncodingException extends Exception {

    public RecordEncodingException(String message) {
        super(message);
    }

    public RecordEncodingException(String message, Throwable ex) {
        super(message, ex);
    }
}
