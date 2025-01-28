import LogFetchError from "./LogFetchError";
import WorkoutLog from "./WorkoutLog";

class _LogService {
  constructor(private url = "http://localhost:8080/log") {
    
  }


  public async getLogs(): Promise<WorkoutLog[]> {
    const response = await fetch(this.url);
    if(!response.ok) {
      throw new LogFetchError();
    }

    return response.json();
  }
}

const LogService = new _LogService();
export default LogService ;