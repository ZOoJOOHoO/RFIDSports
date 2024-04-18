package setting;

import com.impinj.octane.*;
import data.EPCSet;
import data.TagDataList;

import java.util.List;

/**
 * @author ZJH$$$
 * @date 2024/4/2 20:36
 **/
public class ReadSetting {
    public static void loadSettings(ImpinjReader read) throws OctaneSdkException {
        String hostname = "speedwayr-10-8F-39";
        read.connect(hostname);
        Settings settings = read.queryDefaultSettings();
        settings.getReport().setIncludeAntennaPortNumber(true);
        settings.getReport().setMode(ReportMode.Individual);
        settings.getAntennas().disableAll();
        settings.getAntennas().enableById(new short[]{1});
        settings.getAntennas().getAntenna((short) 1).setIsMaxTxPower(true);
        settings.getAntennas().getAntenna((short) 1).setIsMaxRxSensitivity(true);
        settings.getReport().setIncludePeakRssi(true);
        settings.getReport().setIncludePhaseAngle(true);
        settings.getReport().setIncludeDopplerFrequency(true);
        read.applySettings(settings);
    }
}
