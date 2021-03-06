export interface IItem {
  id?: number;
  name?: string | null;
  price?: number | null;
}

export class Item implements IItem {
  constructor(public id?: number, public name?: string | null, public price?: number | null) {}
}

export function getItemIdentifier(item: IItem): number | undefined {
  return item.id;
}
