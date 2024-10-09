export interface BiofaceAuthPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
