package systems.soapbox.ombuds.lib;

import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.core.Transaction;
import org.bitcoinj.core.Wallet;
import systems.soapbox.ombuds.lib.encoder.AbstractEncoder;
import systems.soapbox.ombuds.lib.encoder.RecordEncodingException;
import systems.soapbox.ombuds.lib.record.AbstractRecord;

public class OmbudsTransaction extends Transaction {

    // Constants
    // Don't forget about REFERENCE_DEFAULT_MIN_TX_FEE

    private AbstractRecord record;
    private AbstractEncoder encoder;

    public OmbudsTransaction(NetworkParameters params, AbstractRecord record, AbstractEncoder encoder) throws RecordEncodingException {
        super(params);
        this.record = record;
        this.encoder = encoder;

        encoder.encode(this, record);
    }

    public Wallet.SendRequest toSendRequest() {
        Wallet.SendRequest req = Wallet.SendRequest.forTx(this);
        req.shuffleOutputs = false;
        req.feePerKb = this.REFERENCE_DEFAULT_MIN_TX_FEE.multiply(3);    // TODO
        return req;
    }
}
