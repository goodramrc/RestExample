package report.utils;

import java.util.HashMap;
import java.util.Map;

import javax.management.RuntimeErrorException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.*;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class ExtentReportListener extends ExtentManager implements ITestListener{

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        if(result.getStatus()==ITestResult.SUCCESS) {
            test.log(Status.PASS, "Pass test case :" + result.getName());
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        if(result.getStatus()==ITestResult.FAILURE) {
            test.log(Status.FAIL,
                    MarkupHelper.createLabel(result.getName() + "Test case Failed", ExtentColor.RED));
            test.log(Status.FAIL,
                    MarkupHelper.createLabel(result.getThrowable() + "Test case Failed", ExtentColor.RED));
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        if(result.getStatus()==ITestResult.SKIP) {
            test.log(Status.PASS, "Skipped test case :" + result.getName());
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        test.log(Status.INFO, "Test case failed but with sucess percentage " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {

        try {
            Map<String, Object> testResult = new HashMap<>();
            testResult.put("TotalTestCaseCount", context.getAllTestMethods().length);
            testResult.put("PassedTestCaseCount", context.getPassedTests().size());
            testResult.put("FailedTestCaseCount", context.getFailedTests().size());
            testResult.put("SkippedTestCaseCount", context.getSkippedTests().size());

            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            String filePath  = "test-output/ExtentReport/TestExecutionReport.json";
            mapper.writeValue(new File(filePath), testResult);

        }catch(Exception e) {
            throw new RuntimeException("Error ocured while writing the report", e);
        }

    }



}