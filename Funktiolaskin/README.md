# Funktiolaskin
Harhoitustyö kurssittelle Ohjelmistotekniikan menetelmät. Sovelluksen 
tarkoituksena on laskea yksinkertaisia funktioita ja muita 
laskutoimitukseia.

## Dokumentaatio

[Vaatimusmäärittely](https://github.com/eidzei/otm-harjoitustyo/blob/master/Funktiolaskin/dokumentointi/vaatimusmaarittely.md)

[Arkkitehtuurikuvaus](https://github.com/eidzei/otm-harjoitustyo/blob/master/Funktiolaskin/dokumentointi/arkkitehtuuri.md)

[Työaikakirjanpito](https://github.com/eidzei/otm-harjoitustyo/blob/master/Funktiolaskin/dokumentointi/tyoaikakirjanpito.md)

## Releaset

[Viikko 5] (https://github.com/eidzei/otm-harjoitustyo/releases/tag/viiko5)

## Komentorivitoiminnot

### Testaus
Testit suoritetaan komenolla

```
mvn test
```
 
Testikattavuusraportti luodaan komennolla

```
mvn jacoco:report
```
 
Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto 
_target/site/jacoco/index.html_

### Suoritettavan jarin generointi

Komento

```
mvn package
```

generoi hakemistoon _target_ suoritettavan jar-tiedoston _Funktiolaskin-1.0-SNAPSHOT.jar_

### Checkstyle

Tiedostoon [checkstyle.xml](https://github.com/eidzei/otm-harjoitustyo/blob/master/Funktiolaskin/checkstyle.xml) määrittelemät tarkistukset suoritetaan komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto _target/site/checkstyle.html_
