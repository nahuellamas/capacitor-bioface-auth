import { registerPlugin } from '@capacitor/core';

import type { BiofaceAuthPlugin } from './definitions';

const BiofaceAuth = registerPlugin<BiofaceAuthPlugin>('BiofaceAuth', {
  web: () => import('./web').then((m) => new m.BiofaceAuthWeb()),
  ios: () => import('./ios').then((m) => new m.BiofaceAuthIOS()),
  android: () => import('./android').then((m) => new m.BiofaceAuthAndroid()),
});

export * from './definitions';
export { BiofaceAuth };

