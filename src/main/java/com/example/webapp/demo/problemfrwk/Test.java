package com.example.webapp.demo.problemfrwk;

public class Test {



    public void testABC(){


        ProblemLauncher pl = new ProblemLauncher(new KnightTask(), "/data/testdata/knight");

        pl.runAllExamples();


    }
}
