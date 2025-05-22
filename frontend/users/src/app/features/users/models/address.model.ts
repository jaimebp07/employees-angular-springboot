import { Geo } from './geo.model';

export interface Address {
  street: string;
  suite: string;
  city: string;
  zipCode: string; // Se mantiene el camelCase como convención en TS
  geo: Geo;
}
