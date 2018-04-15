package com.aloe.utils;

import org.n3r.idworker.Sid;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.UUID;

/**
 * id 生成工具 uuid、8位uuid、sid、业务sid
 */
public class GenerateUniqueUtil {
    private static String[] chars = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
            "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8",
            "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z"};
    private static Sid sid;

    static {
        sid = new Sid();
    }

    private static final int LENGTH = 8;


    /**
     * 户编码唯一编号生成规则 共12位= 4位当前月+8位随机唯一[041526051847]
     * 这是典型的随机洗牌算法。 流程是从备选数组中选择一个放入目标数组中，将选取的数组从备选数组移除（放至最后，并缩小选择区域） 算法时间复杂度O(n)
     *
     * @return 随机8为不重复数组
     */
    public static String generateNumber() {
        LocalDate today = LocalDate.now();
//        String yyMMdd = today.format(DateTimeFormatter.BASIC_ISO_DATE);
        String yyMMdd = today.format(DateTimeFormatter.ofPattern("YYMMdd"));
        String no = "";
        // 初始化备选数组
        int[] defaultNums = new int[10];
        for (int i = 0; i < defaultNums.length; i++) {
            defaultNums[i] = i;
        }

        Random random = new Random();
        int[] nums = new int[LENGTH];
        // 默认数组中可以选择的部分长度
        int canBeUsed = 10;
        // 填充目标数组
        for (int i = 0; i < nums.length; i++) {
            // 将随机选取的数字存入目标数组
            int index = random.nextInt(canBeUsed);
            nums[i] = defaultNums[index];
            // 将已用过的数字扔到备选数组最后，并减小可选区域
            swap(index, canBeUsed - 1, defaultNums);
            canBeUsed--;
        }
        if (nums.length > 0) {
            for (int i = 0; i < nums.length; i++) {
                no += nums[i];
            }
        }

        return yyMMdd + no;
    }

    /**
     * uuid 生成8位短的uuid
     *
     * @return
     */
    public static String generateShortUuid() {
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 8; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(chars[x % 0x3E]);
        }
        return shortBuffer.toString();

    }

    /**
     * uuid
     *
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * sid 适用分布式
     *
     * @return
     */
    public static String getSid() {
        return sid.nextShort();
    }

    /**
     * 根据业务生成sid
     *
     * @param prefixStr
     * @return
     */
    public static String getSidOfBiz(String prefixStr) {
        return prefixStr + sid.nextShort();
    }

    private static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
