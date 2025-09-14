package ua.opnu;

public class BankAccount {
    String name;
    double balance;
    double transactionFee;

    public void setTransactionFee(double fee) {
        this.transactionFee = fee;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
        } else {
            System.out.println("Сума для внесення повинна бути більше нуля.");
        }
    }

    double getBalance() {
        return this.balance;
    }

    boolean withdraw(double amount) {
        if (amount > 0) {
            double totalAmount = amount + transactionFee;
            if (balance >= totalAmount) {
                balance = balance - totalAmount;
                return true;
            } else {
                System.out.println("Недостатньо коштів на рахунку для зняття суми з урахуванням комісії.");
            }
        } else {
            System.out.println("Сума для зняття повинна бути більше нуля.");
        }
        return false;
    }

    boolean transfer(BankAccount receiver, double amount) {
        if (amount > 0) {
            double totalAmount = amount + transactionFee;
            if (balance >= totalAmount) {
                balance = balance - totalAmount;
                receiver.balance = receiver.balance + amount;
                return true;
            } else {
                System.out.println("Недостатньо коштів для здійснення переказу з урахуванням комісії.");
            }
        } else {
            System.out.println("Сума для переказу повинна бути більше нуля.");
        }
        return false;
    }
}