package com.cucumber.testng.examples;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by amit.rawat on 21/12/15.
 */
public class GenerateReport {
    public static void GenerateMasterthoughtReport() {
        try {
            String RootDir = System.getProperty("user.dir");
            File reportOutputDirectory = new File("target/Masterthought");

            List<String> list = new ArrayList<String>();
            File targetDir = new File("target");
            File[] listOfFiles = targetDir.listFiles();

            for (int i = 0; i < listOfFiles.length; i++) {

                if (listOfFiles[i].isFile() && listOfFiles[i].getName().endsWith("json")) {
                    list.add("target/" + listOfFiles[i].getName());
                }
            }

            String pluginUrlPath = "";
            String buildNumber = "1";
            String buildProject = "cucumber-jvm";
            boolean skippedFails = true;
            boolean pendingFails = true;
            boolean undefinedFails = true;
            boolean missingFails = true;
            boolean flashCharts = true;
            boolean runWithJenkins = false;
            boolean highCharts = false;
            boolean parallelTesting = true;
            boolean artifactsEnabled = false;
            String artifactConfig = "";
            Configuration reportConfig = new Configuration(reportOutputDirectory, buildProject);
            reportConfig.setStatusFlags(skippedFails, pendingFails, undefinedFails, missingFails);
            reportConfig.setParallelTesting(true);
            reportConfig.setRunWithJenkins(true);
            reportConfig.setBuildNumber(buildNumber);

//            ReportBuilder reportBuilder = new ReportBuilder(list, reportOutputDirectory, pluginUrlPath, buildNumber,
//                    buildProject, skippedFails, pendingFails, undefinedFails, missingFails, flashCharts, runWithJenkins,
//                    highCharts, parallelTesting);

            ReportBuilder reportBuilder = new ReportBuilder(list, reportConfig);

            reportBuilder.generateReports();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
