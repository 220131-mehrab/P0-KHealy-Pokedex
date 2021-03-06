/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.revature.khealy;

import com.revature.khealy.Dex.CSVPokedex;
import com.revature.khealy.Dex.Dex;
import com.revature.khealy.Services.DexService;
import com.revature.khealy.Services.SearchFormService;
import jakarta.servlet.Servlet;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;


public class App {
    protected static String filename = new String("npd.csv");
    //"C:\\Users\\kevin\\PRPT\\Server\\app\\src\\main\\resources\\npd.csv"
    //C:\Users\kevin\PRPT\Server\

    public static void main(String[] args){
        //String filename = args[0];
        Dex pokedex = new CSVPokedex(filename);
        DexService dexService = new DexService(pokedex);
        SearchFormService sfService = new SearchFormService();

//        NewTest nt = new NewTest();

        Tomcat server = new Tomcat();
        server.getConnector();
        server.addContext("",null);
        server.addServlet("","dexServlet", (Servlet) dexService).addMapping("/pokemon");
        server.addServlet("","SearchFormService", (Servlet) sfService).addMapping("/search");
        try {
            server.start();
        } catch (
                LifecycleException e) {
            e.printStackTrace();
        }

    }
}

