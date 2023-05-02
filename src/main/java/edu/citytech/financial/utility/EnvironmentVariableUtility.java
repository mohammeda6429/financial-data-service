package edu.citytech.financial.utility;
import java.util.Map;
import java.util.function.Consumer;

public class EnvironmentVariableUtility {
    public record Pair(String key, String value){};
    public static void getVariables(Consumer<Pair> consumer){
    Map<String, String> env = System.getenv();
    for (String envName : env.keySet()) {
        Pair pair = new Pair(envName, env.get(envName));
        consumer.accept(pair);
    }

}

}