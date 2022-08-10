@alami_test
Feature: Automation Elevania

  Scenario: End to end search product to delete product in shopping cart
    Given open elevania page
    When user choose produk terlaris
    And choose first product
    And add 3 quantity of product to shopping cart
    And choose shipping
    And click Batal
    And choose Hapus
    Then product deleted in shopping cart