package save;

import data.TagDataList;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ZJH$$$
 * @date 2024/4/3 21:20
 **/

public class SaveToTxt {
    public static void saveToTxt(String folderPath) throws IOException {
        String newFilePath = getNewFilePath(folderPath);
        write(getNewFilePath(folderPath));
        System.out.println(newFilePath + " created successfully.");
    }

    public static void write(String newFilePath) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(newFilePath));
        for (int i = 0; i < 8; i++) {
            for (Double data : TagDataList.tagDataList.get(i).getPhase()) {
                bw.write(String.valueOf(data));
                bw.write(" ");
            }
            bw.newLine();
            for (Double data : TagDataList.tagDataList.get(i).getRssi()) {
                bw.write(String.valueOf(data));
                bw.write(" ");
            }
            bw.newLine();
        }
        bw.flush();
    }

    public static String getNewFilePath(String folderPath){
        File folder = new File(folderPath);
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt"));

        // 使用正则表达式匹配文件名中的数字
        Pattern pattern = Pattern.compile("^(\\d+)\\.txt$");
        int maxNumber = -1;

        // 遍历文件以找到最大的数字
        if (files != null) {
            for (File file : files) {
                Matcher matcher = pattern.matcher(file.getName());
                if (matcher.matches()) {
                    int number = Integer.parseInt(matcher.group(1));
                    if (number > maxNumber) {
                        maxNumber = number;
                    }
                }
            }
        }

        // 如果没有找到任何文件或文件不包含数字，则默认使用1作为起始数字
        int newNumber = maxNumber != -1 ? maxNumber + 1 : 1;
        String newFileName = newNumber + ".txt";
        String newFilePath = folderPath + File.separator + newFileName;
        return newFilePath;
    }
}
