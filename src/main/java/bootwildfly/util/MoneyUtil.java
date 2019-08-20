package bootwildfly.util;

public class MoneyUtil {

    private static final String UNIT = "萬仟佰拾亿仟佰拾萬仟佰拾元角分";
    private static final String DIGIT = "零壹贰叁肆伍陆柒捌玖";
    private static final double MAX_VALUE = 9999999999999.99D;

    public static String convert(String str) {
        try {

            double v = Double.parseDouble(str);
            return convert(v);
        } catch (Exception ex) {
            return "参数非法!";
        }
    }

    public static String convert(double v) {
        if (v < 0 || v > MAX_VALUE){
            return "参数非法!";
        }
        long l = Math.round(v * 100);
        if (l == 0){
            return "零元整";
        }
        String strValue = l + "";
        // i用来控制数
        int i = 0;
        // j用来控制单位
        int j = UNIT.length() - strValue.length();
        String rs = "";
        boolean isZero = false;
        for (; i < strValue.length(); i++, j++) {
            char ch = strValue.charAt(i);
            if (ch == '0') {
                isZero = true;
                if (UNIT.charAt(j) == '亿' || UNIT.charAt(j) == '萬' || UNIT.charAt(j) == '元') {
                    rs = rs + UNIT.charAt(j);
                    isZero = false;
                }
            } else {
                if (isZero) {
                    rs = rs + "零";
                    isZero = false;
                }
                rs = rs + DIGIT.charAt(ch - '0') + UNIT.charAt(j);
            }
        }
        if (!rs.endsWith("分")) {
            rs = rs + "整";
        }
        rs = rs.replaceAll("亿萬", "亿");
        return rs;
    }

    public static void main(String[] args){
        System.out.println(MoneyUtil.convert(12356789.9845));
        System.out.println(MoneyUtil.convert("212356789.9845"));
        System.out.println(MoneyUtil.convert("5123123.00"));
    }

}
