package data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZJH$$$
 * @date 2024/4/15 19:48
 **/
public class TagDataList {

    public static List<TagData> tagDataList;

    static {
        tagDataList = new ArrayList<>();
        TagData tag1 = new TagData("3008 33B2 DDD9 2000 0415 1111");
        TagData tag2 = new TagData("3008 33B2 DDD9 2000 0415 2222");
        TagData tag3 = new TagData("3008 33B2 DDD9 2000 0415 3333");
        TagData tag4 = new TagData("3008 33B2 DDD9 2000 0415 4444");
        TagData tag5 = new TagData("3008 33B2 DDD9 2000 0415 5555");
        TagData tag6 = new TagData("3008 33B2 DDD9 2000 0415 6666");
        TagData tag7 = new TagData("3008 33B2 DDD9 2000 0415 7777");
        TagData tag8 = new TagData("3008 33B2 DDD9 2000 0415 8888");
        tagDataList.add(tag1);
        tagDataList.add(tag2);
        tagDataList.add(tag3);
        tagDataList.add(tag4);
        tagDataList.add(tag5);
        tagDataList.add(tag6);
        tagDataList.add(tag7);
        tagDataList.add(tag8);
    }
}
