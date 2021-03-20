
public enum SortKind {
    BUBBLE {
        int[] sort(int[] input) {
            Swapper swapper = swapperFor(input);
            boolean sorted = false;
            while (!sorted) {
                sorted = true;
                for (int i = 0; i < input.length - 1; i++) {
                    if (input[i] > input[i + 1]) {
                        swapper.basedOn(i).swap(i + 1);
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
            Swapper swapper = swapperFor(input);
            int i = left, j = right;
            int pivot = input[(left + right) / 2];
            int k = i;
            while (k <= j) {
                while (input[k] < pivot)
                    k++;
                while (input[j] > pivot)
                    j--;
                if (k <= j) {
                    swapper.basedOn(k).swap(j);
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
            Swapper swapper = swapperFor(input);

            for (int i = 0; i < input.length - 1; i++) {
                for (int j = i + 1; j > 0; j--) {
                    if (input[j] < input[j - 1]) {
                        swapper.basedOn(j).swap(j - 1);
                    }
                }
            }
            return input;
        }
    };

    abstract int[] sort(int[] input);

    private interface Swapper {
        void swap(int begin, int end);

        default BasedSwapper basedOn(int begin) {
            return end -> swap(begin, end);
        }
    }

    private interface BasedSwapper {
        void swap(int end);
    }

    protected Swapper swapperFor(int[] input) {
        return (begin, end) -> {
            int first = input[begin];
            int second = input[end];
            input[begin] = second;
            input[end] = first;
        };
    }

    // last idea - to get all curried functions take only one parameter:
    // (not completed)
    // Function<Function<Integer[], Function<Integer, Function<Integer, Integer>>>, Void>
}
