Feature: InsightPageValidation
  Verify the search criteria in Octopus insight page
  @Smoke
  Scenario: Launch URL and verify the landing page
    Given Launch the URL
    Then Verify the expected message "Insights" in the landing page
    And Also verify Insight message "Our Insights include topics from across the Octopus Group"

  Scenario: Verify top navigation bar with all menu items are displayed correctly
    When Top navigation bar exist in the page
    And  Click on octopus and verify the page is displayed "Welcome to Octopus" and navigate back to insight page
    Then Verify all menu items "About", "Businesses","Insights","Careers","Contact" are displayed correctly

  Scenario: Verify search functionality at the top right corner of the insight page
    When Click the search button at the top right corner
    Then  Enter the text "Energy" in the search textbox and verify the result
    And  Close the window by clicking on close button

  Scenario:Enter the search text and verify the search results in the insight page
    Given Enter the search text "Energy" and filter by Business type "Octopus Energy"
    And Verify the search result and filter by business type displays correctly
    And Click on read more on the search result item and verify the page navigates correctly
    Then Clear the filter criteria and verify the default page is displayed

  Scenario: Select the invalid business by type filter and verify the search results
    Given Select filter by Business type as invalid "Seccl" filter
    When  Click on the link from the result page
    Then Verify the user is able to navigate to the contact page "Contact us" successfully