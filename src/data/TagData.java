package data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZJH$$$
 * @date 2024/4/3 23:18
 **/

public class TagData {

    private String EPC;
    private List<Double> phase = new ArrayList<>();
    private List<Double> rssi = new ArrayList<>();
    //private List<Double> doopler = new ArrayList<>();

    public TagData(String EPC) {
        this.EPC = EPC;
    }

    public void addData(double phase, double rssi, double doopler) {
        this.phase.add(phase);
        this.rssi.add(rssi);
        //this.doopler.add(doopler);
    }

    public void clearData() {
        this.phase.clear();
        this.rssi.clear();
        //this.doopler.clear();
    }

    public List<Double> getPhase() {
        return this.phase;
    }

    public List<Double> getRssi() {
        return this.rssi;
    }

}
