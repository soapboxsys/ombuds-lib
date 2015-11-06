package systems.soapbox.ombuds.lib.record;

import systems.soapbox.ombuds.lib.field.BulletinId;
import systems.soapbox.ombuds.lib.field.Timestamp;
import systems.soapbox.wirerecord.OmbudsWireProtos;

public class Endorsement extends AbstractRecord {

    BulletinId bltnId;
    Timestamp time;

    public Endorsement(BulletinId bltnId, Timestamp time){
        this.bltnId = bltnId;
        this.time = time;
    }

    public OmbudsWireProtos.WireEndorsment toWire(){
        OmbudsWireProtos.WireEndorsment.Builder endorseBuilder = OmbudsWireProtos.WireEndorsment.newBuilder();

        // Required Fields
        endorseBuilder.setBltnid(bltnId.get());
        endorseBuilder.setTimestamp(time.get());

        return endorseBuilder.build();
    }
}
