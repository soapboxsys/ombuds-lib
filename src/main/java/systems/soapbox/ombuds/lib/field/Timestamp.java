package systems.soapbox.ombuds.lib.field;

import java.util.Date;

public class Timestamp extends AbstractField {

    Long time;

    public Timestamp(long time){
        this.time = time;
    }

    public Timestamp(Date time) {
        this.time = time.getTime();
    }

    public Long get() {
        return time;
    }
}
