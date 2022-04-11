Feature: Application Login 

Scenario: Home page default Login

Given I am on the Google search page
   When I search for "github"
   Then the page should start with "github"