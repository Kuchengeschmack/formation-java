// ===== 1- Intérêt de JQuery

function cacherJs() {

    // récupérer les objets js correspondant aux balises hmtl
    let x = document.getElementsByTagName('h1');

    // parcourir le tableau x
    for (let elem of x){
        // cacher l'élément elem
        elem.style.display = 'none';
    }
}

// Utiliser jquery
/* 
La syntaxe de jquery
    $(selecteur_css)
     - $('nom_balise') <==> document.getElementsByTagName()
     - $('.nom_classCss') <=> document.getElementsByClassName()
     - $('#val_id') <=> document.getElementsById()
*/

function cacherJquery(){
    // Récupérer l'élément et appeler la fonction hide de jquery afin de le cacher
    $('h1').hide();
}

// ===== Utilisation des sélecteurs CSS

function useSelector(){
    // Récupérer l'élement du DOM par son id et lui appliquer une fonction jQuery
    // $('#idh2').hide();

    // Récupérer l'élément du DOM par sa classe css et lui appliquer une fonction jQuery
    // $('.toto').hide();

    // Récupérer l'élément du DOM par le nom de la balise et lui appliquer une fonction jQuery
    // $('h2').hide();

    // combiner des sélecteurs css
    // $('.toto, #idh2, h1').hide();

    $('div .toto').hide();
}

// ====== Manipuler les propriétés css
function manipulerCss(){
    // Récupérer l'élément par son id et lire la propriété css
    // let val=$('#idp1').css('color');
    // console.log("la valeur de la propriété style color est " + val);

    // Modifier la valeur de la propriété css
    // $("#idp1").css('color','blue');

    // modifier plusieurs propriétés de style
    $('#idp1').css({'color': 'aqua', 'fontsize':'30px'});
}

// ===== Manipuler les classes CSS
function ajouterClass(){
    // Récupérer l'élément par son id et lui ajouter une classe CSS
    $("#idp2").addClass('fofo');

    // ajouter plusieurs class css
    // $("idp2").addClass(['fofo', 'roro']);
}

function supprimerClass(){
    // Récupérer l'élément par son id et supprimer une class css
    $('#idp2').removeClass('fofo');
}

function alterClassCss(){
    // Récupérer l'élément par son id et ajouter/supprimer une classe css
    $('#idp2').toggleClass('fofo');
}

function changePicture(){
    let val = $('#idImg').attr('src');
    console.log(val);

    $('#idImg').attr('src', './images/sopra.jpg')
}