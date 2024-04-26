import com.impinj.octane.*;
import data.TagData;
import data.TagDataList;
import setting.ReadSetting;
import save.SaveToTxt;
import setting.TagReportListenerSetting;

import java.awt.*;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author ZJH$$$
 * @date 2024/4/2 20:29
 **/

public class test {

    //public static String path ="D:\\\\JAVAPROJECT\\\\rfidSport\\\\datas\\\\箭步蹲R";
    public static String path ="D:\\JAVAPROJECT\\rfidSport\\newData\\positionC\\箭步蹲\\A";

    //采集间隔 period

    //下蹲 6
    //二头弯举 5
    //高抬腿 5
    //侧平举 4
    //推肩 5
    //箭步蹲 5

    public static int period = 6;

    public static void main(String[] args) throws OctaneSdkException, InterruptedException {
        ImpinjReader read = new ImpinjReader();
        ReadSetting.loadSettings(read);
        TagReportListenerSetting.loadSetting(read);

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        final Runnable timerTask = () -> {
            try {
                TagDataList.tagDataList.forEach(TagData::clearData);
                Toolkit.getDefaultToolkit().beep();
                read.start();
            } catch (OctaneSdkException e) {
                throw new RuntimeException(e);
            }

            // 安排另一个任务在period-1秒后执行
            executorService.schedule(() -> {
                try {
                    read.stop();
                    SaveToTxt.saveToTxt(path);
                } catch (OctaneSdkException | IOException e) {
                    throw new RuntimeException(e);
                }
            }, period-1, TimeUnit.SECONDS);
        };

        Thread.sleep(5000);
        System.out.println("start");
        executorService.scheduleAtFixedRate(timerTask, 0, period, TimeUnit.SECONDS);
        Thread.sleep(100000000);
    }
}
