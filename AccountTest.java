/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;

/**
 *
 * @author ADMIN
 */


import java.util.Scanner;

public class AccountTest {
    public static void main(String[] args) {
        AccountList list = new AccountList(); // Khởi tạo đối tượng AccountList
        
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        
        while (choice != 6) {
            System.out.println("------- MENU -------");
            System.out.println("1. Thêm tài khoản");
            System.out.println("2. Số tài khoản hiện có");
            System.out.println("3. In thông tin tất cả tài khoản");
            System.out.println("4. Nạp tiền vào tài khoản");
            System.out.println("5. Rút tiền");
            System.out.println("6. Chuyển tiền");
            System.out.println("7. Kết thúc");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    addAccount(list);
                    break;
                case 2:
                    getAccountCount(list);
                    break;
                case 3:
                    printAllAccounts(list);
                    break;
                case 4:
                    depositMoney(list);
                    break;
                case 5:
                    withdrawMoney(list);
                    break;
                case 6:
                    transferMoney(list);
                    break;
                case 7:
                    System.out.println("Kết thúc chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
                    break;
            }
            
            System.out.println();
        }
        
        scanner.close();
    }
    
    // Hàm thêm tài khoản
    private static void addAccount(AccountList list) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nhập số tài khoản: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine(); // Đọc dòng mới
        
        System.out.print("Nhập tên tài khoản: ");
        String accountName = scanner.nextLine();
        
        Account account = new Account(accountNumber, accountName);
        list.addAccount(account);
        
        System.out.println();
    }
    
    // Hàm lấy số lượng tài khoản hiện có
    private static void getAccountCount(AccountList list) {
        int count = list.getAccountCount();
        System.out.println("Số tài khoản hiện có: " + count);
        System.out.println();
    }
    
    // Hàm in thông tin tất cả các tài khoản
    private static void printAllAccounts(AccountList list) {
        list.printAllAccounts();
        System.out.println();
    }
    

    
    // Hàm rút tiền từ tài khoản
    private static void withdrawMoney(AccountList list) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nhập số tài khoản: ");
        int accountNumber = scanner.nextInt();
        
        Account account = list.findAccount(accountNumber);
        if (account != null) {
            System.out.print("Nhập số tiền cần rút: ");
            double amount = scanner.nextDouble();
            
            account.rutTien(amount);
        } else {
            System.out.println("Không tìm thấy tài khoản với số tài khoản đã nhập");
        }
    }
    
    // Hàm chuyển tiền từ một tài khoản đến tài khoản khác
    private static void transferMoney(AccountList list) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nhập số tài khoản nguồn: ");
        int sourceAccountNumber = scanner.nextInt();
        
        Account sourceAccount = list.findAccount(sourceAccountNumber);
        if (sourceAccount != null) {
            System.out.print("Nhập số tài khoản đích: ");
            int destinationAccountNumber = scanner.nextInt();
            
            Account destinationAccount = list.findAccount(destinationAccountNumber);
            if (destinationAccount != null) {
                System.out.print("Nhập số tiền cần chuyển: ");
                double amount = scanner.nextDouble();
                
                sourceAccount.chuyenKhoan(destinationAccount, amount);
            } else {
                System.out.println("Không tìm thấy tài khoản đích với số tài khoản đã nhập");
            }
        } else {
            System.out.println("Không tìm thấy tài khoản nguồn với số tài khoản đã nhập");
        }
    }
//     Hàm nạp tiền vào tài khoản
    private static void depositMoney(AccountList list) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nhập số tài khoản: ");
        int accountNumber = scanner.nextInt();
        
        Account account = list.findAccount(accountNumber);
        if (account != null) {
            System.out.print("Nhập số tiền cần nạp: ");
            double amount = scanner.nextDouble();
            
            account.napTien(amount);
        } else {
            System.out.println("Không tìm thấy tài khoản với số tài khoản đã nhập");
        }
    }
   
}

