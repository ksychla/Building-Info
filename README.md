# Building-Info
Dla administratorów budynków, którzy pragną optymalizować koszty zarządzania budynkami. Nasza aplikacja Building Info umożliwia pozyskanie informacji o parametrach budynku na poziomie pomieszczeń, kondygnacji oraz całych budynków. Aplikacja jest dostępna poprzez GUI a także jako zdalne API dzięki czemu można ją zintegrować z istniejącymi narzędziami. 

![Travis](https://travis-ci.org/RenegadeWizard/Building-Info.svg?branch=master)

## Struktura budynku
* Lokacja to budynek, poziom (piętro), lub pomieszczenie
* Budynek może składać się z poziomów a te z pomieszczeń
* Każda lokalizacja jest charakteryzowana przez:
    * unikalny identyfikator
   * opcjonalna nazwa lokalizacji
* Pomieszczenie dodatkowo jest charakteryzowane przez:
   * powierzchnia w m^2
   * kubatura pomieszczenia w m^3
   * poziom zużycia energii ogrzewania (float)
   * łączna moc oświetlenia


## Struktura projektu
![UML diagram](UMLdiagram.jpg?raw=true "UML")

## Dokumentacja
https://renegadewizard.github.io/Building-Info/
