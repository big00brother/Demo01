import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {

    public static int n;

    public static List<Integer> list = new ArrayList<>();

    public static Set<Integer> primeSet = new HashSet<>();

    public static Map<String, Integer> primeMap = new HashMap<>();

    public static void main(String[] args) {
        setPrimeSet();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        for(int i = 0; i < n; i++) {
            int num = in.nextInt();
            list.add(num);
        }
        System.out.println(dfs(0, 0).total);
    }

    public static void setPrimeSet() {
        primeSet.add(3);
        for(int i = 5; i <= 60000; i += 2) {
            boolean isPrime = true;
            for(int p : primeSet) {
                if((i % p) == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                primeSet.add(i);
            }
        }
    }

    public static void swap(int i, int j) {
        int tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }

    public static DfsData dfs(int start, int depth) {
        if(depth == n / 2) {
            return new DfsData(0, new TreeSet<>());
        }

        int maxTotal = 0;

        for(int i = start + 1; i < n; i++) {

            int addNum = list.get(start) + list.get(i);

            int total = 0;
            if(isPrime(addNum)) {
                total++;
            }

            swap(start + 1, i);

            TreeSet<Integer> indexSet = new TreeSet<>();
            for(int j = start + 2; j < n; j++) {
                indexSet.add(list.get(j));
            }

            StringBuilder stringBuilder = new StringBuilder();
            for(int num : indexSet) {
                stringBuilder.append(num + "_");
            }
            String key = stringBuilder.toString();

            if(primeMap.containsKey(key)) {
                total += primeMap.get(key);
            } else {
                DfsData dfsData = dfs(start + 2, depth + 1);
                total += dfsData.total;

            }

            if(total >= maxTotal) {
                maxTotal = total;
            }

            swap(start + 1, i);
        }

        TreeSet<Integer> set = new TreeSet<>();
        for(int i = start; i < n; i++) {
            set.add(list.get(i));
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int num : set) {
            stringBuilder.append(num + "_");
        }
        primeMap.put(stringBuilder.toString(), maxTotal);
        return new DfsData(maxTotal, set);
    }



    public static boolean isPrime(int num) {
        return primeSet.contains(num);
    }
}


class DfsData {
    public int total;
    public TreeSet<Integer> set = new TreeSet<>();

    public DfsData(int total, TreeSet<Integer> set) {
        this.total = total;
        this.set = set;
    }
}
