package systems.soapbox.ombuds.lib.encode.format;

import com.google.protobuf.ByteString;
import org.bitcoinj.core.Coin;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.core.TransactionOutput;
import org.bitcoinj.script.Script;
import org.bitcoinj.script.ScriptBuilder;
import org.bitcoinj.script.ScriptOpCodes;
import systems.soapbox.ombuds.lib.encode.RecordEncodingException;

import java.util.LinkedList;
import java.util.List;

public class NullDataFormat extends AbstractFormat {

    @Override
    protected void precheck(ByteString data) throws RecordEncodingException {
        if(data.size() > OP_RETURN_SIZE)
            throw new RecordEncodingException("data.size() > 80 bytes.");
    }

    @Override
    protected List<TransactionOutput> make(NetworkParameters params, ByteString data) {
        List<TransactionOutput> outputList = new LinkedList<>();

        ScriptBuilder scriptBuilder = new ScriptBuilder();
        Script script = scriptBuilder.op(ScriptOpCodes.OP_RETURN).data(data.toByteArray()).build();

        TransactionOutput null_output = new TransactionOutput(params, null, Coin.valueOf(DUST), script.getProgram());
        outputList.add(null_output);

        return outputList;
    }
}
