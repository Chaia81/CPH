package Models;

public class Gate {

    Integer gateId;
    Integer flyId;
    String gatePersonale;
    String gateSize;

    public Gate(Integer gateId, Integer flyId, String gatePersonale, String gateSize) {
        this.gateId = gateId;
        this.flyId = flyId;
        this.gatePersonale = gatePersonale;
        this.gateSize = gateSize;
    }

    public Gate() {

    }

    public Integer getGateId() {
        return gateId;
    }

    public void setGateId(Integer gateId) {
        this.gateId = gateId;
    }

    public Integer getFlyId() {
        return flyId;
    }

    public void setFlyId(Integer flyId) {
        this.flyId = flyId;
    }

    public String getGatePersonale() {
        return gatePersonale;
    }

    public void setGatePersonale(String gatePersonale) {
        this.gatePersonale = gatePersonale;
    }

    public String getGateSize() {
        return gateSize;
    }

    public void setGateSize(String gateSize) {
        this.gateSize = gateSize;
    }

    @Override
    public String toString() {
        return "Gate{" +
                "gateId=" + gateId +
                ", flyId=" + flyId +
                ", gatePersonale='" + gatePersonale + '\'' +
                ", gateSize='" + gateSize + '\'' +
                '}';
    }
}
