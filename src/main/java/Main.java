import aes.AES;

public class Main {
    public static void main(String[] args) {
        short[] key = new short[128]; //128 bit key
        short[] block = new short[128];

        //Time to encrypt 1 GiB of data
        long totalTime = 0;
        for (int i = 0; i < 67_108_864; i += 128) { //8 * 1024 * 1024 * 1024 / 128 = 67,108,864
            long start = System.nanoTime();

            AES.encrypt(block, key);

            long finish = System.nanoTime();
            totalTime += finish - start;
        }

        System.out.printf("Total time =  %d ns or %f ms or %f s", totalTime, totalTime / Math.pow(10, 6), totalTime / Math.pow(10, 9));
    }
}
