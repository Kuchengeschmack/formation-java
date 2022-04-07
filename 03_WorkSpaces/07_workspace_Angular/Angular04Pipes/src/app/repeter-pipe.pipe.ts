import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'repeterPipe'
})
export class RepeterPipePipe implements PipeTransform {

  transform(value: string, nb? :number): string {
    
    if(nb==undefined){
      return value;
    }

    value+=" ";

    return value.repeat(nb);
  }

}
