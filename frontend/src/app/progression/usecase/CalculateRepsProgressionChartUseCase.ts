import RepsProgressionChart from 
  '../entity/RepsProgressionChart';
import CalculateRepsProgChartDTO 
  from '../adapter/dto/CalculateRepsProgChartDTO';

export default interface CalculateRepsProgressionChartUseCase {
  calculate(dto: CalculateRepsProgChartDTO): RepsProgressionChart
}