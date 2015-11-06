package systems.soapbox.ombuds.lib.field;

import com.google.protobuf.ByteString;
import org.bitcoinj.core.Sha256Hash;

public class BulletinId extends AbstractField {

    Sha256Hash bltnId;

    public BulletinId(Sha256Hash bltnId) {
        this.bltnId = bltnId;
    }

    @Override
    public ByteString get() {
        return ByteString.copyFrom( bltnId.getBytes() );
    }
}
