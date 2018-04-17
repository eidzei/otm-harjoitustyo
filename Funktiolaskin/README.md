# Funktiolaskin
Harhoitustyö kurssittelle Ohjelmistotekniikan menetelmät. Sovelluksen 
tarkoituksena on laskea yksinkertaisia funktioita ja muita 
laskutoimitukseia.

## Dokumentaatio

[vaatimusmaarittely.md](https://github.com/eidzei/otm-harjoitustyo/blob/master/dokumentointi/vaatimusmaarittely.md)

[Tyoaikakirjanpito.md](https://github.com/eidzei/otm-harjoitustyo/blob/master/dokumentointi/tyoaikakirjanpito.md)

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

### Checkstyle

Tiedostoon [checkstyle.xml]() määrittelemät tarkistukset suoritetaan komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto _target/site/checkstyle.html_
