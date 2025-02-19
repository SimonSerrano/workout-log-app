export default interface DeleteWorkoutLog {
  delete(workoutId: string): Promise<void>
}