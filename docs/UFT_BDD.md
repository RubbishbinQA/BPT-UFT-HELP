# EJECUCIÒN DE PRUEBAS CON CUCUMBER EN UFT

![BDD](https://unmesh.files.wordpress.com/2012/10/bdd.png)

## Ejemplo de lenguaje Gherkin

```javascript
Feature: Google Searching
  As a web surfer, I want to search Google, so that I can learn new things.
  
  Scenario: Simple Google search
    Given a web browser is on the Google page
    When the search phrase "RubbishbinQA" is entered
    Then results for "RubbishbinQA" are shown 
```