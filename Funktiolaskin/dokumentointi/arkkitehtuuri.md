# Arkkitehtuurikuvaus

## Paukkausrakenne 
Ohjelman rakenne noudattaa kaksitasoista kerrosarkitehtuuria, ohjelman pakkausrakenne on seuraava:

<img src="https://github.com/eidzei/otm-harjoitustyo/blob/master/Funktiolaskin/dokumentointi/kuvat/pakkausrakenne.png" width="350">

Pakkaus _funktiolaskin.ui_ sisältää JavaFX:llä toteutetun käyttöliittymän ja _funktiolaskin.laskin_ sisältää sovelluslogiikan.
## Sovelluslogiikka

<img src="https://github.com/eidzei/otm-harjoitustyo/blob/master/Funktiolaskin/dokumentointi/kuvat/sovelluslogiikka.png" width="450">

## Käyttöliittymä

Käyttöliittymä näkymiä on kaksi
-normaalit funktiot
-second napin takaa löytyvät funktiot

Käyttöliittymä on toteutettu [Scene](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/Scene.html)-oliona. Näkymät on sijoitettu [stageen](https://docs.oracle.com/javase/8/javafx/api/javafx/stage/Stage.html). Näkymän pystyy vaihtamaan painamalla secondnappia. Käyttöliittymä on rakennettu ohjelmallisesti luokassa [funktiolaskin.ui.Interface](https://github.com/eidzei/otm-harjoitustyo/blob/master/Funktiolaskin/src/main/java/funktiolaskin/ui/Interface.java).

## Päätoiminnallisuudet

Kuvataan seuraavaksi sovelluksen toimintalogiikka muutaman päätoiminnallisuuden osalta sekvenssikaaviona.

### Operaatioiden laskeminen

Kun valitaan ensin luvuksi 2, valitaan oparaatioksi +, valitaan seuraavaksi luvuksi 1, painetaan on yhtä kuin nappia, etenee sovelluslogiikka seuraavasti:

<img src="https://github.com/eidzei/otm-harjoitustyo/blob/master/Funktiolaskin/dokumentointi/kuvat/kaksplusyks.png" width="450">


