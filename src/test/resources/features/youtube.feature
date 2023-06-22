@CP_GLOBAL
Feature: Como usuario de youtube
  quiero ingresar al aplicativo
  para validar sus diferentes funcionalidades.

  #Background:
    #Given el usuario ingresa a youtube

  @CP_001
  Scenario Outline: Iniciar sesion en Youtube
    When el usuario realiza login <email> <contrasena>
    Then el usuario visualiza el home page desde su cuenta

    Examples:
      | email                             | contrasena     |
      | qualityAutomatorCamiloE@gmail.com | PassGoogleTest |

  @CP_002
  Scenario Outline: Busqueda de cancion
    When el usuario realiza la busqueda de un tema <tema>
    Then el usuario visulaiza los diferentes resultados de busqueda <tema>

    Examples:
      | tema                 |
      | UB40 - Kingston Town |

  @CP_003
  Scenario: Validar Funciones reproducción/pausa y siguiente
    When el usuario selecciona un video en home page
    Then el usuario pausa reproduce y cambia el video

  @CP_004
  Scenario: Validar Funcion silenciar/activar sonido
    When el usuario selecciona un video en home page
    Then el usuario puede silenciar y activar el sonido del video


  @CP_005
  Scenario Outline: Suscripcion a canal
    Given el usuario realiza la busqueda de un canal <canal>
    When  el usuario se suscribe a el canal
    Then el usuario valida la suscripcion <canal>

    Examples:
      | canal       |
      | Julian Mesa |