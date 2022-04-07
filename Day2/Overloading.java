public class Overloading {
    public static void main(String[] args) {

        PowerfulString word = new PowerfulString("HelloWorld");

        System.out.println(word.slice());
        System.out.println(word.slice(3));
        System.out.println(word.slice(4, 6));

        // PS: I love JavaScript :D
    }
}

class PowerfulString {

    String text;

    PowerfulString(String text) {
        this.text = text;
    }

    // Three different signatures for a method :D
    // Java doesn't have default parameter values :(

    String slice() {
        return this.text;
    }

    String slice(int start) {
        return subString(start, this.text.length());
    }

    String slice(int start, int end) {
        return subString(start, end);
    }

    private String subString(int start, int end) {
        String newString = "";

        for (int i = start; i < end; ++i) {
            newString += this.text.charAt(i);
        }

        return newString;
    }

}
