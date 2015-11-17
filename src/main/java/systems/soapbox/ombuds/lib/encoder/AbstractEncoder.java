package systems.soapbox.ombuds.lib.encoder;

import com.google.protobuf.ByteString;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.core.TransactionOutput;
import systems.soapbox.ombuds.lib.OmbudsTransaction;
import systems.soapbox.ombuds.lib.record.AbstractRecord;

import java.util.List;

public abstract class AbstractEncoder {

    public static final String OMBPREFIX = "BRETHREN";

    public void encode(OmbudsTransaction tx, AbstractRecord record) throws RecordEncodingException {
        tx.clearOutputs();
        for(TransactionOutput out : makeOutputs(tx.getParams(), makeData(record)) ) {
            tx.addOutput(out);
        }
    }

    public ByteString makeData(AbstractRecord record) {
        ByteString prefix_bytes = ByteString.copyFrom( OMBPREFIX.getBytes() );
        ByteString record_bytes = record.toWire().toByteString();

        return prefix_bytes.concat(record_bytes);
    }

    protected abstract List<TransactionOutput> makeOutputs(NetworkParameters params, ByteString data) throws RecordEncodingException;
}
