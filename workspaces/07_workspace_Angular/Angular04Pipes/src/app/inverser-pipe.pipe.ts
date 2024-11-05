import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'inverserPipe'
})
export class InverserPipePipe implements PipeTransform {

  transform(value: string): string {
    let nouvelleChaine='';

    for(let i=value.length-1;i>=0;i--){
      nouvelleChaine += value.charAt(i);
    }

    return nouvelleChaine;

  }

}
