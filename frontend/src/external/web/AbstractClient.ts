export default abstract class AbstractClient {
  protected url: string;
  constructor(){
    this.url = `http://localhost:8080${this.getPath()}`;
  }

  protected abstract getPath(): string;
}

