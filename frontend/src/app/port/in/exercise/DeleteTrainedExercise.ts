export default interface DeleteTrainedExercise {
  delete(workoutId: string, trainedId: number): Promise<void>
}