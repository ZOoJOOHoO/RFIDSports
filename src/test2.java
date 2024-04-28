import com.impinj.octane.ImpinjReader;
import com.impinj.octane.OctaneSdkException;
import data.TagDataList;
import save.SaveToTxt;
import setting.ReadSetting;
import setting.TagReportListenerSetting;

import java.io.IOException;
import java.io.PrintStream;

/**
 * @author ZJH$$$
 * @date 2024/4/16 16:30
 **/
public class test2 {
    public static void main(String[] args) throws OctaneSdkException, InterruptedException, IOException {
        ImpinjReader read = new ImpinjReader();
        ReadSetting.loadSettings(read);
        TagReportListenerSetting.loadSetting(read);
        //Thread.sleep(3000);
        read.start();
        //System.out.println("start");
        Thread.sleep(10000);
        read.stop();
        for (int i = 0; i < 8; i++) {
            System.out.println(TagDataList.tagDataList.get(i).getPhase().size());
        }
        //System.out.println(TagDataList.tagDataList.get(4).getPhase().size());
        System.out.println("end");
        SaveToTxt.saveToTxt("D:\\\\JAVAPROJECT\\\\rfidSport\\\\datas\\\\temp");
    }
}
