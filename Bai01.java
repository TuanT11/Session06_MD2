import java.util.Arrays;
import java.util.Scanner;

public class Bai01{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double[] scores = new double[1000];
        int i = 0;
        while(true){
            System.out.println("*********ĐIỂM**********");
            System.out.println("1. Nhap diem. ");
            System.out.println("2. In danh sach diem. ");
            System.out.println("3. Tinh diem trung binh cua cac sinh vien. ");
            System.out.println("4. Tim diem cao nhat va thap nhat. ");
            System.out.println("5. Diem so luong sinh vien dat va truot. ");
            System.out.println("6. Sap xep diem tang dan. ");
            System.out.println("7. Thong ke so luong sinh vien gioi va xuat sac. ");
            System.out.println("8. Thoat. ");
            System.out.println("*******************************");
            String option = sc.nextLine();
            switch(option){
                case "1":
                    System.out.print("Nhập điểm: ");
                    double diem = Double.parseDouble(sc.nextLine());
                    if(diem < 5) System.out.println("Xếp hạng yếu. ");
                    else if(diem < 7) System.out.println("Xếp hạng trung bình. ");
                    else if(diem < 8) System.out.println("Xếp hạng khá. ");
                    else if(diem < 10) System.out.println("Xếp hạng giỏi. ");
                    else System.out.println("Xếp hạng xuất sắc. ");
                    scores[i++] = diem;
                    break;
                case "2":
                    System.out.println("Danh sách điểm: ");
                    for(int j = 0; j<i ;j++){
                        System.out.printf("Sinh viên thứ %d: ", j+1);
                        System.out.println(scores[j]);
                    }
                    break;
                case "3":
                    double sum = 0d;
                    for(int j = 0; j<i; j++){
                        sum += scores[j];
                    }
                    System.out.printf("Điểm trung bình của các sinh viên là: %.1f\n", sum/i);
                    break;
                case "4":
                    double maxn = Double.MIN_VALUE;
                    double minn = Double.MAX_VALUE;
                    for(int j = 0; j<i; j++){
                        maxn = Math.max(maxn, scores[j]);
                        minn = Math.min(minn, scores[j]);
                    }
                    System.out.printf("Điểm cao nhất: %.1f\n", maxn);
                    System.out.printf("Điểm thấp nhất: %.1f\n", minn);
                    break;
                case "5":
                    int cntDat = 0, cntTruot = 0;
                    for(int j = 0; j<i; j++){
                        if(scores[j] > 4) cntDat++;
                        else cntTruot++;
                    }
                    System.out.printf("Số lượng sinh viên đạt: %d\n", cntDat);
                    System.out.printf("Số lượng sinh viên trượt: %d\n", cntTruot);
                    break;
                case "6":
                    System.out.println("Sắp xếp điểm sinh viên tăng dần. ");
                    Arrays.sort(scores, 0, i);
                    break;
                case "7":
                    int cntGioi = 0, cntXuatSac = 0;
                    for(int j = 0; j<i; j++){
                        if(scores[j] < 10){
                            if(scores[j] > 7) cntGioi++;
                        }
                        else cntXuatSac++;
                    }
                    System.out.printf("Số lượng sinh viên giỏi: %d\n", cntGioi);
                    System.out.printf("Số lượng sinh viên xuất sắc: %d\n", cntXuatSac);
                    break;
                case "8":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nhập đúng định dạng. ");
            }
        }
    }
}
