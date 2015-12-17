package systems.soapbox.ombuds.lib.encode.format;

import com.google.protobuf.ByteString;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.core.TransactionOutput;
import systems.soapbox.ombuds.lib.encode.RecordEncodingException;

import java.util.Collections;
import java.util.List;

public abstract class AbstractFormat {

    // Possible methods (for comparison of formats) :
    //      - amount of unprunable data (AbstractRecord)
    //      - estimate of total size, for fee estimate
    //      - estimate of output costs
    //      - is possible (AbstractRecord, primarily for size)

    // For now, keep this simple, stupid.

    // Constants
    public static final long DUST = 546;            // TODO finalize omb amount
    public static final int OP_RETURN_SIZE = 80;
    public static final int ADDR_LEN = 20;
    public static final int MAX_SIZE = 75000;

    protected abstract void precheck(ByteString data) throws RecordEncodingException;
    protected abstract List<TransactionOutput> make(NetworkParameters params, ByteString data);

    public List<TransactionOutput> makeOutputs(NetworkParameters params, ByteString data) throws RecordEncodingException {
        precheck(data);
        return Collections.unmodifiableList( make(params, data) );
    }
}
