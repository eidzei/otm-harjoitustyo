# Arkkitehtuurikuvaus

## Paukkausrakenne 
Ohjelman rakenne noudattaa kaksitasoista kerrosarkitehtuuria, ohjelman pakkausrakenne on seuraava:

<img src="https://github.com/eidzei/otm-harjoitustyo/blob/master/Funktiolaskin/dokumentointi/kuvat/pakkausrakenne.png" width="350">

Pakkaus _funktiolaskin.ui_ sisältää JavaFX:llä toteutetun käyttöliittymän ja _funktiolaskin.laskin_ sisältää sovelluslogiikan.
## Sovelluslogiikka
Sovelluksen loogisen datamallin muodostavat luokka [Calculator], sekä enumeraatiot [Operations] [Functions] [SecondFunctions]

<img src="https://github.com/eidzei/otm-harjoitustyo/blob/master/Funktiolaskin/dokumentointi/kuvat/sovelluslogiikka.png" width="450">

## Käyttöliittymä

Käyttöliittymä näkymiä on yksi, jossa kaksi eri sisältöä
-normaalit funktiot
-second napin takaa löytyvät funktiot

Käyttöliittymä on toteutettu [Scene](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/Scene.html)-oliona. Näkymät on sijoitettu [stageen](https://docs.oracle.com/javase/8/javafx/api/javafx/stage/Stage.html). Näkymän sisältöä pystyy vaihtamaan painamalla secondnappia. Käyttöliittymä on rakennettu ohjelmallisesti luokassa [funktiolaskin.ui.Interface](https://github.com/eidzei/otm-harjoitustyo/blob/master/Funktiolaskin/src/main/java/funktiolaskin/ui/Interface.java).

## Tiedostot
*Print a snapshot* nappi tallentaa näyttökuvan png muodossa nimella *funktiolaskin_snapshot.png* *Funktiolaskin-1.0-SNAPSHOT.jar* tiedoston omaavaan kansioon.

## Päätoiminnallisuudet

Kuvataan seuraavaksi sovelluksen toimintalogiikka muutaman päätoiminnallisuuden osalta sekvenssikaaviona.

### Operaatioiden laskeminen

Kun valitaan ensin luvuksi 2, valitaan oparaatioksi +, valitaan seuraavaksi luvuksi 1, painetaan on yhtä kuin nappia, etenee sovelluslogiikka seuraavasti:

<img src="https://github.com/eidzei/otm-harjoitustyo/blob/master/Funktiolaskin/dokumentointi/kuvat/kaksplusyks.png" width="450">

### Näyttökuvan ottaminen

Kun käyttäjä painaa *Print a snapshot* nappia, etenee sovelluslogiikka seuraavasti:

### Muut toiminnallisuudet
Funktioiden ja secondfunktioiden laskeminen on hyvin samankaltainen toiminnallisuus kuin operaatioden laskeminen. Käyttäjä valitsee luvun ja halutun funktion ja laskimen logiikka hoitaa laskun. Lisäksi käyttäjän on mahdollista tallentaa muuttuujaan x haluamiaan arvoja.

## Ohjelman rakenteeseen jääneet heikkoudet


