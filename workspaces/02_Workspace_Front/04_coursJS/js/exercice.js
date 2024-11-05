/* Les variables de position en X et en Y
deviennent globales de sort à ce qu'elles
soient initalisées seulement une fois à zéro

La variable id devient globale afin que myStop()
puisse utiliser la méthode clearInterval sur celui-ci
*/
var posX = 0;
var posY = 0;
var id = null;
var elem = document.getElementById("animate");

function myMove() {
  // let id = null; --> variable locale devient globale

  // let posX = 0; --> devient globale
  // let posY = 0; --> devient globale
  clearInterval(id);
  id = setInterval(frame, 5); // La fonction frame est exécutée toutes les 5 ms


  function frame() {
    // Quand le carré a atteint le coin supérieur droit, le déplacer vers la gauche
    if (posX > 0 && posY == 0) {
      elem.style.background = 'blue';
      deplacerGauche();

      // Quand le carré a atteint le coin  inférieur droit, le déplacer vers le haut
    } else if (posX == 350 && posY > 0) {
      elem.style.background = 'green';
      deplacerHaut();

      // Sinon, parcourir la première diagonale du carré jaune
    } else {
      elem.style.background = 'red';
      deplacerBas();
      deplacerDroite();
    }
  }
}

function myStop() {
  clearInterval(id);
}

function deplacerGauche(){
  posX--;
  elem.style.left = posX + 'px';
}

function deplacerDroite(){
  posX++;
  elem.style.left = posX + 'px';
}

function déplacerHaut(){
  posY--;
  elem.style.top = posY + 'px';
}

function deplacerBas(){
  posY++;
  elem.style.top = posY + 'px';
}