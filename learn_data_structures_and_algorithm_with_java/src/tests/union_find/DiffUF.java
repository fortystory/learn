package tests.union_find;

import data_structures.union_find.UF;
import data_structures.union_find.UFV1;
import data_structures.union_find.UFV2;
import data_structures.union_find.UFV3;
import data_structures.union_find.UFV4;
import data_structures.union_find.UFV5;
import data_structures.union_find.UFV6;

import java.util.Random;

public class DiffUF {
    public static void main(String[] args) throws Exception {
        int size = 10000000;
        int m = 10000000;

        // UFV1 ufv1 = new UFV1(size);
        // System.out.println("UFv1: "+testUF(ufv1, m)+"s");

        // UFV2 ufv2 = new UFV2(size);
        // System.out.println("UFv2: "+testUF(ufv2, m)+"s");

        // UFV3 ufv3 = new UFV3(size);
        // System.out.println("UFv3: "+testUF(ufv3, m)+"s");

        UFV4 ufv4 = new UFV4(size);
        System.out.println("UFv4: "+testUF(ufv4, m)+"s");

        UFV5 ufv5 = new UFV5(size);
        System.out.println("UFv5: "+testUF(ufv5, m)+"s");

        UFV6 ufv6 = new UFV6(size);
        System.out.println("UFv6: "+testUF(ufv6, m)+"s");
    }

    private static double testUF(UF uf, int m){
        int size = uf.getSize();
        Random random = new Random();
        long starTime = System.nanoTime();
        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a, b);
        }

        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a, b);
        }

        long endTime = System.nanoTime();


        return (endTime - starTime) / 1000000000.0;
    }
}
