package systems.soapbox.ombuds.lib.record;

import systems.soapbox.ombuds.lib.field.Location;
import systems.soapbox.ombuds.lib.field.Message;
import systems.soapbox.ombuds.lib.field.Timestamp;
import systems.soapbox.wirerecord.OmbudsWireProtos;

public class Bulletin extends AbstractRecord {

    Message msg;
    Timestamp time;
    Location loc;

    public Bulletin(Message msg, Timestamp time, Location loc) {
        this.msg = msg;
        this.time = time;
        this.loc = loc;
    }

    @Override
    public OmbudsWireProtos.WireBulletin toWire() {
        OmbudsWireProtos.WireBulletin.Builder bltnBuilder = OmbudsWireProtos.WireBulletin.newBuilder();

        // Required Fields
        bltnBuilder.setMessage(msg.get());
        bltnBuilder.setTimestamp(time.get());

        // Non-required Fields
        if(loc.enabled()) {
            bltnBuilder.setLocation(loc.get());
        }

        return bltnBuilder.build();
    }
}
