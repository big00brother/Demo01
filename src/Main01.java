import java.util.*;

public class Main01 {

    public static String IN = "IN";

    public static String OUT = "OUT";

    public static void main(String[] args) {

        int fileIndex = 0;

        List<PriorityQueue<PrintStruct>> list = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            list.add(new PriorityQueue<>(new Comparator<PrintStruct>() {
                @Override
                public int compare(PrintStruct o1, PrintStruct o2) {

                    if(o1.priority != o2.priority) {
                        return o2.priority - o1.priority;
                    }
                    return o1.index - o2.index;
                }
            }));
        }

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int n = Integer.valueOf(str.trim());
        for(int i = 0; i < n; i++) {
            String line = in.nextLine();
            String[] words = line.split(" ");
            if(words[0].trim().equals(IN)) {
                int p = Integer.valueOf(words[1].trim());
                int num = Integer.valueOf(words[2].trim());
                fileIndex++;
                PrintStruct printStruct = new PrintStruct(fileIndex, num);
                list.get(p - 1).add(printStruct);
            } else if(words[0].trim().equals(OUT)){
                int p = Integer.valueOf(words[1].trim());
                if(p > 5 || p <= 0) {
                    System.out.println("NULL");
                    continue;
                }
                PriorityQueue<PrintStruct> priorityQueue = list.get(p - 1);
                if(priorityQueue.isEmpty()) {
                    System.out.println("NULL");
                } else {
                    PrintStruct printStruct = priorityQueue.poll();
                    System.out.println(printStruct.index);
                }
            }
        }
    }
}

class PrintStruct {
    public int index;

    public int priority;

    public PrintStruct(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }
}


