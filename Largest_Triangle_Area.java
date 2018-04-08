//Time O(N^3) Space O(1)
class Solution {
    public double largestTriangleArea(int[][] points) {
        double area = 0.0;
        for(int i = 0; i < points.length-2;i++){
            int[] a = points[i];
            for(int j = i+1; j < points.length;j++){
                int[] b = points[j];
                for(int z = j+1; z< points.length;z++){
                    int[] c= points[z];
                    area = Math.max(area,getArea(a,b,c));
                }
            }
        }
        return area;
    }
    private double getArea(int[] a, int[] b, int[] c){
        return Math.abs(((c[0] - a[0]) * (b[1] - a[1]) - (b[0] - a[0]) * (c[1] - a[1]) ))/2.0;
    }
}
