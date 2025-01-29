
export default class LogWithEmptyValueError extends Error {
  constructor() {
    super('Cannot process log with empty values');
    Object.setPrototypeOf(this, LogWithEmptyValueError.prototype);
  }
}