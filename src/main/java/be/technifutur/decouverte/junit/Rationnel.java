package be.technifutur.decouverte.junit;

public class Rationnel {
    private final int numerator;
    private final int denominator;
    private Rationnel simplified;

    public Rationnel(int numerator, int denominator) throws RationnalException {
        if (denominator == 0) {
            throw new RationnalException();
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public Rationnel add(Rationnel rationnel) {
        try {
            return new Rationnel(
                    this.numerator * rationnel.denominator + rationnel.numerator * this.denominator,
                    this.denominator * rationnel.getDenominator()
            );
        } catch (RationnalException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rationnel rationnel = (Rationnel) o;

        if (numerator != rationnel.numerator) return false;
        return denominator == rationnel.denominator;
    }

    @Override
    public int hashCode() {
        int result = numerator;
        result = 31 * result + denominator;
        return result;
    }

    public Rationnel simplify() {
        try {
            if (this.simplified == null) {
                int n1 = numerator;
                int n2 = denominator;
                int r = n1%n2;
                while(r > 0){
                    n1 = n2;
                    n2 = r;
                    r = n1 % n2;
                }
                this.simplified = new Rationnel(numerator/n2, denominator/n2);
            }


            return simplified;
        } catch (RationnalException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Rationnel{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }
}
