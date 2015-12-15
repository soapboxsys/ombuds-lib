package systems.soapbox.ombuds.lib.record;

public abstract class AbstractRecord {
    // Keep AbstractRecord agnostic to NetworkParameters
    public abstract int getRecordType();
    public abstract com.google.protobuf.GeneratedMessage toWire();
}
