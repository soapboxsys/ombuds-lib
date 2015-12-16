package systems.soapbox.ombuds.lib.encoder;

import com.google.protobuf.ByteString;
import org.bitcoinj.core.VarInt;
import systems.soapbox.ombuds.lib.Utils;
import systems.soapbox.ombuds.lib.record.AbstractRecord;

public class OmbudsHeader {

    public static final String OMBFLAG = "OMBUDS";

    public static ByteString make(AbstractRecord record) {
        ByteString flag_bytes = ByteString.copyFromUtf8(OMBFLAG);
        ByteString type_bytes = ByteString.copyFrom( Utils.intToByte8(record.getRecordType()) );

        VarInt length = new VarInt( record.toWire().toByteString().size() + 1 );
        ByteString len_bytes = ByteString.copyFrom(length.encode());

        return flag_bytes.concat( type_bytes.concat(len_bytes) );
    }
}
