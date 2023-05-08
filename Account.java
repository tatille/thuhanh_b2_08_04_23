package newpackage;

/**
 *
 * author ADMIN
 */
import java.text.NumberFormat;
import java.util.Locale;

public class Account {
    private int sotk;
    private String tentk;
    private double sotien;
    private String trangthai;
    private static final double LAI_SUAT = 0.035;

    public Account() {
        this.sotk = 999999;
        this.tentk = "chưa xác định";
        this.sotien = 50;
    }
    

    public Account(int sotk, String tentk) {
        this.sotk = sotk;
        this.tentk = tentk;
        this.sotien = 50;
    }

    public static double getLAI_SUAT() {
        return LAI_SUAT;
    }

    public int getSotk() {
        return sotk;
    }

    public void setSotk(int sotk) {
        if (sotk > 0 && sotk != 999999) {
            this.sotk = sotk;
        } else {
            this.sotk = 999999;
            this.trangthai = "Số tài khoản không hợp lệ. Số tài khoản đã được gán giá trị mặc định (999999).";
        }
    }

    public String getTentk() {
        return tentk;
    }

    public void setTentk(String tentk) {
        if (!tentk.isEmpty()) {
            this.tentk = tentk;
        } else {
            this.tentk = "chưa xác định";
            this.trangthai = "Tên tài khoản không hợp lệ. Tên tài khoản đã được gán giá trị mặc định (chưa xác định).";
        }
    }

    public double getSotien() {
        return sotien;
    }

    public void setSotien(double sotien) {
        if (sotien >= 50) {
            this.sotien = sotien;
        } else {
            this.sotien = 50;
            this.trangthai = "Số tiền không hợp lệ. Số tiền đã được gán giá trị mặc định (50).";
        }
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public void napTien(double amount) {
        if (amount > 0) {
            sotien += amount;
            System.out.println("Nạp tiền thành công.");
        } else {
            System.out.println("Số tiền nạp không hợp lệ.");
        }
    }

    public void rutTien(double amount) {
        if (amount > 0 && amount <= sotien) {
            sotien -= amount;
            System.out.println("Rút tiền thành công.");
        } else {
            System.out.println("Số tiền rút không hợp lệ hoặc lớn hơn số tiền trong tài khoản.");
        }
    }

    public void chuyenKhoan(Account receiver, double amount) {
        if (amount > 0 && amount <= sotien) {
            sotien -= amount;
            receiver.napTien(amount);
            System.out.println("Chuyển khoản thành công.");
        } else {
            System.out.println("Số tiền chuyển khoản không hợp lệ hoặc lớn hơn số tiền trong tài khoản.");
        }
    }

    public long getAccountNumber() {
        return sotk;
    }
//chuyển tiền 
    public void transfer(Account receiverAccount, double amount) {
        if (amount > 0 && amount <= sotien) {
            sotien -= amount;
            receiverAccount.deposit(amount);
            System.out.println("Chuyển khoản thành công.");
        } else {
            System.out.println("Số tiền chuyển khoản không hợp lệ hoặc lớn hơn số tiền trong tài khoản.");
        }
    }
//rút tiền 
    public void withdraw(double amount) {
        if (amount > 0 && amount <= sotien) {
            sotien -= amount;
            System.out.println("Rút tiền thành công.");
        } else {
            System.out.println("Số tiền rút không hợp lệ hoặc lớn hơn số tiền trong tài khoản.");
        }
    }
//nạp tiền 
    public void deposit(double amount) {
        if (amount > 0) {
            sotien += amount;
            System.out.println("Nạp tiền thành công.");
        } else {
            System.out.println("Số tiền nạp không hợp lệ.");
        }
    }
}
