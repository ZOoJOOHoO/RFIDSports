package setting;

import com.impinj.octane.ImpinjReader;
import com.impinj.octane.Tag;
import data.EPCSet;
import data.TagDataList;

import java.util.List;

/**
 * @author ZJH$$$
 * @date 2024/4/15 20:24
 **/
public class TagReportListenerSetting {
    public static void loadSetting(ImpinjReader read){
        read.setTagReportListener((reader, report) -> {
            List<Tag> tags = report.getTags();
            for (Tag t : tags) {
                if (EPCSet.epcSet.contains(t.getEpc().toString())) {
                    //System.out.println(t.getEpc().toString());
                    switch (t.getEpc().toString().substring(25)) {
                        case "1111" ->
                                TagDataList.tagDataList.get(0).addData(t.getPhaseAngleInRadians(), t.getPeakRssiInDbm(), t.getRfDopplerFrequency());
                        case "2222" ->
                                TagDataList.tagDataList.get(1).addData(t.getPhaseAngleInRadians(), t.getPeakRssiInDbm(), t.getRfDopplerFrequency());
                        case "3333" ->
                                TagDataList.tagDataList.get(2).addData(t.getPhaseAngleInRadians(), t.getPeakRssiInDbm(), t.getRfDopplerFrequency());
                        case "4444" ->
                                TagDataList.tagDataList.get(3).addData(t.getPhaseAngleInRadians(), t.getPeakRssiInDbm(), t.getRfDopplerFrequency());
                        case "5555" ->
                                TagDataList.tagDataList.get(4).addData(t.getPhaseAngleInRadians(), t.getPeakRssiInDbm(), t.getRfDopplerFrequency());
                        case "6666" ->
                                TagDataList.tagDataList.get(5).addData(t.getPhaseAngleInRadians(), t.getPeakRssiInDbm(), t.getRfDopplerFrequency());
                        case "7777" ->
                                TagDataList.tagDataList.get(6).addData(t.getPhaseAngleInRadians(), t.getPeakRssiInDbm(), t.getRfDopplerFrequency());
                        case "8888" ->
                                TagDataList.tagDataList.get(7).addData(t.getPhaseAngleInRadians(), t.getPeakRssiInDbm(), t.getRfDopplerFrequency());
                    }
                }
            }
        });
    }
}
