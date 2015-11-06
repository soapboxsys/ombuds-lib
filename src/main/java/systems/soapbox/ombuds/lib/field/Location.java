package systems.soapbox.ombuds.lib.field;

import systems.soapbox.wirerecord.OmbudsWireProtos;

public class Location extends AbstractOptionalField {

    private Double lat;
    private Double lon;
    private Double h;

    public Location(){
        clear();
    }

    public Location(double lat, double lon, double h) {
        set(lat, lon, h);
    }

    public void clear() {
        lat = null;
        lon = null;
        h = null;
    }

    public void set(double lat, double lon, double h) {
        this.lat = lat;
        this.lon = lon;
        this.h = h;
    }

    @Override
    public boolean enabled() {
        return lat != null && lon != null && h != null;
    }

    @Override
    public OmbudsWireProtos.Location get() {
        OmbudsWireProtos.Location.Builder locBuilder = OmbudsWireProtos.Location.newBuilder();
        locBuilder.setLat(lat);
        locBuilder.setLon(lon);
        locBuilder.setH(h);

        return locBuilder.build();
    }
}
