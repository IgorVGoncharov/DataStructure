public class HeapSort
{

    public static void main(String args[])
    {
        int arr[] = {24, 11, 26, 10, 12, 7};

        HeapSort object = new HeapSort();
        System.out.println("Первоначальный массив");
        printArray(arr);
        object.sort(arr);
        System.out.println("Отсортированный массив");
        printArray(arr);
    }

    public void sort(int array[])
    {
        for (int i = array.length / 2 - 1; i >= 0; i--)
            heapify(array, array.length, i);

        for (int i=array.length-1; i>=0; i--)
        {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }

    void heapify(int array[], int n, int i)
    {
        int largest = i; 
        int leftChild = 2*i + 1; 
        int rightChild = 2*i + 2; 

        if (leftChild < n && array[leftChild] > array[largest])
            largest = leftChild;

        if (rightChild < n && array[rightChild] > array[largest])
            largest = rightChild;

        if (largest != i)
        {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            heapify(array, n, largest);
        }
    }

    static void printArray(int array[])
    {
        int n = array.length;
        for (int i=0; i<n; ++i)
            System.out.print(array[i]+" ");
        System.out.println();
    }



}