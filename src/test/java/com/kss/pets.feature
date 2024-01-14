Feature: Pets APIs

  @get_pets
  Scenario: Get all the PETS
    When I want to know all the pets in the clinic
    Then I should receive 14 pets

  @add_pets
  Scenario: Add a new PET
    When I send correct owner details with pet type and visit	details to add a new pet
      | OwnerID | FirstName | LastName | Address            | City    | Telephone  | PetTypeID | PetTypeName | PetID | PetName | PetDOB     |
      |       1 | George    | Franklin | 110 W. Liberty St. | Madison | 6085551023 |         1 | cat         |    14 | Meow    | 2023-01-01 |
    Then I get the successful response

  @add_vets
  Scenario Outline: Add vet to each speciality
    When I send correct vet details "<FirstName>" "<LastName>" <VetId> with <PetTypeID> and "<PetTypeName>" to create vet
    Then I get the successful response

    Examples: 
      | FirstName | LastName | VetId | PetTypeID | PetTypeName |
      | Levi      | James    |  1000 |         1 | cat         |
      | Bram      | Gerrit   |  1001 |         2 | dog         |
      | Tony      | Gin      |  1002 |         3 | lizard      |
      | George    | Kate     |  1003 |         3 | snake       |
      | Emma      | Finn     |  1004 |         5 | bird        |
      | Ema       | Jack     |  1005 |         6 | hamster     |
