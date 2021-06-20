Feature: Searching for movie titles and researching about movie plot and cast

  Background: Common Steps
  			Given I open imdb website on browser
        When I enter search value in search bar

  Scenario Outline: Verifying search results are according to the search value
        Then I get the related suggestion list according to search value "<Suggestion Value>"
        Examples:
        |Suggestion Value|
        |Conjuring       |
    

	Scenario: Selecting suggestion from suggestions list 
        And I select a suggestion from the suggestion list
				Then I get navigated to the selected suggestion page
		
	Scenario: Verifying the plot details
        And I select a suggestion from the suggestion list
				Then I get navigated to the selected suggestion page
				And I get the plot of the searched value
				And I get the cast of the searched value
				