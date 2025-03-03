import CalculateRepsProgressionDTO 
  from '../../adapter/dto/CalculateRepsProgressionDTO';
import RepsProgressionChartResponse 
  from '../../adapter/dto/RepsProgressionChartResponse';

export default interface ProgressionClient {
  calculateRepsProgression(dto: CalculateRepsProgressionDTO): 
  RepsProgressionChartResponse
}