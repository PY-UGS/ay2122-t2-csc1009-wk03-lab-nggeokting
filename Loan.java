import java.util.Scanner;
import java.lang.Math;
import java.util.Date;

public class Loan {
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private java.util.Date loanDate;

    public Loan(){
        annualInterestRate = 2.5;
        numberOfYears = 1;
        loanAmount = 1000;
    }

    public Loan(double annualInterestRate, int numberOfYears, double loanAmount){
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public java.util.Date getLoanDate() {
        java.util.Date loanDate = new java.util.Date();
        return loanDate;
    }

    public double getMonthlyPayment(){
        double monthlyInterestRate = (annualInterestRate / 100) / 12;
        double monthlyPayment;
        monthlyPayment = (loanAmount * monthlyInterestRate) / (1 - (1 / (Math.pow((1+ monthlyInterestRate), (numberOfYears * 12)))));
        return monthlyPayment;
    }

    public double getTotalPayment(){
        double totalPayment;
        double monthlyPayment = getMonthlyPayment();
        totalPayment = monthlyPayment * numberOfYears * 12;
        return totalPayment;
    }

    public static void main(String[] args){
        //create new loan object
        Loan loan = new Loan();
        //set annual interest rate
        System.out.print("Enter annual interest rate, for example, 8.25: ");
        Scanner input = new Scanner(System.in);
        loan.setAnnualInterestRate(input.nextDouble());

        //set number of years
        System.out.print("Enter number of years as an integer: ");
        loan.setNumberOfYears(input.nextInt());

        //set loan amount
        System.out.print("Enter loan amount, for example, 120000.95: ");
        loan.setLoanAmount(input.nextDouble());

        //get loan date
        System.out.print("The loan was created on " + loan.getLoanDate() + "\n");

        //get monthly payment
        System.out.print("The monthly payment is " + Math.round(loan.getMonthlyPayment() * 100.0) / 100.0 + "\n");
        
        //get total payment
        System.out.print("The total payment is " + Math.round(loan.getTotalPayment() * 100.0) / 100.0 + "\n");
        
        input.close();
    }
    
}
