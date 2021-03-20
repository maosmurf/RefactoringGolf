
public enum SortKind {
    BUBBLE {
        int[] sort(int[] input) {
            boolean sorted = false;
            while (!sorted) {
                sorted = true;
                for (int i = 0; i < input.length - 1; i++) {
                    if (input[i] > input[i + 1]) {
                        swap(input, i, i + 1);
                        sorted = false;
                    }
                }
            }
            return input;
        }
    },

    QUICK {
        int[] sort(int[] input) {
            return quicksort(input, 0, input.length - 1);
        }

        private int[] quicksort(int[] input, int left, int right) {
            int i = left, j = right;
            int pivot = input[(left + right) / 2];
            int k = i;
            while (k <= j) {
                while (input[k] < pivot)
                    k++;
                while (input[j] > pivot)
                    j--;
                if (k <= j) {
                    swap(input, k, j);
                    k++;
                    j--;
                }
            }
            ;

            i = k;
            int index = i;
            if (left < index - 1) {
                quicksort(input, left, index - 1);
            }
            if (index < right) {
                quicksort(input, index, right);
            }
            return input;
        }
    },

    INSERTION {
        int[] sort(int[] input) {
            for (int i = 0; i < input.length - 1; i++) {
                for (int j = i + 1; j > 0; j--) {
                    if (input[j] < input[j - 1]) {
                        swap(input, j, j - 1);
                    }
                }
            }
            return input;
        }
    };

    abstract int[] sort(int[] input);

    protected void swap(int[] input, int index1, int index2) {
        int first = input[index1];
        int second = input[index2];
        input[index1] = second;
        input[index2] = first;
    }
}
