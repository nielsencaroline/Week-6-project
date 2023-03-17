import java.util.Arrays;
/**
 * @file StatsCalculator.java
 * @Date 3/17/23
 * @Author Caroline Nielsen
 *
 * @Description uses an array to calculate minimum, first quartile, median, third quartile, maximum, and mean
 */

public class StatsCalculator {
    /**
     * @description creates double array of values
     */
        private double[] arr;
    /**
     * @description creates double array of sorted numbers
     */
        private double[] sortedArr;

        /**
         * Default constructor that creates an array of 20 zeros
         */
    public StatsCalculator(){
            arr = new double[20];
            sortedArr = new double[20];
            Arrays.sort(sortedArr);
        }
    /**
     * Constructor that creates a StatsCalculator object with a user defined array
     *
     * @param arr The array input by the user
     */

    public StatsCalculator(double[] arr){
             this.arr = arr;
             sortedArr = arr;
        }
    /**
     * Sorts the values in increasing direction
     * Java.util.Arrays.copyOf() method returns a copy of the original array
     * @return sorted numbers
     */

    public void sortData(){
        sortedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedArr);
    }
    /**
     * @description calculates the max in the sorted array
     * @return max
     */
    public double calculateMax(){
            double max = arr[0];
            for (double num : arr) {
                 if (num >= max) {
                    max = num;
                 }
            }
            return max;
        }
    /**
     * @description calculates the min of the sorted array
     * @return min
     */
       public double calculateMin(){
           double min = arr[0];
           for (double num : arr) {
               if (num < min) {
                   min = num;
               }
           }
           return min;
        }
    /**
     * @description calculates the median
     * @return median
     */
    public double calculateMedian(){
        sortData();
        double median = 0;
        if (sortedArr.length % 2 == 1){
            median = sortedArr[sortedArr.length / 2];
        }
        else{
            median =  (sortedArr[(sortedArr.length - 1) / 2] + sortedArr[sortedArr.length / 2]) / 2.0;
        }
        return median;
    }
    /**
     * @description calculates first quartile of the sorted array using formula
     * @return firstQuartile
     */
    public double calculateFirstQuartile() {
        sortData();
        double firstQuartile = sortedArr[(int) (sortedArr.length * 0.25)];
        return firstQuartile;
    }
    /**
     * @description calculate third quartile of the sorted array using formula
     * @return thirdQuartile
     */
    public double calculateThirdQuartile() {
        sortData();
        double thirdQuartile = sortedArr[(int) (sortedArr.length * 0.75)];
        return thirdQuartile;
    }

    /**
     * @description calculates the sum of the sorted array
     * @return sum
     */
        public double calculateSum(){
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }
            return sum;
        }
    /**
     * @description calculates the mean of the sorted array
     * @return mean
     */
        public double calculateMean() {
            double total = 0;
            for(int i = 0; i < arr.length; i++){
                total = total + arr[i];
            }
            double average = total / arr.length;
            return average;
        }
    /**
     * @description prints list of unsorted numbers
     */
        public void print() {
            for (double value : arr) {
                System.out.print(value);
                System.out.print(" ");
            }
        }
    /**
     * @description prints list of sorted numbers
     */
        public void printSorted(){
            sortData();
                for (double value : sortedArr)
                {
                    System.out.print(value);
                    System.out.print(" ");
            }
        }
    /**
     * @description prints five number summary
     */
        public void printFiveNumberSummary() {
            System.out.println("\t Minimum: " + calculateMin());
            System.out.println("\t First quartile: " + calculateFirstQuartile());
            System.out.println("\t Median: " + calculateMedian());
            System.out.println("\t Third quartile: " + calculateThirdQuartile());
            System.out.println("\t Maximum: " + calculateMax());

        }
        }
