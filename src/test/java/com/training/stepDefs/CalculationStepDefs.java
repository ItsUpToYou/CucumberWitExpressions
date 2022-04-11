package com.training.stepDefs;

import com.training.helper.CalculatorHelper;
import com.training.helper.Operation;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.ParameterType;
import io.cucumber.java.Transpose;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class CalculationStepDefs {


    CalculatorHelper calc = new CalculatorHelper();
    int resultInt;
    double resultDouble;
    boolean flag;
    List<List<String>> tableCells;
    ArrayList<Integer> arr = new ArrayList<>();

    /**
     * Calculation with integers
     */
    @Given("I have integers")
    public void iHaveIntegers() {
    }

    @When("I add numbers {int} and {int}")
    public void iSumNumbersAnd(int a, int b) {
        resultInt = calc.sum(a, b);
    }

    @Then("The results is {int}")
    public void theIntResultIs(int a) {
        Assert.assertEquals(a, resultInt);
    }


    /**
     * Calculation with doubles
     */
    @Given("I have doubles")
    public void iHaveDoubles() {
    }

    @When("I add double {double} and {double}")
    public void iSumdouble(double a, double b) {
        resultDouble = calc.sum(a, b);
    }

    @Then("The result is {double}")
    public void theIntResultIs(double a) {
        Assert.assertEquals(a, resultDouble, 0.0);
    }


    /**
     * Data table of positive and negative numbers
     *
     */

    @ParameterType("sum|difference")
    public Operation operation(String operName) {

        return new Operation(operName);
    }


    @Given("I have table with numbers")
    public void I_have_table_with_numbers(@Transpose DataTable dataTable) {

        tableCells = dataTable.cells();
    }

    @When("Operation is {operation}")
    public void operationIsSumDifference(Operation action) {
        flag = action.getName().equals("sum");

        //sum
        if (flag) {
            for (List<String> dt : tableCells) {
                int sumInt = 0;
                for (String cell : dt) {
                    sumInt += Integer.parseInt(cell);
                }
                arr.add(sumInt);
            }
        } else {
            //difference
            for (List<String> dt : tableCells) {
                int sumInt = 0;
                for (String cell : dt) {
                    int cellNum = Integer.parseInt(cell);
                    if (sumInt == 0) {
                        sumInt = cellNum;
                    } else {
                        sumInt -= cellNum;
                    }
                }
                arr.add(sumInt);
            }
        }
    }


    @Then("Print result(s)")
    public void printResult() {
        for (int i = 0; i < arr.size(); i++) {
            if (i == 0) {
                System.out.println(flag ? "Positive's sum = " + arr.get(i) : "Positive's difference = " + arr.get(i));
            } else {
                System.out.println(flag ? "Negative's sum = " + arr.get(i) : "Negative's difference = " + arr.get(i));
            }
        }
    }
}
