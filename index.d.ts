declare module 'capacitor-bioface-auth' {
    export interface BiofaceAuthPlugin {
        echo(options: { value: string }): Promise<{ value: string }>;
        authenticate(): Promise<{ authenticated: boolean }>;
    }

    const BiofaceAuth: BiofaceAuthPlugin;
    export { BiofaceAuth };
}