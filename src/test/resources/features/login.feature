Feature: Login en Sauce

  Scenario: Usuario se loguea correctamente
    Given que el usuario abre la página de Sauce
    When ingresa sus credenciales válidas
    Then debería ver el inventario de productos