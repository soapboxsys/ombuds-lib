package systems.soapbox.ombuds.lib.record;

public abstract class AbstractRecord {
    // Keep AbstractRecord agnostic to NetworkParameters
    public abstract com.google.protobuf.GeneratedMessage toWire();
}
