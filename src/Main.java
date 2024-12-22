import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] value = new int[N + 1];
        int[] path = new int[N + 1];

        value[1] = 0;

        for(int i = 2; i <= N; i++) {

            value[i] = value[i -1] + 1;
            path[i] = i - 1;

            if(i % 2 == 0 && value[i] > value[i / 2] + 1) {
                value[i] = value[i / 2] + 1;
                path[i] = i / 2;
            }

            if(i % 3 == 0 && value[i] > value[i / 3] + 1) {
                value[i] = value[i / 3] + 1;
                path[i] = i / 3;
            }

        }

        System.out.println(value[N]);

        StringBuilder sb = new StringBuilder();
        int current = N;
        while(current > 0) {
            sb.append(current).append(" ");
            current = path[current];
        }

        System.out.print(sb);

    }
}