package person.bmiCalculator;

/**
 *
 * @author zared
 */
public class bmiCalculator {

    double weight;
    double height;
    double bmi = (weight / height) / height;

    public double checkBmi(double weight, double height) {
        double bmi = (weight / height) / height;

        return bmi;
    }
}
