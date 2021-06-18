Feature: Search and research functionality

  Scenario: Verifying search results are according to the search value
        Given User open imdb website on browser
        When User enter search value in search bar
        Then User get the related suggestion list
    

	Scenario: Selecting suggestion from suggestions list
				Given User open imdb website on browser
        When User enter search value in search bar
        And User select a suggestion from the suggestion list
				Then User get navigated to the selected suggestion page
		
	Scenario: Verifying the plot details
				Given User open imdb website on browser
        When User enter search value in search bar
        And User select a suggestion from the suggestion list
				Then User get navigated to the selected suggestion page
				And User get the plot of the searched value
				And User get the cast of the searched value