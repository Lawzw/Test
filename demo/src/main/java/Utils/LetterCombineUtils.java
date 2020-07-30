package Utils;

import java.util.*;

/**
 * 字母拼接工具类
 */
public class LetterCombineUtils {

    /**
     * 拼接方法
     * @param intArr    输入的整型数组
     * @param nowIndex  数组下标
     * @param result    拼接后的字符串列表
     * @return
     */
    public List<String> combine(Integer[] intArr, int nowIndex, List<String> result) {
        if (nowIndex == intArr.length) {
            return result;
        }
        List<String> list = new ArrayList<>();
        //将整型数组转换为整型列表，方便插入数据
        List<Integer> intList = Arrays.asList(intArr);
        int key = intArr[nowIndex];
        //数值大于10
        if (key / 10 > 0) {
            //十位
            int high = key / 10;
            //个位
            int low = key % 10;
            int index = nowIndex;
            intList = new ArrayList<>(intList);
            intList.set(index,high);
            index++;
            intList.add(index,low);
            key = high;
//            intList.stream().forEach(l-> System.out.println("输入列表："+l));
        }
        String[] letters = getLetters(intList.get(nowIndex));
        if (letters != null) {
            if(result.size() == 0){
                list = Arrays.asList(letters);
            }else {
                for (String str : result) {
                    for (int i = 0; i < letters.length; i++) {
                        StringBuilder sb = new StringBuilder(str);
                        sb.append(letters[i]);
                        list.add(sb.toString());
                    }
                }
            }
        }else{
            list = result;
        }
        nowIndex++;
        //递归方法
        return combine(intList.toArray(new Integer[intList.size()]), nowIndex, list);
    }

    /**
     * 获取字母数组
     * @param key
     * @return
     */
    private String[] getLetters(int key) {
        Map<Integer, String[]> map = new HashMap<>();
        map.put(2, new String[]{"A", "B", "C"});
        map.put(3, new String[]{"D", "E", "F"});
        map.put(4, new String[]{"G", "H", "I"});
        map.put(5, new String[]{"J", "K", "L"});
        map.put(6, new String[]{"M", "N", "O"});
        map.put(7, new String[]{"P", "Q", "R", "S"});
        map.put(8, new String[]{"T", "U", "V"});
        map.put(9, new String[]{"W", "X", "Y", "Z"});
        return map.get(key);
    }
}
