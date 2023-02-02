@api_test
  Feature: Api Test

    Scenario: Hit endpoint Register Successfull
      When hit POST register successfull
      Then Status code is 200
      And token not null