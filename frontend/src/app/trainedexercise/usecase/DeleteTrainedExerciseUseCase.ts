export default interface DeleteTrainedExerciseUseCase {
  delete(workoutId: string, trainedId: number): Promise<void>
}