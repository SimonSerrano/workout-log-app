export default interface DeleteWorkoutLogPort {
  delete(workoutId: string): Promise<void>
}