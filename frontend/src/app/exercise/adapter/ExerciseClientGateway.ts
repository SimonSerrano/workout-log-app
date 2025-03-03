import Exercise from '../entity/Exercise';

export default interface ExerciseClientGateway {
  list(): Promise<Exercise[]>
}