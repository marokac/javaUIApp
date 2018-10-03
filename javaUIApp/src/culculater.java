
public class culculater {
    
    //constructor
    culculater(){}
    
    //Perfom culculations
    public Double calculateBondRate(Double faceV, Double CRate, Double period, Double IRate) {

        Double monthlyInRate = IRate / 100 / 12;
        Double termsInMonths = period * 12;
        Double payments = (faceV * monthlyInRate) / 1 - Math.pow(1 + monthlyInRate, -termsInMonths);
        // round to two decimals
        payments = (double) Math.round(payments * 100) / 100;
        return payments;
    }
}
