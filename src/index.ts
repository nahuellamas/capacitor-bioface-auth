import { registerPlugin } from '@capacitor/core';

import type { BiofaceAuthPlugin } from './definitions';

const BiofaceAuth = registerPlugin<BiofaceAuthPlugin>('BiofaceAuth', {
  web: () => import('./web').then((m) => new m.BiofaceAuthWeb()),
});

export * from './definitions';
export { BiofaceAuth };
