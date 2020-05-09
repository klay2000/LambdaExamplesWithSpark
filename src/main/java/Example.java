import spark.Route;
import spark.Spark;

import static spark.Spark.get;
import static spark.route.HttpMethod.put;

public class Example {
     /*
      *lambda expressions are usually created from an interface
      *interfaces only allow abstract methods
      *you cant really have two methods in the interface with lambdas
      *there's a few different ways to make a lambda
      */


    interface nope{
        int u(int i, int j);
//        int v(int x, int y, int z);
//        int sub(int a, int b){return a-b}
    }

    static nope broken = (i, j) -> i+j;

    static Route hwRoute = (req, res) -> "world";

    static Route greetRoute = (req, res) -> {
        return "hello " + req.body();
    };

    public static void main(String[] args) {

        get("/foo", (req, res) -> "bar");

        get("/hello", hwRoute);

        Spark.put("/greet", greetRoute);
    }
}
