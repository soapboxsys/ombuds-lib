package systems.soapbox.ombuds.lib.encode.format;

import com.google.protobuf.ByteString;
import org.bitcoin.protocols.payments.Protos;
import org.bitcoinj.core.Address;
import org.bitcoinj.core.Coin;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.core.TransactionOutput;
import org.bitcoinj.script.Script;
import org.bitcoinj.script.ScriptBuilder;
import systems.soapbox.ombuds.lib.encode.RecordEncodingException;

import java.util.LinkedList;
import java.util.List;

public class P2PKHFormat extends AbstractFormat {

    @Override
    protected void precheck(ByteString data) throws RecordEncodingException {
        if(data.size() > MAX_SIZE)
            throw new RecordEncodingException("data.size() > " + MAX_SIZE);
    }

    @Override
    protected List<TransactionOutput> make(NetworkParameters params, ByteString data) {
        LinkedList<TransactionOutput> outputList = new LinkedList<>();

        Protos.Output.Builder outputBuilder = Protos.Output.newBuilder();
        outputBuilder.setAmount( DUST);
        for( byte[] dataChunk : buildChunkList(data) ){
            Address addr = new Address(params, dataChunk);
            Script script = ScriptBuilder.createOutputScript(addr);

            TransactionOutput output = new TransactionOutput(params, null, Coin.valueOf(DUST), script.getProgram());
            outputList.addLast(output);
        }

        return outputList;
    }

    private List<byte[]> buildChunkList(ByteString data){
        LinkedList<byte[]> chunkList = new LinkedList<>();
        int q = ADDR_LEN;

        byte[] chunk = new byte[q];
        for(int i = 0; i < data.size(); i++){
            chunk[i%q] = data.byteAt(i);
            if( (i+1)%q == 0 || i+1 >= data.size()){
                chunkList.addLast(chunk);
                chunk = new byte[q];
            }
        }

        return chunkList;
    }
}
