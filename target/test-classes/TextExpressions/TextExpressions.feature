#Author Velko Kapitanov

Feature: Cucumber training with text expressions

  Background:
    * Comparing method is case-sensitive
  @test
  Scenario Outline: Remove charecters from given word and compare
    * Examples of <words>
    * Remove character with z
    * Remove character with s
    * Compare with Example

    Examples:
      | words       |
      | Examplesssz |
      | EXAMPLE     |


  Scenario Outline: Remove first character occurrence from sentences
    * The 1st sentence is set to "My sentence]!?"
    * Remove character: ]
    * Second sentence is <sentences>
    * Compare

    Examples:
      | sentences     |
      | My sentence!? |
      | My sENTence!? |


  Scenario Outline: Remove all occurrence with char
    * 1st sentence is "My sentences "and more...""
    * Remove occurrences with "
    * The Second sentence is set to <sentences>
    * Compare

    Examples:
      | sentences               |
      | My sentences and more...|
      | My sentences AND MORE...|


  Scenario: Word count of text
    Given Paragraf of text:
      """
        Cras tortor urna, vestibulum vel fermentum ut, porttitor non justo.
      Interdum et malesuada fames ac ante ipsum primis in faucibus.
      Fusce quam ipsum, porttitor et turpis in, auctor facilisis erat.

        Cras tortor urna, vestibulum vel fermentum ut, porttitor non justo.
      Interdum et malesuada fames ac ante ipsum primis in faucibus.
      Fusce quam ipsum, porttitor et turpis in, auctor facilisis erat.
      """
    Then Word counting