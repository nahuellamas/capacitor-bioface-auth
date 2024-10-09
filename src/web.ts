import { WebPlugin } from '@capacitor/core';
import type { BiofaceAuthPlugin } from './definitions';

export class BiofaceAuthWeb extends WebPlugin implements BiofaceAuthPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }

  async authenticate(): Promise<{ authenticated: boolean }> {
    console.log('AUTHENTICATE');
    return { authenticated: true };
  }
}