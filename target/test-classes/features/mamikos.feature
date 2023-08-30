@mamikos
Feature: Mamikos

    Scenario: End to End mamikos
        Given open mamikos page
        When click masuk button
        And choose Pencari kos
        And click Daftar sekarang
        And input all field registarion
        And click cari iklan
        And choose kos
        Then will redirect to search page