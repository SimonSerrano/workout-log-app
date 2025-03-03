export default abstract class AbstractClient {
  protected url: string;
  constructor(){
    this.url = `${window.location.origin}/api${this.getPath()}`;
  }

  protected abstract getPath(): string;
}

