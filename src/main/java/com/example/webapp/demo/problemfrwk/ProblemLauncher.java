package com.example.webapp.demo.problemfrwk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;


public class ProblemLauncher {

    private ProblemSolution solution;
    private String testFilePath;


    public ProblemLauncher(ProblemSolution solution, String testFilePath) {
        this.solution = solution;
        this.testFilePath = testFilePath;
    }


    public void  runAllExamples(){

        // for each file


        BufferedReader  reader = null; //  =

        StringWriter sw = new StringWriter();

        PrintWriter printWriter = new PrintWriter(sw);

        try {
            solution.execute(reader, printWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }


        sw.getBuffer().toString();  // output




        // end for

    }


}

