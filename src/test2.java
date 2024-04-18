import com.impinj.octane.ImpinjReader;
import com.impinj.octane.OctaneSdkException;
import save.SaveToTxt;
import setting.ReadSetting;
import setting.TagReportListenerSetting;

import java.io.IOException;

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
        System.out.println("start");
        Thread.sleep(10000);
        read.stop();
        System.out.println("end");
        SaveToTxt.saveToTxt("D:\\\\JAVAPROJECT\\\\rfidSport\\\\datas\\\\temp");
    }
}
