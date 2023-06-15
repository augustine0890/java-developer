package com.financial;
import java.time.LocalDate;
import java.time.YearMonth;

public class SavingCalculator {
    private float[] credits;
    private float[] debits;

    public static void main(String[] args) {
        // The credits may look like "10.0,20.0" and similarly, debits could look like "5.0"
        final String[] creditsAsString = args[0].split(",");
        final String[] debitsAsString = args[1].split(",");

        final float[] credits = new float[creditsAsString.length];
        final float[] debits = new float[debitsAsString.length];

        for (int i = 0; i < creditsAsString.length; i++) {
            credits[i] = Float.parseFloat(creditsAsString[i]);
        }

        for (int i = 0; i < debitsAsString.length; i++) {
            debits[i] = Float.parseFloat(debitsAsString[i]);
        }

        SavingCalculator calculator = new SavingCalculator(credits, debits);
        float netSavings = calculator.calculate();
        System.out.println("Net Savings = " + netSavings + ", remaining days in month = " + remainingDaysInMonth(LocalDate.now()));
    }

    public SavingCalculator(float[] credits, float[] debits) {
        this.credits = credits;
        this.debits = debits;
    }

    private float sumOfCredits() {
        float sum = 0.0f;
        for (int i = 0; i < this.credits.length; i++) {
            sum += this.credits[i];
        }
        return sum;
    }

    private float sumOfDebits() {
        float sum = 0.0f;
        for (int i = 0; i < this.debits.length; i++) {
            sum += this.debits[i];
        }
        return sum;
    }

    private static int remainingDaysInMonth(LocalDate date) {
        YearMonth yearMonth = YearMonth.of(date.getYear(), date.getMonth());
        int totalDaysInMonth = yearMonth.lengthOfMonth();
        int remainingDays = totalDaysInMonth - date.getDayOfMonth();
        return remainingDays;
    }

    public float calculate() {
        return sumOfCredits() - sumOfDebits();
    }
}
