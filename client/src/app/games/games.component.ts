import { Component, Input } from '@angular/core';

@Component({
  selector: 'games',
  templateUrl: './games.component.html',
})
export class GamesComponent {
  @Input() games: any[] = [];
  filterName: string = '';
  filterDiff: string = '';
}
