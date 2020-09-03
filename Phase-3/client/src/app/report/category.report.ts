export class CategoryReport {
  constructor(public totalItems: number,
              public category: string,
              public minPrice: string,
              public maxPrice: string,
              public averagePrice: string) {
  }
}
