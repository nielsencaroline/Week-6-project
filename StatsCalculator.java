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
        private double[] value;
        /**
        * @description creates double array of sorted numbers
        */
        private double[] sortedValues;

        /**
         * Default constructor that creates an array of 20 zeros
         */
    public StatsCalculator(){
            value = new double[20];
            sortedValues = new double[20];
            Arrays.sort(sortedValues);
        }
        /**
         * Constructor that creates a StatsCalculator object with a user defined array
         *
        * @param value The array input by the user
        */

    public StatsCalculator(double[] value){
             this.value = value;
             sortedValues = value;
        }
        /**
         * Sorts the values in increasing direction
         * Java.util.Arrays.copyOf() method returns a copy of the original array
        * @return sorted numbers
        */

    public void sortData(){
        sortedValues = Arrays.copyOf(value, value.length);
        Arrays.sort(sortedValues);
    }
        /**
        * @description calculates the max in the sorted array
        * @return max
        */
    public double calculateMax(){
            double max = value[0];
            for (double num : value) {
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
           double min = value[0];
           for (double num : value) {
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
        if (sortedValues.length % 2 == 1){
            median = sortedValues[sortedValues.length / 2];
        }
        else{
            median =  (sortedValues[(sortedValues.length - 1) / 2] + sortedValues[sortedValues.length / 2]) / 2.0;
        }
        return median;
    }
    /**
     * @description calculates first quartile of the sorted array using formula
     * @return firstQuartile
     */
    public double calculateFirstQuartile() {
        sortData();
        double firstQuartile = -1;
        if(sortedValues.length % 4 == 0){
            firstQuartile = (sortedValues[(sortedValues.length / 4) - 1] + sortedValues[(sortedValues.length / 4)]) / 2;
        }
        else{
            firstQuartile = sortedValues[sortedValues.length / 4];
        }
        return firstQuartile;
    }
    /**
     * @description calculate third quartile of the sorted array using formula
     * @return thirdQuartile
     */
    public double calculateThirdQuartile() {
        sortData();
        double thirdQuartile = -1;
        if(sortedValues.length % 2 == 0) {
           thirdQuartile = (sortedValues[(sortedValues.length / 4) + (sortedValues.length / 2) - 1] + sortedValues[(sortedValues.length / 4) + (sortedValues.length / 2)]) / 2;
        }
        else if(sortedValues.length % 4 == 0) {
            thirdQuartile = sortedValues[(int) (sortedValues.length * .75)-1];
        }
        else{ // odd length
            thirdQuartile = sortedValues[(sortedValues.length / 4) + (sortedValues.length/2)+1];
        }
        return thirdQuartile;
    }

        /**
        * @description calculates the sum of the sorted array
        * @return sum
        */
        public double calculateSum(){
            int sum = 0;
            for (int i = 0; i < value.length; i++) {
                sum += value[i];
            }
            return sum;
        }
        /**
         * @description calculates the mean of the sorted array
         * @return mean
        */
         public double calculateMean() {
            double total = 0;
            for(int i = 0; i < value.length; i++){
                total = total + value[i];
            }
            double average = total / value.length;
            return average;
        }
        /**
         * @description prints list of unsorted numbers
         */
        public void print() {
            for (double value : value) {
                System.out.print(value);
                System.out.print(" ");
            }
        }
        /**
         * @description prints list of sorted numbers
         */
    public void printSorted(){
        sortData();
        for (double value : sortedValues)
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
