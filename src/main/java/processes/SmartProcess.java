package processes;

import dto.VectorDto;
import services.VectorService;

import java.util.ArrayList;
import java.util.List;

public class SmartProcess {
    private VectorService vectorService = new VectorService();

    public List<VectorDto> getPairs(){
        List<VectorDto> result = new ArrayList<>();
        List<VectorDto> temp = vectorService.findAll();
        for (int i = 0; i < temp.size() - 1; i++){
            result.add(temp.get(i));
            for (int j = i + 1; j < temp.size(); j ++){
                result.add(temp.get(j));
            }
        }
        return result;
    }
}
