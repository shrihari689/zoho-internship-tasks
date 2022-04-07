public class Overriding {
    public static void main(String[] args) {

        // Scenario 1: When each language speaks its own motto
        JavaScript javaScript = new JavaScript();
        javaScript.speak();
        System.out.println(javaScript.author);
        System.out.println("---------------");

        C c = new C();
        c.speak();
        System.out.println(c.author);
        System.out.println("---------------");

        // Scenario 2: Upcasting Happens :D
        C language = new Java();
        language.speak();
        System.out.println(language.author);
        System.out.println("---------------");

        // Scenario 3: Downcasting Happens :D
        Java java = (Java) language;
        java.speak();
        System.out.println(java.author);

    }
}

class C {
    String author = "Dennis Ritchie";

    void speak() {
        System.out.println("Haha! #include :D");
    }
}

class Java extends C {
    String author = "James Gosling";

    void speak() {
        System.out.println("I am higher than C and strongly typed!");
    }
}

class JavaScript extends Java {
    String author = "Brendan Eich";

    void speak() {
        System.out.println("Believe me! I am not related to Java anymore! :(");
    }
}
