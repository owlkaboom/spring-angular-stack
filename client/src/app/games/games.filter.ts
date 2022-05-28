import { Pipe, PipeTransform } from '@angular/core';

@Pipe({ name: 'gamesFilter' })
export class GamesFilter implements PipeTransform {
  transform(items: any[], filters: string[]): any[] {
    if (!items) {
      return [];
    }

    if (!filters[0] && !filters[1]) {
      return items;
    }

    const filterData = {
      name: filters[0],
      difficulty: filters[1] ? parseInt(filters[1]) : undefined,
    };

    return items.filter((it) => {
      if (
        filterData.name &&
        !it.name.toLowerCase().includes(filterData.name.toLowerCase())
      ) {
        return false;
      }
      if (filterData.difficulty && it.difficulty !== filterData.difficulty) {
        return false;
      }

      return true;
    });
  }
}
