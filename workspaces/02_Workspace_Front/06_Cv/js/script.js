/* Pour forcer le scroll de la page
à être positionné en haut lors 
du rafraîchissement de celle-ci*/
$(document).ready(function () {
    $(this).scrollTop(0);
});

function myMove() {

    var posX = 0;
    var posY = 0;
    var id = null;
    var posXSaut = 0; // Position au moment du saut --> Injectée dans l'équation de la cloche du saut
    var flagSaut = false; // Pour véfier si le personnage est en train de sauter ou non
    const hauteurSaut = 50;

    const elem = document.getElementById("animation");

    clearInterval(id);
    var flag = true;
    id = setInterval(frame, 5);
    s


    function frame() {
        posY = -5;

        // Si la touche espace est pressée, faire sauter le personnage !

        $(window).keypress(function (e) {
            if (e.key === 's') {
                e.preventDefault(); // Empêche d'activer le raccourci clavier associé à 's'
                posXSaut = posX;
                flagSaut = true;
            }
        })



        console.log(posY);

        if (flagSaut && flag) {
            posY = -1 / 2 * (posX - (posXSaut + Math.sqrt(2 * hauteurSaut))) ^ 2 + hauteurSaut;
            if (posX >= posXSaut + Math.sqrt(2 * hauteurSaut)) {
                flagSaut = false;
                posY = -5;
            }
        }


        if (flagSaut && !flag) {
            posY = -1 / 2 * (window.innerWidth - posX - (window.innerWidth - posXSaut - Math.sqrt(2 * hauteurSaut))) ^ 2 - hauteurSaut;
            if (posX <= posXSaut - Math.sqrt(2 * hauteurSaut)) {
                flagSaut = false;
                posY = -5;
            }
        }



        if (flag) {
            posX++;
            elem.style.left = posX + 'px';
            elem.style.bottom = posY + 'px';
        } else {
            posX--;
            elem.style.left = posX + 'px';
            elem.style.bottom = posY + 'px';
        }
        if (posX == window.innerWidth - 150) {
            elem.style.transform = "scaleX(-1)";
            flag = false;
        } else if (posX == 0) {
            elem.style.transform = "scaleX(1)";
            flag = true;
        }

    }
}

// Basculer de l'image de Kaaris à celle de Philippe Etchebest et inversément
function changePicture() {
    // Changer le boutton selon le personnage choisi
    if ($('#idImg').attr('src') == '../img/kaaris.png') {
        $('#button2').text('Change pour Kaaris !');
        $('#idImg').attr('src', '../img/etchebest.png');
    } else {
        $('#button2').text('Change pour Philippe Etchebest !');
        $('#idImg').attr('src', '../img/kaaris.png');
    }

}