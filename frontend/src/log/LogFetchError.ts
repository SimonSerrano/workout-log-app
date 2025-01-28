
export default class LogFetchError extends Error {
  constructor() {
    super('Could not fetch logs');
    Object.setPrototypeOf(this, LogFetchError.prototype);
  }
}