import java.util.*;

public class Solution {
    private Random random = new Random();
    private int MAX_SIZE = 100000;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }

    private void solve() {
        int[] a = new int[MAX_SIZE];
        for (int i = 0; i < MAX_SIZE; ++i) a[i] = random.nextInt(MAX_SIZE);
        int[] b = Arrays.copyOfRange(a, 0, MAX_SIZE);
        Arrays.sort(b);
        solve(a, b);
    }

    private boolean compare(int[] a, int b[]) {
        if (a.length != b.length) return false;

        for (int i = 0; i < a.length; ++i) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    private void swap(int[] a, int x, int y) {
        if (x == y) return;
        a[x] ^= a[y];
        a[y] ^= a[x];
        a[x] ^= a[y];
    }

    private void debug(int[] a) {
        for (int i: a) System.out.print(i + " ");
        System.out.println();
    }
    /*
     * 1. Insertion Sort
     * 2. Selection Sort
     * 3. Bubble Sort
     * 4. Quick Sort
     * 5. Merge Sort
     * 6. Heap Sort
     */
    private void solve(int[] a, int[] sortedResult) {
        int[] a1 = Arrays.copyOfRange(a, 0, MAX_SIZE);
        long t1 = System.currentTimeMillis();
        insertionSort(a1);
        System.out.println("Insertion Sort: " + (System.currentTimeMillis() - t1) + " - " + compare(a1, sortedResult));

        int[] a2 = Arrays.copyOfRange(a, 0, MAX_SIZE);
        long t2 = System.currentTimeMillis();
        selectionSort(a2);
        System.out.println("Selection Sort: " + (System.currentTimeMillis() - t2) + " - " + compare(a2, sortedResult));

        int[] a3 = Arrays.copyOfRange(a, 0, MAX_SIZE);
        long t3 = System.currentTimeMillis();
        bubbleSort(a3);
        System.out.println("Bubble Sort: " + (System.currentTimeMillis() - t3) + " - " + compare(a3, sortedResult));

        int[] a4 = Arrays.copyOfRange(a, 0, MAX_SIZE);
        long t4 = System.currentTimeMillis();
        quickSort(a4, 0, MAX_SIZE - 1);
        System.out.println("Quick Sort: " + (System.currentTimeMillis() - t4) + " - " + compare(a4, sortedResult));

        int[] a5 = Arrays.copyOfRange(a, 0, MAX_SIZE);
        long t5 = System.currentTimeMillis();
        mergeSort(a5, 0, MAX_SIZE - 1);
        System.out.println("Merge Sort: " + (System.currentTimeMillis() - t5) + " - " + compare(a5, sortedResult));

        int[] a6 = Arrays.copyOfRange(a, 0, MAX_SIZE);
        long t6 = System.currentTimeMillis();
        heapSort(a6);
        System.out.println("Heap Sort: " + (System.currentTimeMillis() - t6) + " - " + compare(a6, sortedResult));
    }

    private void heapSort(int[] a) {
        Heap heap = new Heap(a.length);
        for (int e: a) heap.add(e);
        for (int i = 0; i < a.length; ++i) a[i] = heap.poll();
    }

    class Heap {
        int[] heap;
        int size = 0;

        Heap(int maxSize) {
            this.heap = new int[maxSize + 1];
        }

        void add(int e) {
            heap[++size] = e;
            int index = size;
            for (int i = size; i > 1; i /= 2) {
                if (heap[i/2] <= heap[i]) return;
                swap(heap, i, i/2);
            }
        }

        void correctHeap(int index) {
            int left = index * 2 > size ? Integer.MAX_VALUE : heap[index * 2];
            int right = index * 2 + 1 > size ? Integer.MAX_VALUE : heap[index * 2 + 1];

            if (heap[index] <= left && heap[index] <= right) return;

            if (left <= right) {
                swap(heap, index, index * 2);
                correctHeap(index * 2);
            }
            else {
                swap(heap, index, index * 2 + 1);
                correctHeap(index * 2 + 1);
            }
        }

        private int poll() {
            int result = heap[1];
            heap[1] = heap[size--];
            correctHeap(1);
            return result;
        }
    }

    private void mergeSort(int[] a, int s, int e) {
        if (s == e) return;
        int m = (s + e) / 2;
        mergeSort(a, s, m);
        mergeSort(a, m + 1, e);
        int l = s, r = m + 1;
        int[] tmp = new int[e - s + 1];
        int count = 0;
        while (l <= m && r <= e) {
            if (a[l] < a[r]) tmp[count++] = a[l++];
            else tmp[count++] = a[r++];
        }
        while (l <= m) tmp[count++] = a[l++];
        while (r <= e) tmp[count++] = a[r++];
        for (int i = 0; i < count; ++i) a[s + i] = tmp[i];
    }

    // Choose a[s] as pivot value
    private void quickSort(int[] a, int s, int e) {
        if (s >= e) return;
        int m = s + 1;
        for (int i = s + 1; i <= e; ++i) {
            if (a[i] < a[s]) swap(a, i, m++);
        }
        swap(a, s, m - 1);
        quickSort(a, s, m - 2);
        quickSort(a, m, e);
    }

    private void bubbleSort(int[] a) {
        int n = a.length;
        for (int i = n - 1; i >= 0; --i) {
            for (int j = 0; j < i; ++j) {
                if (a[j] > a[j + 1]) swap(a, j, j + 1);
            }
        }
    }

    private void selectionSort(int[] a) {
        int n = a.length;
        for (int i = n - 1; i >= 0; --i) {
            for (int j = 0; j < i; ++j) if (a[i] < a[j]) swap(a, i, j);
        }
    }

    private void insertionSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j > 0 && j < n && a[j] < a[j - 1]; --j) swap(a, j, j - 1);
        }
    }
}
