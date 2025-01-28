export function formatCreationDate(date: string): string {
  return new Intl.DateTimeFormat(undefined, { dateStyle: 'long', timeStyle: 'medium' }).format(Date.parse(date));
}