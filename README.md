# Building-Info
Dla administratorów budynków, którzy pragną optymalizować koszty zarządzania budynkami  nasza aplikacja Building Info umożliwi pozyskanie informacji o parametrach budynku na poziomie pomieszczeń, kondygnacji oraz całych budynków. Aplikacja będzie dostępna poprzez GUI a także jako zdalne API dzięki czemu można ją zintegrować z istniejącymi narzędziami. 

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

## Przykład użycia

Przykładowe wykorzystanie curl:
```bash
curl -X POST -d "$(cat building.json)" 127.0.0.1:8080/building/surface
curl -X POST -d "$(cat building.json)" 127.0.0.1:8080/building/floor/2/cubature
curl -X POST -d "$(cat building.json)" 127.0.0.1:8080/building/floor/2/room/4/wattage
```

Adresy URI wykorzystywane do komunikacji z REST API
```$xslt
127.0.0.1:8080/building/surface
127.0.0.1:8080/building/cubature
127.0.0.1:8080/building/heating
127.0.0.1:8080/building/heating3
127.0.0.1:8080/building/wattage
127.0.0.1:8080/building/wattage2

127.0.0.1:8080/building/floor/{id}/surface
127.0.0.1:8080/building/floor/{id}/cubature
127.0.0.1:8080/building/floor/{id}/heating
127.0.0.1:8080/building/floor/{id}/heating3  
127.0.0.1:8080/building/floor/{id}/wattage 
127.0.0.1:8080/building/floor/{id}/wattage2 

127.0.0.1:8080/building/floor/{id}/room/{id}/surface
127.0.0.1:8080/building/floor/{id}/room/{id}/cubature
127.0.0.1:8080/building/floor/{id}/room/{id}/heating
127.0.0.1:8080/building/floor/{id}/room/{id}/heating3
127.0.0.1:8080/building/floor/{id}/room/{id}/wattage
127.0.0.1:8080/building/floor/{id}/room/{id}/wattage2

127.0.0.1:8080/building/more/{maxLevel}
```

## Dokumentacja

https://renegadewizard.github.io/Building-Info/javadoc/index.html