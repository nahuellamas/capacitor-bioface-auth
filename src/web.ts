import { WebPlugin } from '@capacitor/core';

import type { BiofaceAuthPlugin } from './definitions';

export class BiofaceAuthWeb extends WebPlugin implements BiofaceAuthPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    return options;
  }

  async authenticate(): Promise<{ authenticated: boolean }> {
    return { authenticated: true };
  }
}