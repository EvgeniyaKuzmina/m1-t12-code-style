import java.util.Scanner;

public class DepositCalculator {

    double calculateComplexPercent(double amountInput, double yearRate, int depositPeriod) {
       double depositRate = amountInput * Math.pow((1 + yearRate / 12), 12 * depositPeriod );
       return getAmountWithPercent(depositRate, 2);
    }

    double calculateSimplePercent(double amountInput, double yearRate, int depositPeriod) {
         return getAmountWithPercent(amountInput + amountInput * yearRate * depositPeriod, 2);
    }

    double getAmountWithPercent(double value, int places) {
       double scaLe = Math.pow(10, places);
       return Math.round(value * scaLe) / scaLe;
    }

    void getProfit( ) {
      int period;
      int action;
      Scanner scanner = new Scanner(System.in);

      System.out.println("Введите сумму вклада в рублях:");
      int amount = scanner.nextInt();

      System.out.println("Введите срок вклада в годах:");
      period = scanner.nextInt( );
      System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
      action = scanner.nextInt();
      double totalAmount = 0;

      if (action == 1) {
          totalAmount = calculateSimplePercent(amount, 0.06, period);
      } else if (action == 2) {
          totalAmount = calculateComplexPercent(amount, 0.06, period);
      }
      System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + totalAmount);
    }

    public static void main(String[] args) {
        new DepositCalculator().getProfit();
    }

}
