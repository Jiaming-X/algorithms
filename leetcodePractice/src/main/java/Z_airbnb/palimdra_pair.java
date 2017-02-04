package Z_airbnb;

public class palimdra_pair {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Integer[] result = new Integer[]{3, 1, 2};
        System.out.println(result[0]);
        result[1] = null;
        System.out.println(result[1]);

        Integer[][] list = new Integer[2][1];
        list[0] = result;
        
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].length; j++) {
                System.out.print(list[i][j]);
            }
            System.out.println();
        }
    }

}
