package app;

import java.util.Scanner;

public class Main {
    static double balance = getBalance();

    public static void main(String[] args) {
        double purchaseAmount = getAmount();
        validateAmount(balance, purchaseAmount);
    }

    private static double getBalance() {
        return 1000.00; // ������ ����� �� �������
    }

    private static double getAmount() {
        System.out.printf("Balance is USD %.2f.%nEnter purchase amount, USD: ", balance);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

    // ����� �������� ������� �����
    private static void validateAmount(double balance, double withdrawal) {
        if (withdrawal > balance) {
            try {
                throw new FundsException("Insufficient funds!");
            } catch (FundsException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            balance = getBalanceAfterPurchase(balance, withdrawal);
            System.out.printf("Funds are OK. Purchase paid.%nBalance is USD %.2f", balance);
        }
    }

    // ����� ���������� ������� ����� �� ������� ���� ������ ����� ���� �����
    private static double getBalanceAfterPurchase(double balance, double withdrawal) {
        return balance - withdrawal;
    }
}
