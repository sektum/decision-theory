package processes;

import dto.VectorDto;
import org.apache.commons.lang3.tuple.Pair;
import services.VectorService;

import java.util.ArrayList;
import java.util.List;

public class SmartProcess {
    private VectorService vectorService;

    public SmartProcess(VectorService vectorService)
    {
        this.vectorService = vectorService;
    }

    public SmartProcess()
    {
        this(new VectorService());
    }

    public List<Pair<VectorDto, VectorDto>> getPairs(){
        List<Pair<VectorDto, VectorDto>> result = new ArrayList<>();
        List<VectorDto> all = vectorService.findAll();
        for (int i = 0; i < all.size() - 1; i++){
            for (int j = i + 1; j < all.size(); j ++){
                result.add(Pair.of(all.get(i), all.get(j)));
            }
        }

        return result;
    }
}
