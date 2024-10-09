export interface BiofaceAuthPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  authenticate(): Promise<{ authenticated: boolean }>;
}
