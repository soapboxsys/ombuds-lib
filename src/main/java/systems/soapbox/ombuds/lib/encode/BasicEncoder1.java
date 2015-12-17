package systems.soapbox.ombuds.lib.encode;

import com.google.protobuf.ByteString;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.core.TransactionOutput;
import systems.soapbox.ombuds.lib.encode.format.NullDataFormat;
import systems.soapbox.ombuds.lib.encode.format.P2PKHFormat;

import java.util.List;

public class BasicEncoder1 extends AbstractEncoder {

    NullDataFormat nullDataFormat;
    P2PKHFormat p2pkhFormat;

    public BasicEncoder1() {
        nullDataFormat = new NullDataFormat();
        p2pkhFormat = new P2PKHFormat();
    }

    @Override
    protected List<TransactionOutput> makeOutputs(NetworkParameters params, ByteString data) throws RecordEncodingException {
        try {
            return nullDataFormat.makeOutputs(params, data);
        } catch(RecordEncodingException e) {
            // swallow
        }

        try {
            return p2pkhFormat.makeOutputs(params, data);
        } catch(RecordEncodingException e) {
            // swallow
        }

        throw new RecordEncodingException("BasicEncoder1 found no acceptable formats.");
    }
}
