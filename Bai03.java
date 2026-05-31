import java.util.Scanner;

public class Bai03{
    public static int linearSearch(String[] arr, String target, int len){
        for(int i = 0; i < len; i++){
            if(arr[i].equals(target)) return i;
        }
        return -1;
    }

    public static int binarySearch(String[] arr, String target, int len){
        int i = 0, j = len-1;
        while(i <= j){
            int mid = j + (j-i)/2;
            if(arr[mid].equals(target)) return mid;
            else if(arr[mid].compareTo(target) > 0) j = mid - 1;
            else if(arr[mid].compareTo(target) < 0 ) i = mid + 1;
        }
        return -1;
    }

    public static void bubbleSort(String[] arr, int len){
        for(int i = 0; i < len; i++){
            boolean ok = true;
            for(int j = 1; j <= len - i - 1; j++){
                if(arr[j].compareTo(arr[j-1]) < 0){
                    String tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                    ok = false;
                }
            }
            if(ok) break;
        }
    }
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        String[] list = new String[10000];
        boolean checkSearch = true;
        int i = 0;
        while(true){
            System.out.println("*************Quản lý biển số xe***********");
            System.out.println("1. Thêm các biển số xe. ");
            System.out.println("2. Hiển thị danh sách biển số xe. ");
            System.out.println("3. Tìm kiếm biển số xe. ");
            System.out.println("4. Tiềm kiến biển số xe theo mã tỉnh. ");
            System.out.println("5. Sắp xếp biển số xe. ");
            System.out.println("6. Thoát. ");
            System.out.println("*******************************************");
            System.out.print("Lựa chọn của bạn: ");
            String option = sc.nextLine();
            switch(option){
                case "1":
                    do{
                        System.out.print("Thêm biển số xe: ");
                        String bs = sc.nextLine();
                        if(!bs.matches("\\d{2}[A-Z]-\\d{3}\\.\\d{2}")){
                            System.out.println("Biển số xe không hợp lệ. ");
                        }
                        else{
                            list[i++] = bs;
                            System.out.println("Biển số xe hợp lệ. ");
                        }
                        System.out.print("ấn bất kì để tiếp tục thêm biển số xe, n để kết thúc: ");
                        String sta = sc.nextLine();
                        if(sta.equals("n")) break;
                    } while(true);
                    break;
                case "2":
                    System.out.println("Danh sách biển số xe: ");
                    for(int j=0; j<i; j++){
                        System.out.println(list[j]);
                    }
                    break;
                case "3":
                    System.out.print("Biên số xe tìm kiếm: ");
                    String bs = sc.nextLine();
                    if(checkSearch){
                        System.out.println(linearSearch(list, bs, i) != -1 ? list[linearSearch(list, bs, i)] : "Không tồn tại");
                    }
                    else{
                        System.out.println(binarySearch(list, bs, i) != -1 ? list[binarySearch(list, bs, i)] : "Không tồn tại");
                    }
                    break;
                case "4":
                    System.out.print("Nhập mã tỉnh: ");
                    String ma = sc.nextLine();
                    System.out.print("Nhập mã vùng hoặc enter để trống: ");
                    String mv = sc.nextLine();
                    ma += mv;
                    boolean chk = true;
                    for(int j =0; j<i; j++){
                        if(list[j].matches("^" + ma + ".+$")){
                            System.out.println(list[j]);
                            chk = false;
                        }
                    }
                    if(chk) System.out.println("Không có biển số xe. ");
                    break;
                case "5":
                    System.out.println("Đã xắp sếp mảng. ");
                    bubbleSort(list, i);
                    checkSearch = false;
                    break;
                case "6":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nhập đúng định dạng. ");
            }
        }
    }
}
