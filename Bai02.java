import java.util.Scanner;
import java.util.regex.Pattern;

class NguoiDung{
    private String hoVaTen;
    private String email;
    private String phone;
    private String passWord;

    public void setHoVaTen(String name){this.hoVaTen = name;}
    public void setEmail(String email){ this.email = email; }
    public void setPhone(String phone){ this.phone = phone; }
    public void setPassWord(String pass){ this.passWord = pass; }

    public String getHoVaTen(){return this.hoVaTen; }
    public String getEmail(){return this.email;}
    public String getPhone(){return this.phone;}
    public String getPassWord(){return this.passWord;}

}
public class Bai02{
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        NguoiDung currentUser = new NguoiDung();
        while(true){
            System.out.println("**********QUẢN LÝ NGƯỜI DÙNG************");
            System.out.println("1. Nhập thông tin người dùng. ");
            System.out.println("2. Chuẩn hóa họ và tên. ");
            System.out.println("3. Kiểm tra email hợp lệ. ");
            System.out.println("4. Kiểm tra số điện thoại hợp lệ. ");
            System.out.println("5. Kiểm tra mật khẩu hợp lệ. ");
            System.out.println("6. Xem thông tin. ");
            System.out.println("7. Thoát. ");
            System.out.println("*****************************************");
            System.out.print("Lựa chọn của bạn: ");
            String option = sc.nextLine();
            switch(option){
                case "1":
                    System.out.print("Nhập họ và tên: ");
                    String name = sc.nextLine();
                    System.out.print("Nhập email: ");
                    String email = sc.nextLine();
                    System.out.print("Nhập số điện thoại: ");
                    String phone = sc.nextLine();
                    System.out.print("Nhập mật khẩu: ");
                    String password = sc.nextLine();
                    currentUser.setHoVaTen(name);
                    currentUser.setEmail(email);
                    currentUser.setPhone(phone);
                    currentUser.setPassWord(password);
                    break;
                case "2":
                    System.out.println("Tên hiện tại: " + currentUser.getHoVaTen());
                    String temp = currentUser.getHoVaTen();
                    StringBuilder sb = new StringBuilder();
                    temp = temp.replaceAll("\\s+", " ");
                    String[] list = temp.split(" ");
                    for(var x : list){
                        sb.append(Character.toUpperCase(x.charAt(0)));
                        sb.append(x.substring(1).toLowerCase());
                        sb.append(" ");
                    }
                    currentUser.setHoVaTen(sb.toString().trim());
                    System.out.println("Tên đã chuẩn hóa. ");
                    break;
                case "3":
                    System.out.println("Email hiện tại: " + currentUser.getEmail());
                    Pattern p = Pattern.compile("^[a-zA-Z0-9._]+@[a-zA-Z0-9]+\\.[a-zA-z0-9]{3,5}$");
                    if(p.matcher(currentUser.getEmail()).matches()){
                        System.out.println("Email hợp lệ. ");
                    }
                    else{
                        System.out.println("Email không hợp lệ. ");
                        String state;
                        while(true){
                            System.out.println("Nhập lại email hợp lệ [y/n].");
                            state = sc.nextLine();
                            if(state.equals("y") || state.equals("n")) break;
                        }
                        if(state.equals("y")){
                            while(true){
                                System.out.print("Nhập email mới: ");
                                String email_new = sc.nextLine();
                                if(p.matcher(email_new).matches()){
                                    currentUser.setEmail(email_new);
                                    System.out.println("Email hợp lệ. ");
                                    break;
                                }
                                System.out.println("email không hợp lệ. ");
                            }
                        }
                    }
                    break;
                case "4":
                    System.out.println("Số điện thoại hiện tại: " + currentUser.getPhone());
                    Pattern pa = Pattern.compile("^(\\+84|0)\\d{10}$");
                    if(pa.matcher(currentUser.getPhone()).matches()){
                        System.out.println("So dien thoai hợp lệ. ");
                    }
                    else{
                        System.out.println("Số điện thoại không hợp lệ. ");
                        String sta;
                        while(true){
                            System.out.println("Nhập lại so dien thoai hợp lệ [y/n].");
                            sta = sc.nextLine();
                            if(sta.equals("y") || sta.equals("n")) break;
                        }
                        if(sta.equals("y")){
                            while(true){
                                System.out.print("Nhập so dien thoai mới: ");
                                String phone_new = sc.nextLine();
                                if(pa.matcher(phone_new).matches()){
                                    currentUser.setPhone(phone_new);
                                    System.out.println("SDT hợp lệ. ");
                                    break;
                                }
                                System.out.println("SDT không hợp lệ. ");
                            }
                        }
                    }
                    break;
                case "5":
                    System.out.println("Mật khẩu hiện tại: " + currentUser.getPassWord());
                    Pattern part = Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@#$%&+=]).{8,}$");
                    if(part.matcher(currentUser.getPassWord()).matches()){
                        System.out.println("Mat khau hop le hợp lệ. ");
                    }
                    else{
                        System.out.println("Mật khẩu không hợp lệ. ");
                        String sta;
                        while(true){
                            System.out.println("Nhập lại so mat khau hợp lệ [y/n].");
                            sta = sc.nextLine();
                            if(sta.equals("y") || sta.equals("n")) break;
                        }
                        if(sta.equals("y")){
                            while(true){
                                System.out.print("Nhập mat khau mới: ");
                                String password_new = sc.nextLine();
                                if(part.matcher(password_new).matches()){
                                    currentUser.setPassWord(password_new);
                                    System.out.println("mat khau hợp lệ. ");
                                    break;
                                }
                                System.out.println("Mat khau không hợp lệ. ");
                            }
                        }
                    }
                    break;
                case "6":
                    System.out.println("Họ và tên: " + currentUser.getHoVaTen());
                    System.out.println("Email: " + currentUser.getEmail());
                    System.out.println("SDT: " + currentUser.getPhone());
                    System.out.println("Mật khẩu: " + currentUser.getPassWord());
                    break;
                case "7":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nhập đúng định dạng mới được thực thi. ");
            }
        }
    }
}