package edu.citytech.financial.utility;
import java.util.Map;

public class EnvironmentVariableUtility {

//    public record Pair(String key, String value){};
public static void main(String args[]){

    //getting username using System.getProperty in Java
    String user = System.getProperty("user.name") ;
    System.out.println("Username using system property: "  + user);

    //getting username as an environment variable in java only works in windows
    String userWindows = System.getenv("USERNAME");
    System.out.println("Username using environment variable in windows : "  + userWindows);


    //name and value of all environment variables in Java  program
    Map<String, String> env = System.getenv();
    for (String envName : env.keySet()) {
        System.out.format("%s=%s%n", envName, env.get(envName));
    }

}

}