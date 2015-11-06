package systems.soapbox.ombuds.lib;

import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.core.Transaction;
import systems.soapbox.ombuds.lib.record.AbstractRecord;

public class OmbudsTransaction extends Transaction {

    AbstractRecord record;

    public OmbudsTransaction(NetworkParameters params, AbstractRecord record) {
        super(params);
        this.record = record;
        encodeOutputs();
    }

    private void encodeOutputs(){
        this.clearOutputs();

        // TODO
    }
}
