/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;

/**
 *
 * @author ADMIN
 */


public class AccountList {
    private Account[] accList;
    private int count;

    public AccountList() {
        this.accList = new Account[10]; // Khởi tạo một mảng tài khoản với kích thước ban đầu là 10
        this.count = 0;
    }
    

    public AccountList(int size) {
        if (size > 0) {
            this.accList = new Account[size]; // Khởi tạo một mảng tài khoản với kích thước được truyền vào
        } else {
            this.accList = new Account[10]; // Khởi tạo một mảng tài khoản với kích thước mặc định là 10
        }
        this.count = 0;
    }
    

    // Thêm một tài khoản vào danh sách
    public void addAccount(Account account) {
        if (count < accList.length) {
            accList[count] = account;
            count++;
            System.out.println("Account added successfully.");
        } else {
            System.out.println("Account list is full. Cannot add more accounts.");
        }
    }

    // Tìm tài khoản theo số tài khoản
    public Account findAccount(long accountNumber) {
        for (int i = 0; i < count; i++) {
            if (accList[i].getAccountNumber() == accountNumber) {
                return accList[i];
            }
        }
        return null; // Trả về null nếu không tìm thấy tài khoản
    }

    // Xóa tài khoản theo số tài khoản
    public void deleteAccount(long accountNumber) {
        for (int i = 0; i < count; i++) {
            if (accList[i].getAccountNumber() == accountNumber) {
                // Dời các phần tử phía sau lên để ghi đè tài khoản cần xóa
                for (int j = i; j < count - 1; j++) {
                    accList[j] = accList[j + 1];
                }
                count--;
                System.out.println("Account deleted successfully.");
                return;
            }
        }
        System.out.println("Account not found.");
    }

    // Đếm số lượng tài khoản trong danh sách
    public int getAccountCount() {
        return count;
    }

    // In thông tin toàn bộ tài khoản có trong danh sách
    public void printAllAccounts() {
        if (count > 0) {
            System.out.println("Account List:");
            for (int i = 0; i < count; i++) {
                System.out.println("Account " + (i + 1) + ":");
                System.out.println(accList[i].toString());
                System.out.println();
            }
        } else {
            System.out.println("No accounts found in the list.");
        }
    }
}
    


