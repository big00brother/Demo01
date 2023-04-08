import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String nStr = in.nextLine();
        int n = Integer.valueOf(nStr.trim());
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        str = str.replace("[", "");
        str = str.replace("]", "");
        String[] words = str.split(",");
        for(int i = 0; i < words.length; i++) {
            String word = words[i].trim();
            if(word.equals("")) {
                continue;
            }
            int num = Integer.valueOf(word);
            if(num >= 0 && num <= 3) {
                list1.add(num);
            } else if(num >= 4 && num <= 7) {
                list2.add(num);
            }
        }
        Collections.sort(list1);
        Collections.sort(list2);
        if(n == 8) {
            if(list1.size() == 4 && list2.size() == 4) {
                System.out.println("[[0, 1, 2, 3, 4, 5, 6, 7]]");
            } else  {
                System.out.println("[]");
            }
        } else if (n == 4) {
            if(list1.size() == 4 && list2.size() == 4) {
                System.out.println("[[0, 1, 2, 3], [4, 5, 6, 7]]");
            } else if(list1.size() == 4 && list2.size() != 4) {
                System.out.println("[[0, 1, 2, 3]]");
            } else if(list1.size() != 4 && list2.size() == 4) {
                System.out.println("[[4, 5, 6, 7]]");
            } else {
                System.out.println("[]");
            }
        } else if (n == 2) {
            if(list1.size() == 2 && list2.size() == 2) {
                String str1 = printString(list1);
                String str2 = printString(list2);
                String printStr = "[" + str1 + ", " + str2 + "]";
                System.out.println(printStr);
            } else if(list1.size() == 2 && list2.size() != 2) {
                String str1 = printString(list1);
                String printStr = "[" + str1 + "]";
                System.out.println(printStr);
            } else if(list1.size() != 2 && list2.size() == 2) {
                String str2 = printString(list2);
                String printStr = "[" + str2 + "]";
                System.out.println(printStr);
            } else if(list1.size() == 4 && list2.size() == 4) {
                String str1 = printStringNum2(list1);
                String str2 = printStringNum2(list2);
                String printStr = "[" + str1 + ", " + str2 + "]";
                System.out.println(printStr);
            } else if(list1.size() == 4 && list2.size() != 4) {
                String str1 = printStringNum2(list1);
                String printStr = "[" + str1 + "]";
                System.out.println(printStr);
            } else if(list1.size() != 4 && list2.size() == 4) {
                String str2 = printStringNum2(list2);
                String printStr = "[" + str2 + "]";
                System.out.println(printStr);
            } else if(list1.size() == 3 && list2.size() == 3) {
                String str1 = printStringNum2(list1);
                String str2 = printStringNum2(list2);
                String printStr = "[" + str1 + ", " + str2 + "]";
                System.out.println(printStr);
            } else if(list1.size() == 3 && list2.size() != 3) {
                String str1 = printStringNum2(list1);
                String printStr = "[" + str1 + "]";
                System.out.println(printStr);
            } else if(list1.size() != 3 && list2.size() == 3) {
                String str2 = printStringNum2(list2);
                String printStr = "[" + str2 + "]";
                System.out.println(printStr);
            } else {
                System.out.println("[]");
            }
        } else if(n == 1) {
            if(list1.size() == 1 && list2.size() == 1) {
                String str1 = printStringNum1(list1);
                String str2 = printStringNum1(list2);
                String printStr = "[" + str1 + ", " + str2 + "]";
                System.out.println(printStr);
            } else if(list1.size() == 1 && list2.size() != 1) {
                String str1 = printStringNum1(list1);
                String printStr = "[" + str1 + "]";
                System.out.println(printStr);
            } else if(list1.size() != 1 && list2.size() == 1) {
                String str2 = printStringNum1(list2);
                String printStr = "[" + str2 + "]";
                System.out.println(printStr);
            } else if(list1.size() == 3 && list2.size() == 3) {
                String str1 = printStringNum1(list1);
                String str2 = printStringNum1(list2);
                String printStr = "[" + str1 + ", " + str2 + "]";
                System.out.println(printStr);
            } else if(list1.size() == 3 && list2.size() != 3) {
                String str1 = printStringNum1(list1);
                String printStr = "[" + str1 + "]";
                System.out.println(printStr);
            } else if(list1.size() != 3 && list2.size() == 3) {
                String str2 = printStringNum1(list2);
                String printStr = "[" + str2 + "]";
                System.out.println(printStr);
            } else if(list1.size() == 2 && list2.size() == 2) {
                String str1 = printStringNum1(list1);
                String str2 = printStringNum1(list2);
                String printStr = "[" + str1 + ", " + str2 + "]";
                System.out.println(printStr);
            } else if(list1.size() == 2 && list2.size() != 2) {
                String str1 = printStringNum1(list1);
                String printStr = "[" + str1 + "]";
                System.out.println(printStr);
            } else if(list1.size() != 2 && list2.size() == 2) {
                String str2 = printStringNum1(list2);
                String printStr = "[" + str2 + "]";
                System.out.println(printStr);
            } else if(list1.size() == 4 && list2.size() == 4) {
                String str1 = printStringNum1(list1);
                String str2 = printStringNum1(list2);
                String printStr = "[" + str1 + ", " + str2 + "]";
                System.out.println(printStr);
            } else if(list1.size() == 4 && list2.size() != 4) {
                String str1 = printStringNum1(list1);
                String printStr = "[" + str1 + "]";
                System.out.println(printStr);
            } else if(list1.size() != 4 && list2.size() == 4) {
                String str2 = printStringNum1(list2);
                String printStr = "[" + str2 + "]";
                System.out.println(printStr);
            } else {
                System.out.println("[]");
            }
        }
    }

    public static String printString(List<Integer> list) {
        StringBuilder stringBuilder = new StringBuilder("[");
        for(int i = 0; i < list.size(); i++) {
            stringBuilder.append(list.get(i));
            if (i != list.size() - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static String printStringNum2(List<Integer> list) {
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < list.size() - 1; i ++) {
            for(int j = i + 1; j < list.size(); j++) {
                stringBuilder.append("[");
                stringBuilder.append(list.get(i));
                stringBuilder.append(", ");
                stringBuilder.append(list.get(j));
                stringBuilder.append("]");
                if(i != list.size() - 2) {
                    stringBuilder.append(", ");
                }
            }
        }
        return stringBuilder.toString();
    }

    public static String printStringNum1(List<Integer> list) {
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < list.size(); i ++) {

            stringBuilder.append("[");
            stringBuilder.append(list.get(i));
            stringBuilder.append("]");
            if(i != list.size() - 1) {
                stringBuilder.append(", ");
            }

        }
        return stringBuilder.toString();
    }
}
