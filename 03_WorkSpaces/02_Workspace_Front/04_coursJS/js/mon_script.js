// ceci est un commentaire d'une ligne
/* 
      Commentaire en bloc en js
      */

// alert("Bonjour tout le monde !"); // La bonne praatique est de terminer les insructions par ';'

// Ecrire du html dans mon document
// document.write("<h1>Bonjour tout le monde !</h1>");

// Afficher un message dans la console du navigateur
console.log("Bonjour tou le monde !");

// Changer le titre de mon document
document.title = "TOTO";

//====== Déclarer des variables en js
/* js est un langage faiblement typé, contrairement à Java */

var x;

x = 15; // Le type de la variable est reconnu selon la valeur qu'elle stocke

// Pour connaître le type d'une variable, on utilise typeof
console.log("le type de x est : " + typeof x);

/*
Les types primitifs en js:
number
boolean
string
undefined
null

Les types objet en js:
Object
Array
Date
RegExp
Function
*/

x = "TOTO"; // Changement du type de la variable -> Typage dynamique
console.log("le nouveau type de x est:" + typeof x);

// les opérateurs en js
// + - * / % && || < <= > >= == (égalité large) === (égalite stricte)

var y = 2 + 5;

console.log(y);

// La conversion implicite des types
y = 2 + "5";

console.log(y);

// Egalité large
var z = "5";

var w = 5;

console.log(z == w);
console.log(z === w);

// De même, on a la différence large != et la différence stricte !==

// On a aussi la pré- et post- incrémentation comme en java
// ** -> puissance

// Conversion explicite des types
// Conversion en int : parseInt

var o = parseInt(""); // Not a number
console.log(o);

var o = parseInt("145foo"); // Prend les premiers chiffres de la phrase

var o = parseInt("foo145"); // Not a Number !!!!!

// Pour déclarer une constante -> const
// Pour déclarer une variable globale -> var
// Pour déclarer une variable locale -> let

for (let i = 0; i < 3; i++) {
    console.log(i);
}

// ====== les structures de contrôle conditionnelles
/*
if else;
switch;
*/

/* Le moteur va traduire implicitatement la variable en true:
  - string non-vide
  - number !=0
  - undefined
  - null
  */

var cdt = null;

if (cdt) {
    console.log('----- block true');
} else {
    console.log('----- block false');
}

// Les boucles (structures itératives)

/*
for
while
do while

for in et for of <=> foreach en java
*/


// Les objets natifs de js
var dt = new Date();

console.log(dt);

// Appeler les méthodes de l'objet dt
console.log(dt.getDate());
console.log(dt.getDay());
console.log(dt.getFullYear());
console.log(dt.getMonth());

// Objet math
var s = "TOTO à Paris";

console.log("le caractère à l'index 0 est : " + s.charAt(0));
console.log("la taille de s est: " + s.length);

console.log(s.repeat(2));

var s1 = 'TOTO,Titi,RORO,FOFO';

var spl = s1.split(',');
console.log(spl);

var s2 = '  TOTO Titi RORO FOFO    ';
console.log(s2.trim());

// ===== Les tableaux en js
// Instanccier un tableau grâce à l'objet Array
/*
  Les tableaux en js sont de type objet qui contiennent de éléments
  de types différents et leur taille est dynamique
  les élémentss du tableau sont indéxés et l'index commence par 0
  */
var tab = new Array();

console.log('la taille de tab est: ' + tab.length);

var tab1 = new Array("un", 2, "trois");

var tab2 = ['un', 2, 'trois', 45.5];

console.log('la taille de tab2 est : ' + tab2.length);

// Récupérer un élément d'un tba2 par son index
console.log(tab2[0]);

// Ajouter des éléments à la fin du tableau
tab2.push('Quatre');

// Supprimer le dernier élément
tab2.pop();

// Parcourir le tableau avec la boucle for
for (let i = 0; i < tab2.length; i++) {
    console.log(tab2[i]);
}

// Parcourir le tableau avec la boucle for in (for each sur les index)
for (let indice in tab2) {
    console.log(tab2[indice]);
}

// Parcourir le tableau avec la boucle for in (for each sur les valeurs)
for (let elem of tab2) {
    console.log(elem);
}

//===== Les fonctions en js
// 1- Une fonction sans arguments
function marcher() {
    console.log('Je suis En Marche!');
}

marcher();

// 2- Une fonction avec des arguments en entrée
function add(a, b) {
    console.log(a + b);
}

add(1, 1); // et ça c'est beau

// 3- Une fonction avec des arguments en entrée et un retour
function soustraction(a, b) {
    return a - b;
}

var result = soustraction(5, 4);
console.log(result);

// 4- Les fonctions anonymes
var parler = function () {
    console.log('Je suis Charlie.');
}

parler();

// Utilisation d'une fonction anonyme
tab2.forEach(function (elem) { console.log(elem); });

// 5- Les expressions lambda
/*
(args) => {le corps de la fonction}
*/

var manger = () => { console.log("je mange") };
manger();
tab2.forEach((elem) => { console.log(elem); });

// 6- Imbrication des fonctions
/*
La fonction interne n'est vu qu'à l'intérieur de la fonction globale
*/

function maFonction(a, b) {
    // fonction interne
    function puissance(j) {
        return j ** 3;
    }
    // appel de la fonction interne
    return puissance(a) + b;
}

// Appel de la fonction globale maFonction
console.log(maFonction(3, 4));

//====== Les objets en js
var personne = {
    // Les propriétés d'un objet
    nom: 'TOTO',
    prenom: 'Titi',
    age: 26,

    // Des méthodes
    parler: function () {
        console.log("Je parle!");
    }
};

// Récupérer la valeur d'une propriété d'un objet
console.log('le nom de la personne est: ' + personne.nom);
console.log('le prénom de la personne est : ' + personne['prenom']);

// Appel d'une méthode (function) d'un objet
personne.parler();

// Parcourir les propriétés d'un objet avec for in
for (let prop in personne) {
    console.log(prop + " : " + personne[prop]);
}

//===== La gestion des évènements html
function afficher() {
    console.log("j'ai cliqué sur le bouton");
}

//===== Manipulation du DOM (Document Object Model)
// Comment on manipule les pages HTML à partir de js

// 1- Utilisation de l'id

function lireText() {
    // Récupérer l'objet du DOM qui correspond à la balise p par son id
    let x = document.getElementById('idP1');
    let y = x.innerText;
    console.log(y);

    // modifier le contenu textuel de la balise
    x.innerText = "TOTO à Baghdad.";
}

// 2- Utilisation de la class css
function lireTextByClass() {
    // récuperer les objets du DOM qui correspond aux balises par leur class css
    let x = document.getElementsByClassName('fofo');

    for (let elem of x) {
        console.log(elem.innerText);
    }
}

/* On a aussi document.getElementByTagName et document.getElementByName */

// Manipulation du contenu HTML
function manipHTML() {

    // Récupérer l'objet du DOM qui correspond à div par son
    let x = document.getElementById('idDiv');

    // modifier son contenu
    x.innerHTML = "<h1>TOTO à Paris</h1>";
}

// Manipulation du style
function changerStyle() {
    // récuperer l'objet du DOM qui correspond à p par son id
    let x = document.getElementById('idp2');

    // Modifier son style
    x.style.color = "red"; // modifier la couleur du texte

    x.style.fontSize = "25px"; // modifier la taille des caractères

    x.style.backgroundColor = 'aqua';
}

// Manipuler les images
function changerImage() {
    let x = document.getElementById('idimg');

    x.src = "./images/sopra.jpg"
}

function operation(a, b, result, operation) {

    let x = document.getElementById(a).value;
    let y = document.getElementById(b).value;
    let z = document.getElementById(result);

    switch (operation) {
        case 'add':
            z.value = parseInt(x) + parseInt(y);
            break;
        case 'sub':
            z.value = parseInt(x) - parseInt(y);
            break;
        case 'mul':
            z.value = parseInt(x) * parseInt(y);
            break;
        case 'div':
            z.value = parseInt(x) / parseInt(y);
            break;

    }

}