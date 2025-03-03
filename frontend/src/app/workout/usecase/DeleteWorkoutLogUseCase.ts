export default interface DeleteWorkoutLogUseCase {
  delete(workoutId: string): Promise<void>
}