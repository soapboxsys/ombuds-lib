package systems.soapbox.ombuds.lib;

import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import systems.soapbox.ombuds.lib.encoder.OmbudsHeader;
import systems.soapbox.ombuds.lib.field.Location;
import systems.soapbox.ombuds.lib.field.Message;
import systems.soapbox.ombuds.lib.field.Timestamp;
import systems.soapbox.ombuds.lib.record.Bulletin;

public class OmbudsHeaderTest extends TestCase {

    protected Message msg;
    protected Timestamp time;
    protected Location loc;
    protected Bulletin bltn;

    protected void setUp() {
        msg = new Message("Hello world!");
        time = new Timestamp(12345678);
        loc = new Location();
        bltn = new Bulletin(msg, time, loc);
    }

    @Test
    public void testBytes1() {
        byte[] expectedArray = Utils.hexToBytes("4f4d425544530114");
        byte[] resultArray = OmbudsHeader.make(bltn).toByteArray();
        System.out.println(Utils.bytesToHex(resultArray));

        assertArrayEquals(expectedArray, resultArray);
    }


}
