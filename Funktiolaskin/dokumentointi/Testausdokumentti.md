# Testausdokumentti

Ohjelmaa on testattu sekä automatisoiduin yksikkö- ja integraatiotestein JUnitilla sekä manuaalisesti tapahtunein järjestelmätason testein.

## Yksikkö- ja integraatiotestaus

### sovelluslogiikka

Automatisoitujen testien ytimen moudostavat laskimen eri enumeraatioden toimintaa testaavat yksikkötestit, joilla varmistetaan kunkin luokan oikea toiminta. [Funktio-](https://github.com/eidzei/otm-harjoitustyo/blob/master/Funktiolaskin/src/main/java/funktiolaskin/laskin/Functions.java), [operaatio](https://github.com/eidzei/otm-harjoitustyo/blob/master/Funktiolaskin/src/main/java/funktiolaskin/laskin/Operators.java)-, sekä [secondfuntioenumeraatioita](https://github.com/eidzei/otm-harjoitustyo/blob/master/Funktiolaskin/src/main/java/funktiolaskin/laskin/SecondFunctions.java) on testattu lukuisilla yksikkötesteillä, jotka testaavat operaatioilla ja funktioilla lasketut laskut. 

Integraatiotestit käyttävät [funktio-](https://github.com/eidzei/otm-harjoitustyo/blob/master/Funktiolaskin/src/main/java/funktiolaskin/laskin/Functions.java), [operaatio](https://github.com/eidzei/otm-harjoitustyo/blob/master/Funktiolaskin/src/main/java/funktiolaskin/laskin/Operators.java)-, sekä [secondfuntioenumeraatioita](https://github.com/eidzei/otm-harjoitustyo/blob/master/Funktiolaskin/src/main/java/funktiolaskin/laskin/SecondFunctions.java), sekä laskimen [logiikkaa](https://github.com/eidzei/otm-harjoitustyo/blob/master/Funktiolaskin/src/main/java/funktiolaskin/laskin/Calculator.java). Logiikka kutsuu enemuraatioita useissa testeissä ja testaa, muuttuvatko laskut oikeiksi merkkijonoiksi.

Laskimen logiikan muuta toiminnallisuutta, kuten nollien poistoa testattu muutamilla yksikkötesteillä


### Testauskattavuus

Käyttöliittymäkerrosta lukuunottamatta sovelluksen testauksen rivikattavuus on 100% ja haarautumakattavuus 91%

<img src="https://github.com/eidzei/otm-harjoitustyo/blob/master/Funktiolaskin/dokumentointi/kuvat/testikattavuus.png" width="800">

Lasku 1/0 testattu, mutta ei jostain syystä näy haarautumakattavuudessa. 

## Järjestelmätestaus

Sovelluksen järjestelmätestaus on suoritettu manuaalisesti.

### Asennus ja kanfigurointi

Sovellus on haettu ja sitä on testattu [käyttöohjeen](https://github.com/mluukkai/OtmTodoApp/blob/master/dokumentaatio/kayttoohje.md) kuvaamalla tavalla OSX-ympäristöön.

### Toiminnallisuudet

Kaikki [määrittelydokumentin](https://github.com/eidzei/otm-harjoitustyo/blob/master/Funktiolaskin/dokumentointi/Testausdokumentti.md) ja käyttöohjeen listaamat toiminnallisuudet on käyty läpi. Kokeiltu myös haastavilla luvuilla.

## Sovellukseen jääneet laatuongelmat

Hyvin suurilla luvuilla nollien poistossa saattaa esiintyä ongelmia.

