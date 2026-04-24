Feature: Login en Sauce
   @Login
  Scenario: Usuario se loguea correctamente
    Given que el usuario abre la página de Sauce
    When ingresa sus credenciales válidas
    Then debería ver el inventario de productos

    @AnadirProducto
  Scenario: Usuario agrega un producto al carrito
    Given que el usuario ha iniciado sesión
    When agrega "Sauce Labs Backpack" al carrito
    And va al carrito de compras
    Then debería ver el carrito