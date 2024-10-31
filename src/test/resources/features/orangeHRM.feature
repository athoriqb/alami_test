@orange
Feature: OrangeHRM Leave Feature

  Background: Login as admin
    Given user login as admin

  Scenario: Verify able to apply leave until balance 0
    When user click leave
    And click apply tab
    And user request leave until balance 0
#    And user try applied leave
#    Then verify error messahe