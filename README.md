# Building-Info
Dla administratorów budynków, którzy pragną optymalizować koszty zarządzania budynkami  nasza aplikacja Building Info umożliwi pozyskanie informacji o parametrach budynku na poziomie pomieszczeń, kondygnacji oraz całych budynków. Aplikacja będzie dostępna poprzez GUI a także jako zdalne API dzięki czemu można ją zintegrować z istniejącymi narzędziami. 

![Travis](https://travis-ci.org/RenegadeWizard/Building-Info.svg?branch=master)

## Struktura budynku
* Lokacja to budynek, poziom (piętro), lub pomieszczenie
* Budynek może składać się z poziomów a te z pomieszczeń
* Każda lokalizacja jest charakteryzowana przez:
    * id – unikalny identyfikator
   * name – opcjonalna nazwa lokalizacji
* Pomieszczenie dodatkowo jest charakteryzowane przez:
   * area = powierzchnia w m^2
   * cube = kubatura pomieszczenia w m^3
   * heating = poziom zużycia energii ogrzewania (float)
   * light – łączna moc oświetlenia

## Przykład użycia

Przykładowe wykorzystanie curl:
```bash
curl 127.0.0.1:8080/building/1/surface
curl -X POST -d "$(cat building.json)" 127.0.0.1:8080/building/create
curl 127.0.0.1:8080/building/1/get
```

Adresy URI wykorzystywane do komunikacji z REST API
```$xslt
127.0.0.1:8080/building/{id}/surface
127.0.0.1:8080/building/{id}/cubature
127.0.0.1:8080/building/{id}/heating
127.0.0.1:8080/building/{id}/wattage

127.0.0.1:8080/building/{id}/floorId/{id}/surface
127.0.0.1:8080/building/{id}/floorId/{id}/cubature
127.0.0.1:8080/building/{id}/floorId/{id}/heating 
127.0.0.1:8080/building/{id}/floorId/{id}/wattage 

127.0.0.1:8080/building/{id}/floorId/{id}/roomId/{id}/surface
127.0.0.1:8080/building/{id}/floorId/{id}/roomId/{id}/cubature
127.0.0.1:8080/building/{id}/floorId/{id}/roomId/{id}/heating
127.0.0.1:8080/building/{id}/floorId/{id}/roomId/{id}/wattage

127.0.0.1:8080/building/create 
127.0.0.1:8080/building/{id}/get 
```

## Struktura projektu
![UML diagram](UMLdiagram.jpg?raw=true "UML")

## Dokumentacja
https://renegadewizard.github.io/Building-Info/
