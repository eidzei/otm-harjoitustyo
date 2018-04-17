# Funktiolaskin
Harhoitustyö kurssittelle Ohjelmistotekniikan menetelmät. Sovelluksen 
tarkoituksena on laskea yksinkertaisia funktioita ja muita 
laskutoimitukseia.

## Dokumentaatio

[Vaatimusmäärittely](https://github.com/eidzei/otm-harjoitustyo/blob/master/dokumentointi/vaatimusmaarittely.md)

[Arkkitehtuurikuvaus](https://github.com/eidzei/otm-harjoitustyo/blob/master/dokumentointi/arkkitehtuuri.md)

[Työaikakirjanpito](https://github.com/eidzei/otm-harjoitustyo/blob/master/dokumentointi/tyoaikakirjanpito.md)

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

Tiedostoon [checkstyle.xml](https://github.com/eidzei/otm-harjoitustyo/blob/master/Funktiolaskin/checkstyle.xml) määrittelemät tarkistukset suoritetaan komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto _target/site/checkstyle.html_
