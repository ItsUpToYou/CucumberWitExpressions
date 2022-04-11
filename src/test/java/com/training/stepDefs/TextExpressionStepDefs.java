package com.training.stepDefs;

import com.training.helper.Operation;
import com.training.helper.StringHelper;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TextExpressionStepDefs extends StringHelper {

    boolean caseSensitiveFlag = false;
    String testWord;
    String fSentances;
    String sSentences;
    String docString;

    @ParameterType("case-sensitive|case-insensitive")
    public Operation compareMethod(String methodName) {

        return new Operation(methodName);
    }

    //Background step
    @Given("Comparing method is {compareMethod}")
    public void comparingMethodIsCaseSensitive(Operation compareMethod) {
        if (compareMethod.getName().equals("case-sensitive"))
            caseSensitiveFlag = true;
    }

    /**
     * Compare single words
     */
    @Given("Examples of {word}")
    public void examplesOfWords(String str) {
        testWord = str;
    }


    @When("Compare with {word}")
    public void compareWith(String givenWord) {
        if (caseSensitiveFlag) {
            assertEquals("Compared Words are not the same: ", testWord, givenWord);
            System.out.println(compareCaseSensitive(testWord, givenWord) ? "Successful case-sensitive: " + testWord + " <-> " + givenWord : "Failed : " + testWord + " <-> " + givenWord);
        } else {
            assertTrue("Compared Words are not the same: " + testWord + " <-> " + givenWord, compareCaseInsensitive(testWord, givenWord));
            System.out.println(compareCaseInsensitive(testWord, givenWord) ? "Successful case-insensitive : " + testWord + " <-> " + givenWord : "Failed : " + testWord + " <-> " + givenWord);
        }
    }

    /**
     * Compare and remove charecters from words
     *  With RegEx "^Remove character (\\w)$"
     */
    @But("Remove character with {}")
    public void removeCharFromWord(String ch) {
        System.out.println("removed ch "+ch);
        String str = testWord.replace(ch, "");
        testWord = str;
        System.out.println(testWord);
    }




    /**
     * Comparing sentences
     * Remove first occurrence with char
     * accept only . ? ! : ( ) [ ]
     */
    @Given("The First/1st sentence is set to {string}")
    public void setFirstSentence(String str) {
        this.fSentances = str;
    }

    @And("^Remove character: ([.?!:()\\[\\]])$")
    public void removeChar(String ch) {
        String str = fSentances.replaceFirst(ch, "");
        fSentances = str;
    }
    @When("Second sentence is {}")
    public void setSecondSentence(String secondSentences) {
        this.sSentences = secondSentences;
    }

    @Then("Compare")
    public void compare() {
        if (caseSensitiveFlag) {
            assertTrue("The sentences are not equal. Expected is :\"" + fSentances + "\"" + ",\n but the actual is: \"" + sSentences + "\"", fSentances.equals(sSentences));
            System.out.println(compareCaseSensitive(fSentances, sSentences) ? "Compared case-sensitive: " + fSentances + " <-> " + sSentences : "Failed : " + fSentances + " <-> " + sSentences);
        } else {
            assertTrue("The sentences are not equal. Expected is :\"" + fSentances + "\"" + ",\n but the actual is: \"" + sSentences + "\"", fSentances.equalsIgnoreCase(sSentences));
            System.out.println(compareCaseInsensitive(fSentances, sSentences) ? "Compared case-insensitive : " + fSentances + " <-> " + sSentences : "Failed : " + fSentances + " <-> " + sSentences);
        }
    }


    /**
     * Remove all occurences of char
     * accept only “ , ; - '
     */

    @Given("First/1st sentence is {}")
    public void fstSentenceIsAndMore(  String str) {
        this.fSentances = str;
        System.out.println(str);
    }

    @And("^Remove occurrences with ([\"\\,\\;\\-\\'])$")
    public void removeAllOccurrencesWith(String ch) {
        String str = fSentances.replace(ch, "");
        fSentances = str;
        System.out.println(fSentances);
    }

    @When("The Second/2nd sentence is set to {}")
    public void secondSentenceIs(String secondSentences) {
        this.sSentences = secondSentences;
    }

    /**
     * word counting
     */
    @Given("Paragraf of text:")
    public void paragrafOfText(String msg) {
        this.docString = msg;
    }

    @Then("Word counting")
    public void countWordsUsingSplit() {
        if (docString == null || docString.isEmpty()) {
            System.out.println("String is empty");
        }

        String[] words = docString.split("\\s+");
        System.out.println(words.length);
    }



}
