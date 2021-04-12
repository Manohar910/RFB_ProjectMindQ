Feature: Role creation

  Scenario Outline: Verifying role creation with multiple sets of data
    
    Given: Tester should on Ranford homepage
    When: Tester enters username and password
    Then: Tester validates login functionality
    
    When: Tester clicks on role button
    When: Tester enteres "<RoleName>" and "<RoleDesc>" and "<RoleType>" and click on submit
    Then: Tester close the application
    
    Examples: 
     | RoleName | RoleDesc | RoleType |
     | ManagerCb | gjgjhkjhk | E |
     | Managergh | hgjgjhkjh | E |
     | Managergf | tfhggvjjc | E |

