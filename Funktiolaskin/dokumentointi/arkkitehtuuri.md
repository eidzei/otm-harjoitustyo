# Arkkitehtuurikuvaus

## Paukkausrakenne 
Ohjelman rakenne noudattaa kaksitasoista kerrosarkitehtuuria, ohjelman pakkausrakenne on seuraava:

<img src="https://github.com/eidzei/otm-harjoitustyo/blob/master/Funktiolaskin/dokumentointi/kuvat/pakkausrakenne.png" width="350">

Pakkaus _funktiolaskin.ui_ sisältää JavaFX:llä toteutetun käyttöliittymän ja _funktiolaskin.laskin_ sisältää sovelluslogiikan.
## Sovelluslogiikka
Sovelluksen loogisen datamallin muodostavat luokka [Calculator](https://github.com/eidzei/otm-harjoitustyo/blob/master/Funktiolaskin/src/main/java/funktiolaskin/laskin/Calculator.java), sekä enumeraatiot [Operations](https://github.com/eidzei/otm-harjoitustyo/blob/master/Funktiolaskin/src/main/java/funktiolaskin/laskin/Operations.java) [Functions](https://github.com/eidzei/otm-harjoitustyo/blob/master/Funktiolaskin/src/main/java/funktiolaskin/laskin/Functions.java) [SecondFunctions](https://github.com/eidzei/otm-harjoitustyo/blob/master/Funktiolaskin/src/main/java/funktiolaskin/laskin/SecondFunctions.java)

<img src="https://github.com/eidzei/otm-harjoitustyo/blob/master/Funktiolaskin/dokumentointi/kuvat/sovelluslogiikka.png" width="450">

Calculator saa ui:lta tiedon valituista operaatiosta, funktioista, sekä secondfunktioista. Lisäksi käytäjän valitseman luvut saadaan TextField olioina, jotka Calculator muuttaa String merkkijonoiksi ja poistaa ylimääräiset desismaalia seuraavat nollat. Lopuksi Calculator suorittaaa käyttäjän valiseman toiminnon ja päivittää näytön tekstikentän.

Ohjelman rakennetta kuvaava luokka/pakkauskaavio:

<img src="https://github.com/eidzei/otm-harjoitustyo/blob/master/Funktiolaskin/dokumentointi/kuvat/luokkapakkaus.png" width="450">

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

<img src="https://github.com/eidzei/otm-harjoitustyo/blob/master/Funktiolaskin/dokumentointi/kuvat/kaksplusyks.png" width="550">

Käyttäjä valitsee luvut ja operaatiot kutsumalla [NumberButtons](https://github.com/eidzei/otm-harjoitustyo/blob/master/Funktiolaskin/src/main/java/funktiolaskin/ui/NumberButtons.java) luokan metodeia numbers[2], nappi(+), numbers[1] ja equals(), jotka asettavat [Display](https://github.com/eidzei/otm-harjoitustyo/blob/master/Funktiolaskin/src/main/java/funktiolaskin/ui/Display.java) luokan TextFieldit settereillä setSecondary() ja setMain(). equals() kutsuu [Calculator](https://github.com/eidzei/otm-harjoitustyo/blob/master/Funktiolaskin/src/main/java/funktiolaskin/laskin/Calculator.java) metodia calculateOparation() Display luokan getMain(), getSecondary() ja Operatoins.ADD parametreilla. Calculator kutsuu Operations.ADD enumeraatiota ja laskee operaation ja palauttaa tuloksen.

### Näyttökuvan ottaminen

Kun käyttäjä painaa *Print a snapshot* nappia, etenee sovelluslogiikka seuraavasti:

<img src="https://github.com/eidzei/otm-harjoitustyo/blob/master/Funktiolaskin/dokumentointi/kuvat/printscreen.png" width="550">

[Printbutton](https://github.com/eidzei/otm-harjoitustyo/blob/master/Funktiolaskin/src/main/java/funktiolaskin/ui/PrintButton.java) kutsuu [Snapshot](https://github.com/eidzei/otm-harjoitustyo/blob/master/Funktiolaskin/src/main/java/funktiolaskin/snapshot/Snapshot.java) luokan metodia takeSnapShot antaen parametriksi [Interface](https://github.com/eidzei/otm-harjoitustyo/blob/master/Funktiolaskin/src/main/java/funktiolaskin/ui/Interface.java) luokan getterin getScene(). Snapshot kutsuu getScenellä scene, ja suorittaa metodin scene.snapsht(). Seuraavaksi Snapshot kokeilee, onnistuuko metodi ImageIO.write ja onnistuessa tallentaa tiedoston ja palauttaa true. PrintButton näyttää käyttäjälle "Snapshot otettu".

### Muut toiminnallisuudet
Funktioiden ja secondfunktioiden laskeminen on hyvin samankaltainen toiminnallisuus kuin operaatioden laskeminen. Käyttäjä valitsee luvun ja halutun funktion ja laskimen logiikka hoitaa laskun. Lisäksi käyttäjän on mahdollista tallentaa muuttuujaan x haluamiaan arvoja.

## Ohjelman rakenteeseen jääneet heikkoudet

Ohjelma ei osaa pyöristää toisinaan liukuluvuissa esiintyviä pyöristysvirheitä, esim. 0.9999999999...-> 1 oikein. Lisäksi ylemmässä tekstikentässä voisi näkyä useampi laskutoimitus/historia.
